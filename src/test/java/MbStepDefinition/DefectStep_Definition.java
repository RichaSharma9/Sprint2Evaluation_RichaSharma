package MbStepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import MbDriverSetup.HLSetupDriver;
import MbPages.HLPageFactory;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DefectStep_Definition {
static WebDriver driver;	
HLPageFactory hlp;

//<THIS SCENARIO CONTAINS DEFECT AS WHEN WE CLICK ON THE SAMPLE REPORT OPTION OF VASTU CONSULTANT PAGE>//
//<SAMPLE REPORT DOES NOT GENERATE>//

/*
 * Created By : Richa Sharma
 * Reviewed By :
 * Motive : In this scenario we are testing for sample report functionality given in 
 * vastu consultant page
 */	

	@Given("User is on website homepage")
	public void user_is_on_website_homepage() throws InterruptedException {
	   driver=HLSetupDriver.chromedriver();
	   hlp= new HLPageFactory(driver);
	   hlp.hoverPropertyServices();
	}

	@When("User naviagate to the vastu page by clicking on the Property services option")
	public void user_naviagate_to_the_vastu_page_by_clicking_on_the_property_services_option() {
	  
		hlp.clickVastu();
		hlp.SwitchToReadyToMove();
	}

	@And("Click on sample report option of desired vastu consultant")
	public void click_on_sample_report_option_of_desired_vastu_consultant() throws InterruptedException {
	    hlp.vastuPage();
	}

	@Then("Report will be open on another page")
	public void report_will_be_open_on_another_page() {
		hlp.defectMsgAssertion();
	   
	}
	
	@AfterStep
	public static void takeScreendown(Scenario scenerio) {
		   TakesScreenshot t= (TakesScreenshot)driver;
		   final byte[] src = t.getScreenshotAs(OutputType.BYTES);
	scenerio.attach(src, "image/png",scenerio.getName());
	}
}
//=============================================================================================//