package MbPages;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HLPageFactory {
	WebDriver driver;
	WebDriverWait wait;

//<-------------------------------SCENARIO 1 WEBELEMENTS----------------------------------->//		
	
	@FindBy(xpath="//li[@class=\"js-menu-container\"][4]/child::a") 
	WebElement HomeLoansHeading;
	
	@FindBy(xpath="//a[@href=\"https://www.magicbricks.com/homeloan/home?inc=desktop_homeloan_menu_linkage\"]")
	WebElement loanSection;
	
	@FindBy(id="loanAmount")
	WebElement loanAmount;
	
	@FindBy(id="mobileNumber")
	WebElement mobile;
	
	@FindBy(id="PropertyCity")
	WebElement city;
	
	@FindBy(xpath="//span[@class=\'mb-hl__revamp-form__search__list--value\']")
	WebElement cityDropDown;
	
	@FindBy(xpath="//label[@for=\"PropFinalizedNo\"]")
	WebElement propertyFinalised;
	
	@FindBy(id="generate-otp")
	WebElement checkButton;
	
//<-------------------------------SCENARIO 2 WEBELEMENTS----------------------------------->//	
	
	@FindBy(xpath="//div[@id=\"homeloanDrop\"]/descendant::a[@href=\"https://www.magicbricks.com/homeloan/emi-calculator\"]")
	WebElement emi; 
	
	@FindBy(id="amountRequiredEmiCal")
	WebElement amountEmi; 
	
	@FindBy(id="loanTenureEmiCal") 
	WebElement tenure; 
	
	@FindBy(xpath="//ul[@id='loan-tenure_Emi']/child::li[2]")
	WebElement loanTenure;
	
	@FindBy(id="interestRateEmiCal")
	WebElement intRate; 
	
	@FindBy(id="submitbuttonEmiCalid")
	WebElement checkEmi;
	
//<-------------------------------SCENARIO 4 WEBELEMENTS----------------------------------->//	
	
	@FindBy(id="prepayId")
	WebElement prepayment;
		
	@FindBy(id="lalpc")
	WebElement loanPrepay;
	
	@FindBy(id="ltlpc")
	WebElement tenurePrepay;
	
	@FindBy(id="rlpc")
	WebElement ratePrepay;
	
	@FindBy(id="iplpc")
	WebElement paidPrepay;
	
	@FindBy(id="foreclosureId")
	WebElement foreclosure;
	
	@FindBy(xpath="//input[@onclick=\"submitPrepaymentCalculator(true);calculatorClickHandler('home_loan_prepay', 'Home Loan - Prepayment', 'Check Tenure');\"]")
	WebElement calculateButton;
	
//<-------------------------------SCENARIO 5 WEBELEMENTS----------------------------------->//	
	
	@FindBy(xpath="//div[@id=\"top-down-banner\"]/following-sibling::header/child::section[2]/descendant::ul[@class=\"mb-header__sub__tabs\"]/child::li[5]/a")
	WebElement propertyServices;
	
	@FindBy(xpath="//a[text()=\"Vastu\"]")
	WebElement vastu;
	
	@FindBy(xpath="//div[@id=\"sorting-title\"]/child::span[1]")
	WebElement relevence;
	
	@FindBy(xpath="//input[@id=\"sorting_price_htl\"]/following-sibling::label[1]")
	WebElement filter;
	
	@FindBy(xpath="//*[@id=\"refineservicerequired\"]/div[5]/a")
	WebElement done;
	
	@FindBy(xpath="//span[text()=\"Consultancy Type\"]")
	WebElement consultancy;
	
	@FindBy(xpath="//label[text()=\"Onsite Consultancy\"]")
	WebElement onsiteConsultancy;
	
	@FindBy(xpath="//label[text()=\"Telephonic Consultancy\"]")
	WebElement telephonicConsultancy;
	
	@FindBy(xpath="//label[text()=\"Trial Pack\"]")
	WebElement trialPack;
	
	@FindBy(xpath="(//div[@class=\"mkt-place__action action--inline action--right\"]/child::span)[1]")
	WebElement report;
	
	@FindBy(xpath="//a[@onclick=\"mktPlace.redirectURLMVastu(event,'2483'); fireGtmAndEcomm(event,'Vastu_Homepage','View Detail','Package Card','Vastu Karma_','','','Mumbai','Vastu','','','','7000');\"]/div[1]")
	WebElement errMessage;

	
//<------------------------------------------------------------------------------------------------------------>//		
//<---Constructor to initialize page factory--->//
	public HLPageFactory(WebDriver driver) 
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }

//<---Method for Background in @Given tag--->//	 
	public void HoverOnHomeLoanOption() throws InterruptedException 
	{
		 wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	     wait.until(ExpectedConditions.visibilityOf(HomeLoansHeading));
	       
		 Actions act = new Actions(driver);
		 act.moveToElement(HomeLoansHeading).build().perform();
		 HomeLoansHeading.click();
		 
	}
	
