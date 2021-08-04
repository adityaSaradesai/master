package com.comcast.ParameterAuthentication;



import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Authentication {
  @Test
  public void auth2Authentication() {
	 
	  //provide the client id and client secret to generate the token
	  Response resp = given()
	  .formParam("client_id","Adityas")
	  .formParam("client_secret","c667f86bd2b2564cc3bd07d083e81b3c")
	  .formParam("grant_type","client_credentials")
	  .formParam("redirect_uri","http://adityas.com")
	  
	  //generate the token
	  .when()
	  .post("http://coop.apps.symfonycasts.com/token");
	  System.out.println(resp.asString());
	 String mytoken = resp.jsonPath().get("access_token");
	 
	 //use this api in any API
	 given()
	 .auth()
	 .oauth2(mytoken)
	 .pathParam("USER_ID","2107")
	 .when()
	 .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
	 .then()
	 .log().all();
	  
		  
		  
	  
	  
	  
	  
	  
  }
}
