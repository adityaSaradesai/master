package practice.bdd;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Delete_ProjectBdd {
	@Test
	public void deletepeoject() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_003")
		.then()
		.log().all()
		.assertThat().statusCode(204)
		.assertThat().contentType(ContentType.JSON);
	}

}
