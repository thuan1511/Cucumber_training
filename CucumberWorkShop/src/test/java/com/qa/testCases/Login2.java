/**
 * 
 */
package com.qa.testCases;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author nhan.nguyen
 *
 */
public class Login2 {
	WebDriver driver;
	//WebDriverWait wait = WebDriverWait(driver,10);
@Test
public void loginToInternet(){
	//define driver
	System.setProperty("webdriver.gecko.driver", "src/test/resources/executables/geckodriver.exe");
	driver = new FirefoxDriver();
	//goto the site
	driver.get("http://intranet.sutrix.com/auth/login/redirect_to/Lw%3D%3D");
	//input username
	WebElement inputUsername = driver.findElement(By.id("txtUserName"));
	inputUsername.clear();
	inputUsername.sendKeys("conkhikho");
	
	//input password
	WebElement inputPassword = driver.findElement(By.id("txtPassword"));
	inputPassword.clear();
	inputPassword.sendKeys("conkhikho");
	//click on login button
	WebElement btnSubmit = driver.findElement(By.cssSelector(".btnType1[type='submiting']"));
	btnSubmit.click();
	try {
		Thread.sleep(0);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//check for the error message
	WebElement popUp = driver.findElement(By.cssSelector("#alertPopup"));
    String alertMessage = popUp.getText();
    System.out.println("Error: " + alertMessage);
    
    Assert.assertTrue(alertMessage.contains("Invalid username or password"), "Wrong alert!");
    //close driver
    driver.quit();
}
}
