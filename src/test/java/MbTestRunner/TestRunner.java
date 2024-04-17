package MbTestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resource\\MbFeatures\\Defect.feature",glue="MbStepDefinition",
tags="@defect",plugin= {"pretty",
		"html:target/HTMLReports/MagicBricksReport.html",	
		"json:target/JSONReports/MagicBricksReport.json",
		"junit:target/JUNITReports/MagicBricksReport.xml",		
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
})
public class TestRunner extends AbstractTestNGCucumberTests  {

}
