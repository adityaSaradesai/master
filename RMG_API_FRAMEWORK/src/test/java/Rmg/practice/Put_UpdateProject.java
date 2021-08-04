package Rmg.practice;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put_UpdateProject {
	
	@Test
	public void UpdateProjects() {
		JSONObject jObject=new JSONObject();
		jObject.put("createdBy","Aditya");
		jObject.put("projectName","sdte_188");
		jObject.put("status","completed");
		jObject.put("teamSize",12);
		
		RequestSpecification reqSpec=RestAssured.given();
		
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jObject);
		Response resp=reqSpec.put("http://localhost:8084/projects/TY_PROJ_610");
		
		resp.prettyPrint();
		Assert.assertEquals(resp.getStatusCode(),200);
	
		
		
	}

}