//<-----------------------------------SCENARIO 1 METHODS------------------------------------------>//	
//<--------THIS SCENARIO IS USED TO VALIDATE THE HOMELOAN CHECK ELIGIBILITY FUNCTIONALITY--------->//
	
	public void clickHomeLoans() throws InterruptedException
	 {   
		 loanSection.click();		 
	 }
	
	public void SwitchToReadyToMove() 
	{
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) 
		{
		    if (!handle.equals(mainWindowHandle)) 
		    {
		        driver.switchTo().window(handle);
            }
		}
   }
	
    public void fillForm(String Amount, String Mobile, String City) throws InterruptedException
     {
  	     loanAmount.sendKeys(Amount); 
  	     mobile.sendKeys(Mobile);
  	     city.sendKeys(City);
  	     cityDropDown.click();
  	     WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait1.until(ExpectedConditions.visibilityOf(propertyFinalised));
	     wait1.until(ExpectedConditions.elementToBeClickable(propertyFinalised));  
         propertyFinalised.click();
  	  
     }
    
    public void clickSubmit() throws InterruptedException
    {   	
         checkButton.click();
    	
    }

//<-----------------------------------SCENARIO 2 METHODS------------------------------------------>//
//<-----------THIS SCENARIO VALIDATES THE EMI CALCULATOR FUCTIONALITY WITH VALID DETAILS---------->//
    
  public void emiClick() throws InterruptedException
  {
	    emi.click();
	 
  }
  
  public void fillEmiForm(String amount1,String rate) throws InterruptedException
  {
	    amountEmi.click();
        amountEmi.clear();
	    amountEmi.sendKeys(amount1);	
	
	    intRate.clear();
	    intRate.sendKeys(rate);
	 
	    tenure.click();
	    loanTenure.click();
	
  }
  
  public void clickEmiButton()
  {
	    checkEmi.click();  
  }
    
//<-----------------------------------SCENARIO 3 METHODS------------------------------------------>//	
//<------THIS SCENARIO VALIDATE THE EMI CALCULATOR FUNCTIONALITY WITH EMPTY LOAN AMOUNT FIELD----->//
    
  public void invaliLoanAmount(String rate2)
  {
	    amountEmi.click();
	    amountEmi.clear();
	  
	    tenure.click();
	    loanTenure.click();
	  
        intRate.clear();
        intRate.sendKeys(rate2);
  }
    
//<-----------------------------------SCENARIO 4 METHODS------------------------------------------>//	
//<-----------THIS SCENARIO VALIDATE THE PREPAYMENT AMOUNT CALCULATOR WITH VALID DETAILS---------->//
    
    public void scrollDown()
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
    }
    
    public void clickPrepayment()
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",prepayment );
    }
    
    public void detailPrepay(String amount, String tenure,String rate,String installmentpaid)
    {
    	loanPrepay.clear();
    	loanPrepay.sendKeys(amount);
    	tenurePrepay.clear();
    	tenurePrepay.sendKeys(tenure);
    	ratePrepay.clear();
    	ratePrepay.sendKeys(rate);
    	paidPrepay.clear();
    	paidPrepay.sendKeys(installmentpaid);
    	foreclosure.click();
    }
      
    public void clickCalculate() throws InterruptedException
    {
    	calculateButton.click();
    	wait.until(ExpectedConditions.visibilityOf(HomeLoansHeading));
    }

//<-----------------------------------SCENARIO 5 METHODS------------------------------------------>//	
//<THIS SCENARIO VALIADTE THE SAMPLE REPORT FUNCTIONALITY OF VASTU PAGE FOR SPECIFIC VASTU CONSULTANT>//
    
 public void hoverPropertyServices() throws InterruptedException
 {
	    Actions act1 = new Actions(driver);
	    act1.moveToElement(propertyServices).build().perform();
	    propertyServices.click();
 }
 
 public void clickVastu()
 {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();",vastu ); 
 }
 
 public void vastuPage() throws InterruptedException
 {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(consultancy));
	    consultancy.click();

	    wait.until(ExpectedConditions.elementToBeClickable(onsiteConsultancy));
	    onsiteConsultancy.click();

	    wait.until(ExpectedConditions.elementToBeClickable(telephonicConsultancy));
	    telephonicConsultancy.click();

	    wait.until(ExpectedConditions.elementToBeClickable(trialPack));
	    trialPack.click();
        
	    WebDriverWait w1= new WebDriverWait(driver, Duration.ofSeconds(10));
	    w1.until(ExpectedConditions.elementToBeClickable(done));
	    JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("window.scrollBy(0,300)");
	    System.out.println("last scroll up");
	    
        
	    wait.until(ExpectedConditions.elementToBeClickable(done));
	    done.click();
	    report.click();
	    System.out.println("report does not generated");
 }
 
 public String defectMessage()
 {
	 return errMessage.getText();
	 
 }
 
 public void defectMsgAssertion()
 {
	 String expectedUrl ="https://magicbricks.com/vastu-consultant/sample-report";
	 String actualUrl=driver.getCurrentUrl();
	 Assert.assertEquals(actualUrl,expectedUrl);
 }
}

//===========================================================================================================================//
