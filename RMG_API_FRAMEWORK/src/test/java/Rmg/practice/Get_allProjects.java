package Rmg.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_allProjects {
	
	@Test
	public void getallprojects() {
		Response resp=RestAssured.get("http://localhost:8084/projects");
	 String respBody = resp.asString();
		System.out.println(respBody);
		String preettyRespBody=resp.prettyPrint();
		System.out.println(preettyRespBody);
		
		int actStatusCode = resp.getStatusCode();
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode,200);
		
		String actContentType = resp.getContentType();
		System.out.println(actContentType);
		Assert.assertEquals(actContentType,"application/json");
		
		
	}

}
