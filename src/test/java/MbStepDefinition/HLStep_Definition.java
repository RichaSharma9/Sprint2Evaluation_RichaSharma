package MbStepDefinition;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import MbDriverSetup.HLSetupDriver;
import MbPages.HLPageFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class HLStep_Definition {
	static WebDriver driver;
	HLPageFactory hl;
	
//<--------------------------------SCENARIO 1-------------------------------->//
	
	@Given("User is on the homepage of MagicBricks")
	public void user_is_on_the_homepage_of_magic_bricks() throws InterruptedException {
		//driver=HLSetupDriver.edgedriver();
		driver=HLSetupDriver.chromedriver();
		hl= new HLPageFactory(driver);
		hl.HoverOnHomeLoanOption();		
	}

	@When("User is on the homeloans page")
	public void user_is_on_the_homeloans_page() throws InterruptedException {
		hl.clickHomeLoans();
		System.out.println(driver.getWindowHandle());
		
		hl.SwitchToReadyToMove();
		System.out.println(driver.getWindowHandle());		
	}

	@When("^User enter the (.*), (.*), (.*)")
	public void user_enter_the_and(String Loan_Amount, String Mobile, String City) throws InterruptedException {
		hl.fillForm(Loan_Amount, Mobile, City);				     
	}
		
	@And("Click on the check eligibility button")
	public void click_on_the_check_eligibility_button() throws InterruptedException {
	hl.clickSubmit();    
	}

	@Then("User navigate to verification page")
	public void user_navigate_to_verification_page() {
		WebElement e = driver.findElement(By.className("mb-hl__page-title"));
		String str=e.getText();
		Assert.assertEquals("Verify your number",str );
		System.out.println("Scenario 1 is successfully implemented");
	}

//<--------------------------------SCENARIO 2-------------------------------->//

    @When("User is on the EMI calculator page")
    public void user_is_on_the_emi_calculator_page() throws InterruptedException {
 	    hl.emiClick();
 	    hl.SwitchToReadyToMove();
 	    System.out.println(driver.getWindowHandle());	
    }

    @When("User enter the details")
    public void user_enter_the_details(DataTable dataTable) throws InterruptedException {
	    List<List<String>> cells = dataTable.cells();
	    hl.fillEmiForm(cells.get(0).get(0), cells.get(0).get(1));
	    hl.fillEmiForm(cells.get(1).get(0), cells.get(1).get(1));
   }

   @When("Click on the submit button")
   public void click_on_the_submit_button() {	
        hl.clickEmiButton();
   }

   @Then("Monthly EMI of user is visible on the page")
   public void monthly_emi_of_user_is_visible_on_the_page() {
        WebElement button = driver.findElement(By.xpath("//div[@onclick=\"scrollToMatchingProp();\"]"));
        Assert.assertTrue(button.isDisplayed());
        System.out.println("Scenario 2 successfully implemented"); 
   }

 //<--------------------------------SCENARIO 3-------------------------------->//

   @When("The user is on the EMI calculator page to estimate the monthly EMI")
   public void the_user_is_on_the_emi_calculator_page_to_estimate_the_monthly_emi() throws InterruptedException {
	    hl.emiClick();
 	    hl.SwitchToReadyToMove();
 	    System.out.println(driver.getWindowHandle());    
   }

   @When("User enter the interest rate")
   public void user_enter_the_interest_rate(DataTable credential) {
	    List<List<String>> cell = credential.cells();
	    hl.invaliLoanAmount(cell.get(0).get(0));
   
  }

   @When("Click on the submit button for calculation")
   public void click_on_the_submit_button_for_calculation() {
        hl.clickEmiButton();
  }

   @Then("an error message should generate for empty loan amount field")
    public void an_error_message_should_generate_for_empty_loan_amount_field() {
        WebElement errorMessage = driver.findElement(By.id("amountRequiredEmiCalError")) ;
        String actual=errorMessage.getText();
        String str1="LoanAmount should lie between 1,00,000 and 10,00,00,000";
        Assert.assertEquals(actual, str1);
        System.out.println("Scenario 3 successfully implemented"); 
  }

 //<--------------------------------SCENARIO 4-------------------------------->//
   
   @When("User is on the Homeloans calculation page")
   public void user_is_on_the_homeloans_calculation_page() throws InterruptedException {
	    hl.clickHomeLoans();
	    System.out.println(driver.getWindowHandle());
	
	    hl.SwitchToReadyToMove();
	    System.out.println(driver.getWindowHandle());
   }

    @When("User scroll down to the prepayment calculator")
    public void user_scroll_down_to_the_prepayment_calculator() {
        hl.scrollDown();
  }

    @When("Click on the calculator")
    public void click_on_the_calculator() {
        hl.clickPrepayment();
  }

    @When("^Enter the details (.*), (.*), (.*) and (.*)$")
     public void enter_the_details_and(String amount, String tenure, String rate, String installmentpaid) {
        hl.detailPrepay(amount, tenure, rate, installmentpaid);
  }

    @When("Click on calculate button")
    public void click_on_calculate_button() throws InterruptedException {
        hl.clickCalculate();
  }

   @Then("Calculated amount is displayed on the screen")
   public void calculated_amount_is_displayed_on_the_screen() {
	    String expectedurl="https://www.magicbricks.com/homeloan/home?inc=desktop_homeloan_menu_linkage";
	    String actualurl=driver.getCurrentUrl();
	    Assert.assertEquals(actualurl, expectedurl);
        System.out.println("Scenario 3 successfully implemented");
  }

//<---THIS METHOD USED TO TAKE SCREENSHOT AFTER EVERY STEP--->//
//   @AfterStep
//   public static void takeScreendown(Scenario scenerio) {
//	   TakesScreenshot ts= (TakesScreenshot) driver;
//	   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
//	   scenerio.attach(src, "image/png",scenerio.getName());
//}
}
//===================================================================================================================//