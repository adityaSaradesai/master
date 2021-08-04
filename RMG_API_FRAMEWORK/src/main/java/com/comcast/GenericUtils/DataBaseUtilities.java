package com.comcast.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtilities {
	Connection con=null;
	ResultSet result=null;
	/**
	 * this method will establish connection with database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		Driver driverRef;
		try
		{
			 driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection(IConstantsAndPath.dbUrl,IConstantsAndPath.dbUserName,IConstantsAndPath.dbPassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
			
		}
	/**
	 * This method will close database connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	
	}
	/**
	 * This method helps to verify data in database
	 * @param query
	 * @param coloumnName
	 * @param expData
	 * @returns
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query,int columnIndex,String expData) throws Throwable 
	{
		boolean flag=false;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			
				if(result.getString(columnIndex).equalsIgnoreCase(expData))
				{
					flag=true;
					break;
					
				}
			
				
			}
		
		if(flag)
		{
			System.out.println(expData +"data is verified in database");
			return expData;
		}
		else
		{
			System.out.println(expData +"data not verified");
		    return expData;
		
	}
	}
	

}
