package com.TY.RMG.Projects;

import org.openqa.selenium.remote.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.GenericUtils.BaseApiClass;
import com.comcast.GenericUtils.DataBaseUtilities;
import com.comcast.GenericUtils.EndPoint;
import com.comcast.GenericUtils.JavaUtilities;
import com.comcast.GenericUtils.RestAssuredUtility;
import com.comcast.POJOClass.ProjectLibrary;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;





public class CreateProjectWithCreatedStatusAndValidateINDBTest extends BaseApiClass {

	@Test
	public void createProjectWithCreatedStatusAndValidateINDBTest() throws Throwable  {
		JavaUtilities jLib = new JavaUtilities();
		RestAssuredUtility rLib = new RestAssuredUtility();
		DataBaseUtilities dLib =new DataBaseUtilities();


		//create project with created status using POJO class

		ProjectLibrary projectLibrary = new ProjectLibrary("Adityas","sony"+jLib.randomNumber(),"created",20);

		io.restassured.response.Response response = given()
				.contentType(ContentType.JSON)
				.body(projectLibrary)
				.when()
				.post(EndPoint.addProject);

		//capture the project id
		String firstProjectId = rLib.jsonPathConstant(response,"projectId");

		String actProjName = rLib.jsonPathConstant(response,"projectName");
		System.out.println(firstProjectId);
		System.out.println(actProjName);

		//verify the project id in the data base
		dLib.connectToDB();
		String Query="select * from project";


		String expData = dLib.executeQueryAndGetData(Query,1,firstProjectId);      
		String expName= dLib.executeQueryAndGetData(Query,4,actProjName);

		//validation

		Assert.assertEquals(firstProjectId,expData);
		Assert.assertEquals(actProjName,expName);



	}

}
