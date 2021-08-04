package com.comcast.create;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ValidateStaticResponseinReqResTest {

	@Test
	public void staticResponse() {
		//expected data initialization
		String expectedData="cerulean";
		//getting the resource from the server
		Response response = when()
				.get("http://reqres.in/api/unknown");    // https://reqres.in/
		//verification of status code
		response.then().statusCode(200).log().all();
		//capture the specific data from response body
		String actualData = response.jsonPath().get("data[0].name");  
		System.out.println("expected data is : "+expectedData);
		System.out.println("actual data is:  "+actualData);
		//testng assertion for actual and expected data 
		Assert.assertEquals(actualData,expectedData);
		
		
		
	}

}


