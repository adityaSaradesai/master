package com.TY.RMG.Projects;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GetProjectVerifyDeleteAndVerifyTest {
	@Test
	public void getProjectVerifyDeleteAndVerifyTest() throws SQLException {
		
		baseURI="http://localhost";
		port=8084;
		
		//get all project
		Response response=when()
				.get("/projects");
				response.then()
				.contentType(ContentType.JSON)
				.statusCode(200);
				
				
		//capture id
		String firstProject=response.jsonPath().get("[0].projectId");
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
		
		//delete the project
		given()
		.pathParam("proj",firstProject)
		.when()
		.delete("projects/{proj}")
		.then()
		.statusCode(204);
		
		//verify that project is deleted or not
		while(result.next())
		{
			if(!(result.getString(1).equals(firstProject))) {
				expData=result.getString(1);
			System.out.println("project is successfully deleted in database");
			break;
		}
		}
	conn.close();
		
		
	}

}
