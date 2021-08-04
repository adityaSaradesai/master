package com.comcast.ParameterAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test  ;

import io.restassured.response.Response;

//here we are creating one request and deleting that same request

public class RequestChain {                
	@Test
	public void requestChaining() {
		baseURI="http://localhost";
		port=8084;
		//get all projects
		 Response response = when()
				 .get("/projects");
				 
				 //capture any id
				String firstProjectid = response.jsonPath().get("[0].projectId");
				System.out.println(firstProjectid);
				
				//delete the project
				given()
				.pathParam("projectid",firstProjectid )
				.when()
				.delete("/projects/{projectid}")
				.then()
				.assertThat().statusCode(204)
				.log().all();
				
						
				
				 
		
		
	}

}
