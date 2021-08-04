package ApiTestCase;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.comcast.GenericUtils.BaseApiClass;

import io.restassured.http.ContentType;

public class CreateTheProjectWithStatusCreated  {
	@Test
	public void ProjectWithStatusCreated() {
		 JSONObject jobj = new JSONObject();
		jobj.put("createdBy","Aaditya");
		jobj.put("projectName","RMGGY");
		jobj.put("status","created");
		jobj.put("teamSize", 23);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
	}

}
