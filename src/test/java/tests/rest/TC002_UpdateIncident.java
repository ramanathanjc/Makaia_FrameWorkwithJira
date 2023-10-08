package tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;


public class TC002_UpdateIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Update a new Incident with Rest Assured";
		testDescription = "Update a new Incident and Verify response Code";
		nodes = "Incident";
		authors = "Ramanathan";
		category = "REST";
		//dataProvider
		dataFileName = "TC2";
		dataFileType = "JSON";
	}
// dependsOnMethods = "tests.rest.TC001_CreateIncident.createIncident" ,
	@Test(dataProvider = "fetchData" )
	public void updateIncident(File file) throws FileNotFoundException, IOException {		
		
		Response response = putWithBodyParam(file, ConfigurationManager.configuration().issue()+"/"+issue_id);
		verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforPut());
		System.out.println("update the body in ticket");

	}


}




















