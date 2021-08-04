package Rmg.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_oneProject {
	
	
   @Test
   
   public void DeleteProjects() {
	   Response resp=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1002");
		String respBody=resp.asString();
		System.out.println(respBody);
		String preettyRespBody=resp.prettyPrint();
		System.out.println(preettyRespBody);
		
		int actStatusCode = resp.getStatusCode();
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode,204);
		
		String actContentType = resp.getContentType();
		System.out.println(actContentType);
		Assert.assertEquals(actContentType,"application/json");
	   
   }

}
