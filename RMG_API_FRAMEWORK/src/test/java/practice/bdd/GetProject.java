package practice.bdd;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProject {
	@Test
	public void getproject() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		.log().all()
		.and()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON);
		
	}

}
