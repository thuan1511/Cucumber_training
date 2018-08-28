/**
 * 
 */
package com.qa.testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author nhan.nguyen
 *
 */
public class filter {
	//go to the site https://ft:123@abc@media.uat.flyingtiger.com
	//click on Image bank
	//I will see the filter as Campains, Release and Colour
	//I click on Campaigns
	// I will see all filter of Campains
	//I click on Always in store
	//I will see the text WOBBLE BOARD FOR ANKLE STRENGT
	WebDriver driver;
	
	@Test
	public void filter(){
		
		//define driver
		System.setProperty("webdriver.gecko.driver", "src/test/resources/executables/geckodriver.exe");
		driver = new FirefoxDriver();
		//goto the site
		driver.get("https://ft:123@abc@media.uat.flyingtiger.com");
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		 // Create new WebDriver wait
        WebDriverWait wait = new WebDriverWait(driver, 20);
     // Wait for Alert to be present
        
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
 
        System.out.println("Either Pop Up is displayed or it is Timed Out");
 
        // Accept the Alert
 
        myAlert.accept();
 
        System.out.println("Alert Accepted");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //click on Image bank
		//WebElement lnkImageBank = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Image bank")));
		WebElement lnkImageBank = driver.findElement(By.linkText("Image bank"));
		lnkImageBank.click();
		//I will see the filter as Campains, Release and Colour
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> listImageBanks = driver.findElements(By.xpath(".//*[@id='image-bank-page']/div/div[1]/div/div[2]/ul/div"));
		for (WebElement element: listImageBanks) {
		      System.out.println(element.getText());
		}
		// I will see all filter of Campains
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement lnkCampaigns = driver.findElement(By.xpath(".//a[@class='lv1__title' and @title='Campaigns']"));
		lnkCampaigns.click();
		//I click on Always in store
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> listCampaignStores = driver.findElements(By.xpath(".//*[@id='image-bank-page']/div/div[1]/div/div[2]/ul/div/li[1]/ul"));
		for (WebElement store: listCampaignStores) {
		      System.out.println(store.getText());
		}
		//I click on Always in store
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement lnkStore = driver.findElement(By.linkText("Always in store"));
		lnkStore.click();
		//I will see the text WOBBLE BOARD FOR ANKLE STRENGT
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement imageBankPage = driver.findElement(By.xpath(".//*[@id='image-bank-page']/div/div[2]/div[2]/div[1]/div/div[1]/div/div/div/a/h3"));
	    String strMessage = imageBankPage.getText();
	    System.out.println("imageBankPage: " + strMessage);
	    
	    Assert.assertTrue(strMessage.contains("WOBBLE BOARD FOR ANKLE STRENGT"), "Wrong Message!");
	    //close driver
	    driver.quit();
	}
	
}
