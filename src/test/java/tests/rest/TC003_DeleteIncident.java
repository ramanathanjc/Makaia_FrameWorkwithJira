package tests.rest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;


public class TC003_DeleteIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Update a new Incident with Rest Assured";
		testDescription = "Update a new Incident and Verify response Code";
		nodes = "Incident";
		authors = "Ramanathan";
		category = "REST";
		
	}
// dependsOnMethods = "tests.rest.TC001_CreateIncident.createIncident" ,
	@Test
	public void DeleteIncident() {		
		
		Response response = delete(ConfigurationManager.configuration().issue()+"/"+issue_id);
		verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforDelete());
		System.out.println("Ticket Got Deleted ===="+issue_id );
	}


}




















