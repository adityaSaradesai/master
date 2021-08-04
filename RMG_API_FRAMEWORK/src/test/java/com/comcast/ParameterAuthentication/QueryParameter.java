package com.comcast.ParameterAuthentication;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class QueryParameter {
	@Test
	public void queryparam() {
		
	
	baseURI="https://reqres.in/";
	given()
	.queryParam("page", 2)
	.when().get("/api/users")
	.then()
	.assertThat()
	//used matchers from hamcrest since we dont have method to validate response time in rest assure
	.time(Matchers.lessThan(500L),TimeUnit.SECONDS)
	.assertThat().statusCode(200)
	.log().all();
	}
	
	

}
