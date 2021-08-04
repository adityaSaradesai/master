package com.comcast.create;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ValidateDynamicResponseReqRes {
	@Test
	public void dynamicResponseReqRes() {
		String expectedData="Ferguson";
		String actualData=null;
		  Response response = when()
				  .get("https://reqres.in/api/users?page=2");  
		  response.then().statusCode(200).log().all();
		  List<String> list = response.jsonPath().get("data.last_name");
		  boolean flag=false;
		  for( String data: list) {
			  if(data.equals(expectedData)) {
				  actualData=data;
				  flag=true;
				  System.out.println("value is present :  "+actualData);
				  break;
				  
				  
			  } 
		  }
		  
		  Assert.assertEquals(flag, true);
			Assert.assertEquals(actualData, expectedData);
		  
	}
}
