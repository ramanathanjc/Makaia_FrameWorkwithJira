package tests.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;
import lib.utils.ConfigurationManager;


public class TC001_CreateIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Create a new Incident with Rest Assured";
		testDescription = "Create a new Incident and Verify response Code";
		nodes = "Incident";
		authors = "Ramanathan";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData" )
	public void createIncident(File file) throws FileNotFoundException, IOException {		
		
		Response response = postWithBodyAsFileAndUrl(file, ConfigurationManager.configuration().issue());
		issue_id = response.jsonPath().get("id");
        System.out.println("issue id is ==========="+issue_id);
		verifyResponseCode(response, ConfigurationManager.configuration().responsecodeforPost());
		response.prettyPrint();
	}


}




















