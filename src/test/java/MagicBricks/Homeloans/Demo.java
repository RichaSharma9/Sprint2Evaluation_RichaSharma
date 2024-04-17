package MagicBricks.Homeloans;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.interactions.Actions;


public class Demo {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.edge.driver", "‪C:\\Users\\RSHARM31\\OneDrive - Capgemini\\msedgedriver.exe");
	       WebDriver driver = new EdgeDriver();
	       driver.get("https://www.magicbricks.com/");     
	       driver.manage().window().maximize();
	       
        WebElement e= driver.findElement(By.xpath("//div[@id=\"top-down-banner\"]/following-sibling::header/child::section[2]/descendant::ul[@class=\"mb-header__sub__tabs\"]/child::li[5]/a"));
	    e.click();
	     
	       
	}

}
