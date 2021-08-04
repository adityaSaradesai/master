package practice.bdd;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class create_Project_Hashmap {
	@Test
	public void postprojectHashmap() {
	
    HashMap	map=new HashMap();
  map.put("createdBy","Aditya");
  map.put("projectName","sdet_18_project");
  map.put("status","completed");	
  map.put("teamsize","12");
  given().contentType(ContentType.JSON).body(map)
  .when().post("http://localhost:8084/addProject")
  .then().log().all().assertThat().statusCode(201)
  .assertThat().contentType(ContentType.JSON);
}
}