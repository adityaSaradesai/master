package com.comcast.create;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.POJOClass.ProjectLibrary;

import io.restassured.http.ContentType;

public class CreateMultipleProjectsUsingDataprovider {
	@Test(dataProvider="getData")
	
	
		public void createMultipleProject(String createdBy,String projectName,int teamSize )
		{
			baseURI="http://localhost";
			port=8084;
			ProjectLibrary projectLibrary=new ProjectLibrary(createdBy, projectName,"completed", teamSize);
			given().contentType(ContentType.JSON)
			.body(projectLibrary)
			.when().post("/addProject")
			.then()
			.log().all()
			.assertThat().statusCode(201);
			
		}
		@DataProvider
		public Object[][] getData()
		{
			Object[][] obj=new Object[5][3];
			obj[0][0]="Aditya";
			obj[0][1]="TYSS15424";
			obj[0][2]=12;
			
			
			obj[1][0]="ANUP";
			obj[1][1]="TYSS487557";
			obj[1][2]=13;
			
		    obj[2][0]="Arun";
			obj[2][1]="TYSS17878777";
			obj[2][2]=12;
			
			
			obj[3][0]="Arvind";
			obj[3][1]="TYSS1284447";
			obj[3][2]=147;
			
			
			obj[4][0]="Ganesh";
			obj[4][1]="TYSS1547";
			obj[4][2]=1145;
			return obj;
			
			
			
			
		
		}
	}

	


