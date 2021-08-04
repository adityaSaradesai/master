package com.comcast.ParameterAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class RequestChainPostGetPutDelete {
	@Test
	public void RequestChainingPGPD() {
		baseURI="http://localhost";
				port=8084;
		ProjectLibrary projectLibrary = new ProjectLibrary("AdithySaradesai","RMGYANTRA_140","completed",42);
		
		//create the project
		Response response = given()
		.contentType(ContentType.JSON)
		.body(projectLibrary)
		.when()
		.post("/addProject");
		   response.then().statusCode(201).log().all();
		
		//capture the project id
		String firstProject=response.jsonPath().get("projectId");
		
		//get the project
		given()
		.pathParam("projectid",firstProject)
		.when()
		.get("/projects/{projectid}")
		.then()
		.statusCode(200)
		.log().all();
		
		//change the project values
		ProjectLibrary projectLibrary1=new ProjectLibrary("AnupDesai1","rmpgyt896","ongoing",53);
				given()
			.contentType(ContentType.JSON)
				.body(projectLibrary1)
				.pathParam("project",firstProject)
				.when()
				.put("/projects/{project}")
				.then()
				.statusCode(200)
				.log().all();
				
				//delete the project
				given()
				.pathParam("project12",firstProject)
				.when()
				.delete("/projects/{project12}")
				.then()
				.statusCode(204)
				.log().all();
				
				
				
				
		
		
		
		
		
		
		
		
	}

}
