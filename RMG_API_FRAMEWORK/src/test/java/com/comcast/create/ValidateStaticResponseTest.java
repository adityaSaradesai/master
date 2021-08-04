package com.comcast.create;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ValidateStaticResponseTest {
	
	@Test
	public void staticResponse() {
		//expected data initialization
		String expectedData="Mumbai";
		//getting the resource from the server
		Response response = when()
				.get("http://localhost:8084/projects");    // https://reqres.in/
		//verification of status code
		response.then().statusCode(200).log().all();
		//capture the specific data from response body
		String actualData = response.jsonPath().get("[10].projectName");
		System.out.println("expected data is : "+expectedData);
		System.out.println("actual data is:  "+actualData);
		//testng assertion for actual and expected data 
		Assert.assertEquals(actualData,expectedData);
		
		
		
	}

}
