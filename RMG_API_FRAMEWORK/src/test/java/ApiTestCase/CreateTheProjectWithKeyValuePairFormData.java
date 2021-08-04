package ApiTestCase;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class CreateTheProjectWithKeyValuePairFormData {
	@Test
	public void createTheProjectUsingFormData()  {
		
		HashMap map=new HashMap();
		map.put("createdBy","Akshay");
		map.put("projectName","Rmkyy52");
		map.put("status","created");
		map.put("teamSize",20);
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://localhost:8084/addProject")
		.then().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}
}