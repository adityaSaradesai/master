package com.comcast.create;

import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;

import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

public class CreateProjectUsingPojoTest {
	@Test
	
	public void createProject() {
		ProjectLibrary ProjectLibrary = new ProjectLibrary("Aditya", "sdet_11125555555555555555", "ongoing",42);
		given().contentType(ContentType.JSON).body(ProjectLibrary)
		.when().post("http://localhost:8084/addProject")
		.then().log().all().assertThat().statusCode(201).contentType(ContentType.JSON);
		
	
	}

}
