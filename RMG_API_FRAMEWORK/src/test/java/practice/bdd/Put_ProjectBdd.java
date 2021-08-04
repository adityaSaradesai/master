package practice.bdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Put_ProjectBdd {
	@Test
	public void updateProject() {
		JSONObject jObject=new JSONObject();
		jObject.put("createdBy","Aditya");
		jObject.put("projectName","sdett123");
		jObject.put("status","completed");
		jObject.put("teamSize",12);
		
		given()
		.contentType(ContentType.JSON)
		.body(jObject)
		.put("http://localhost:8084/projects/TY_PROJ_004")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200);
		
		

	}
	

}
