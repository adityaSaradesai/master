package com.comcast.GenericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



import static io.restassured.RestAssured.*;



public class BaseApiClass {

	DataBaseUtilities dbUtil= new DataBaseUtilities();

	@BeforeSuite
	public void bsCconfig() throws Throwable
	{
		baseURI="http://localhost";
		port=8084;

		dbUtil.connectToDB();
	}

	@AfterSuite
	public void asConfig() throws Throwable {

	dbUtil.closeDB();
	}
} 


