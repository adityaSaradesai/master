package practice.bdd;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostCreateProject {
	
	
	@Test
	public void createProject() {
		JSONObject jObject=new JSONObject();
		jObject.put("createdBy","Aditya");
		jObject.put("projectName","Mumbai");
		jObject.put("status","completed");
		jObject.put("teamSize",12);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObject)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat().contentType(ContentType.JSON);
		
		
		
	}

}
