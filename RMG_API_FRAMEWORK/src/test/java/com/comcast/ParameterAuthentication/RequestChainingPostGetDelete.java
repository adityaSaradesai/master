package com.comcast.ParameterAuthentication;



import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingPostGetDelete {
	@Test
	public void requestChaining()  {
		baseURI="http://localhost";
		port=8084;
		ProjectLibrary projectLibrary = new ProjectLibrary("Anant","RMGY_245","craeted",20);  
		//create the project
		 Response response = given()
		.contentType("application/json")
		.body(projectLibrary)
		.when()
		.post("/addProject");
		System.out.println(response.asString());
		
		//capture project id
		String firstProject = response.jsonPath().get("projectId");
		System.out.println(firstProject);
		
		//delete the project
		given()
		.pathParam("projectid",firstProject)
		.when()
		.delete("/projects/{projectid}")
		.then()
		.assertThat().statusCode(204);
		
		
		
		
				
		
		 
		
	}

}
