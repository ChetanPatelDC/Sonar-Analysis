package testrunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import otherResources.TestContext;



@CucumberOptions(
      
		plugin = { "summary","pretty", "html:target/cucumber-reports.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/cucumber-reports"
				},
     
		features = "src//test//resources//Stories"
        ,glue={"stepDefinitions"}
        ,dryRun = false
        ,monochrome = true

        ,tags = "@EproCampaignCreation2 and @Scenario1 and @Scenario3" //changes made in the tag name only

       // ,tags = "@EproCampaignCreation2 and @Scenario12" //changes made in the tag name only

        // work from local branch
        //Scenario 3 added
       // comments are added for testing purpose
)

public class TestRunner extends AbstractTestNGCucumberTests
{
	/*
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();

	}*/
}
    //Sample comment  This comment is added in testrunner file. 
//Sample comment  This comment is added in testrunner file. 
	 
