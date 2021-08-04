package Rmg.practice;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCreateProject {
	
	@Test
	public void createProject()  {
		JSONObject jObject=new JSONObject();
		jObject.put("createdBy","Aditya");
		jObject.put("projectName","Bombay");
		jObject.put("status","completed");
		jObject.put("teamSize",12);
		
		RequestSpecification reqSpec=RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jObject);
		Response resp=reqSpec.post("http://localhost:8084/addProject");
		resp.prettyPrint();
		
		Assert.assertEquals(resp.getStatusCode(), 201);
		
		
		
	}

}
