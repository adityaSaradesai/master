package practice.bdd;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutMethodusingjsonfile {
	@Test
	public void putusingjson() {
		
		File file=new File("./CreateProject.json");
		given()
		.contentType(ContentType.JSON).body(file)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1214")
		.then()
		.log().all()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200);
			
		
	}

}
