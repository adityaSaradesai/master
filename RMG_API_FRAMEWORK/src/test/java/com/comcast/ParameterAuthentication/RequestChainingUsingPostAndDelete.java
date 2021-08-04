package com.comcast.ParameterAuthentication;


import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;


import io.restassured.response.Response;


import static io.restassured.RestAssured.*;



public class RequestChainingUsingPostAndDelete {
	@Test
	public void requestChainPostAndDelete()  {
		//post
		baseURI="http://localhost";
		port=8084;
		ProjectLibrary projectLibrary=new ProjectLibrary("AdityaA","TYSS_988","ongoing",20);
		 Response response = given()
		.contentType("application/json")
		.body(projectLibrary)
		.when()
		.post("/addProject");
		  System.out.println(response.asString());
		    
	    
			//capture id
			String myproject = response.jsonPath().get("projectId");
			System.out.println(myproject);
			
			//delete the project
			given()
			.pathParam("projId",myproject)
			.when()
			.delete("/projects/{projId}")
			.then()
			.assertThat().statusCode(204)
			.log().all();
			
					
			
			 
			
			
		
		
			
		
				
		
				
		
	}

}
