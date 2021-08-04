package com.TY.RMG.Projects;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class CraeteProjectWithCreateStatusAndValidateInDB {
	@Test
	public void craeteProjectWithCreateStatusAndValidateInDB() throws SQLException {
		Random random = new Random();
		int ran = random.nextInt(1000);
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary projectLibrary = new ProjectLibrary("Adityaas","ty_457"+ran,"completed",20);
		 Response response = given()
		.contentType(ContentType.JSON)
		.body(projectLibrary)
		.when()
		.post("/addProject");
		 
		 
		 //capture the project id
		 String firstProject=response.jsonPath().get("projectId");
		 System.out.println(firstProject);
		 //verify the project id in database
		 
		 //step1 :register the db
		 Driver driver = new Driver();
		 DriverManager.registerDriver(driver);
		 
		 //step2:get connection with database
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		//step3:issue create statement
		Statement statement = conn.createStatement();
		
		//execute query
		ResultSet result = statement.executeQuery("select * from project");
		String expData = null;
		while(result.next())
		{
			if(result.getString(1).equals(firstProject)) {
				expData=result.getString(1);
			System.out.println("project id is successfully verified in database");
			break;
		}
		}
		Assert.assertEquals(firstProject,expData);
		//close db
		conn.close();
	}
		 
		
		
	}


