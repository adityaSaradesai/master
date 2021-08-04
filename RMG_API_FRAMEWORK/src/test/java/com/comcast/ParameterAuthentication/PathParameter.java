package com.comcast.ParameterAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameter {
	@Test
	public void pathParam()  {
		baseURI="http://localhost";
		port=8084;
		
		given()
		.pathParam("project_id", "TY_PROJ_1207")
		.when()
		.get("/projects/{project_id}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
	

}
