package com.comcast.ParameterAuthentication;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class BearerAuthAuthentication {
	@Test
	public void bearerAuth() {
		HashMap map=new HashMap();
		map.put("name", "Adityass45");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		.when()
		.post("https://api.github.com/user/repos")
		.then()
		.log().all();
		
	}

}
