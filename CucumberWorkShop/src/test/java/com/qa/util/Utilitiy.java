/**
 * 
 */
package com.qa.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;

/**
 * @author nhan.nguyen
 *
 */
public class Utilitiy {
	static WebDriver driver;
	static Scenario scenario = null;
	// loginFalse
	public void gotoWebSite() {
		// define driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/executables/chromedriver.exe");
		driver = new ChromeDriver();
		// goto the site
		driver.get("http://intranet.sutrix.com/auth/login/redirect_to/Lw%3D%3D");
	}

	public void performanceForm() {
		// TODO Auto-generated method stub
		// input username
		WebElement inputUsername = driver.findElement(By.id("txtUserName"));
		inputUsername.clear();
		inputUsername.sendKeys("conkhikho");
		// input password
		WebElement inputPassword = driver.findElement(By.id("txtPassword"));
		inputPassword.clear();
		inputPassword.sendKeys("conkhikho");
		// click on login button
		WebElement btnSubmit = driver.findElement(By.cssSelector(".btnType1[type='submit']"));
		btnSubmit.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkTheError() {
		// TODO Auto-generated method stub
		// check for the error message
		WebElement popUp = driver.findElement(By.cssSelector("#alertPopup"));
		String alertMessage = popUp.getText();
		System.out.println("Error: " + alertMessage);

		Assert.assertTrue(alertMessage.contains("Invalid username or password"), "Wrong alert!");

	}

	//// loginFalseWithDataTable
	public void performanceForm(DataTable arg1) {
		// TODO Auto-generated method stub
		List<List<String>> data = arg1.raw();
		WebElement inputUsername = driver.findElement(By.id("txtUserName"));
		inputUsername.clear();
		inputUsername.sendKeys(data.get(1).get(1));
		// input password
		WebElement inputPassword = driver.findElement(By.id("txtPassword"));
		inputPassword.clear();
		inputPassword.sendKeys(data.get(2).get(1));
		// click on login button
		WebElement btnSubmit = driver.findElement(By.cssSelector(".btnType1[type='submit']"));
		btnSubmit.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void checkTheErrorAs(DataTable arg1) {
		// TODO Auto-generated method stub
		List<List<String>> data = arg1.raw();
		// check for the error message
		WebElement popUp = driver.findElement(By.cssSelector("#alertPopup"));
		String alertMessage = popUp.getText();
		System.out.println("Error: " + alertMessage);

		Assert.assertTrue(alertMessage.contains(data.get(1).get(1)), "Wrong alert!");

	}
	// loginFalseWithData

	public void inputUserName(String arg1) {
		// TODO Auto-generated method stub
		System.out.println("agr1 is: " + arg1);
		String txtUserName = arg1;
		// input username
		WebElement inputUsername = driver.findElement(By.id("txtUserName"));
		inputUsername.clear();
		inputUsername.sendKeys(txtUserName);
	}

	public void inputPassword(String arg1) {
		// TODO Auto-generated method stub
		System.out.println("agr1 is: " + arg1);
		String txtPassword = arg1;
		// input password
		WebElement inputPassword = driver.findElement(By.id("txtPassword"));
		inputPassword.clear();
		inputPassword.sendKeys(txtPassword);
	}

	public void clickSubmitButton() {
		// TODO Auto-generated method stub
		// click on login button
		WebElement btnSubmit = driver.findElement(By.cssSelector(".btnType1[type='submit']"));
		btnSubmit.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifyError(String arg1) {
		// TODO Auto-generated method stub
		System.out.println("agr1 is: " + arg1);
		String txtError = arg1;
		// check for the error message
		WebElement popUp = driver.findElement(By.cssSelector("#alertPopup"));
		String alertMessage = popUp.getText();
		System.out.println("Error: " + alertMessage);

		Assert.assertTrue(alertMessage.contains(txtError), "Wrong alert!");

	}

	public void closeWebSite() {
		System.out.println("[We close this test!]");
		
		driver.close();
		driver.quit();
	}


	public void gotoWebSite(String url) {
		
		// define driver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/executables/chromedriver.exe");
		driver = new ChromeDriver();
		// goto the site
		driver.get(url);
		// click Flight
		WebElement eleFlight = driver.findElement(By.id("tab-flight-tab-hp"));
		eleFlight.click();
		//scenario.write(url);
	}

	public void completeForm() throws InterruptedException {
		// input Flying from
		By byEleFlyingFrom1 = By.id("flight-origin-hp-flight");
		By byEleFlyingFrom2 = By.id("typeaheadDataPlain");
		By byEleFlyingFrom3 = By.id("typeaheadDataPlain");
		By byTagNameFlying = By.tagName("li");
		String value = "Ho Chi Minh";
		String expect = "Ho Chi Minh City, Vietnam";
		selectOnAjax(byEleFlyingFrom1, byEleFlyingFrom2, byEleFlyingFrom3, byTagNameFlying, value, expect);
		// input Flying to
		By byEleFlyingTo1 = By.id("flight-destination-hp-flight");
		By byEleFlyingTo2 = By.id("typeaheadDataPlain");
		By byEleFlyingTo3 = By.id("typeaheadDataPlain");

		value = "Ha Noi";
		expect = "Hanoi, Vietnam";
		selectOnAjax(byEleFlyingTo1, byEleFlyingTo2, byEleFlyingTo3, byTagNameFlying, value, expect);
		// input Departing
		By byEleDeparting1 = By.id("flight-departing-hp-flight");
		By byEleDeparting2 = By.id("flight-departing-wrapper-hp-flight");
		By byEleDeparting3 = By.xpath(".//*[@id='flight-departing-wrapper-hp-flight']/div/div/div[2]");
		By byTagNameDeparting = By.tagName("td");
		value = "30";
		expect = "30";
		selectOnAjax(byEleDeparting1, byEleDeparting2, byEleDeparting3, byTagNameDeparting, value, expect);
		// input Returning
		By byEleReturning1 = By.id("flight-returning-hp-flight");
		By byEleReturning2 = By.id("flight-returning-wrapper-hp-flight");
		By byEleReturning3 = By.xpath(".//*[@id='flight-returning-wrapper-hp-flight']/div/div/div[3]");

		value = "10";
		expect = "10";
		selectOnAjax(byEleReturning1, byEleReturning2, byEleReturning3, byTagNameDeparting, value, expect);

		Thread.sleep(3000);
		// click search
		WebElement btnSubmit = driver
				.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button"));
		btnSubmit.click();
	}

	private void selectOnAjax(By byElement1, By byElement2, By byElement3, By byTagname, String value, String expect) {
		// click auto completed
		WebElement autoComplete1 = driver.findElement(byElement1);
		autoComplete1.click();

		// sendkey to auto completed
		autoComplete1.sendKeys(value);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement2));

		String strExpect = expect;
		WebElement parent = driver.findElement(byElement3);
		List<WebElement> items = parent.findElements(byTagname);

		for (WebElement item : items) {
			if (item.getText().contains(strExpect)) {
				System.out.println("[I choose: " + item.getText() + "]");
				item.click();
				System.out.println("[I clicked!]");
				break;
			}
		}

		// click to item
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void seeMessage() throws InterruptedException {
		Thread.sleep(3000);

		// verify search text
		// //input[@id='departure-airport-1']
		WebElement eleDepart = driver.findElement(By.xpath("//*[@id='departure-airport-1']"));
		System.out.println("[eleDepart:" + eleDepart.getAttribute("value").toString() + "]");
		// Ho Chi Minh City, Vietnam (SGN)
		String strActDepart = "Ho Chi Minh City, Vietnam (SGN)";

		Assert.assertTrue(eleDepart.getAttribute("value").toString().contains(strActDepart), "Message not have!");
		// //input[@id='arrival-airport-1']
		WebElement eleArrival = driver.findElement(By.xpath("//*[@id='arrival-airport-1']"));
		System.out.println("[eleArrival:" + eleArrival.getAttribute("value").toString() + "]");
		// Hanoi, Vietnam (HAN)
		String strActArrival = "Hanoi, Vietnam (HAN)";
		Assert.assertTrue(eleArrival.getAttribute("value").toString().contains(strActArrival), "Message not have!");
		// //input[@id='departure-date-1']
		WebElement eleDepartDate = driver.findElement(By.xpath("//*[@id='departure-date-1']"));
		// 08/30/2018
		String strActDepartDate = "08/30/2018";
		System.out.println("[eleArrival:" + eleDepartDate.getAttribute("value").toString() + "]");
		Assert.assertTrue(eleDepartDate.getAttribute("value").toString().contains(strActDepartDate),
				"Message not have!");
		// //input[@id='return-date-1']
		WebElement eleReturnDate = driver.findElement(By.xpath("//input[@id='return-date-1']"));
		// 09/10/2018
		String strActReturnDate = "09/10/2018";
		System.out.println("[eleArrival:" + eleReturnDate.getAttribute("value").toString() + "]");
		Assert.assertTrue(eleReturnDate.getAttribute("value").toString().contains(strActReturnDate),
				"Message not have!");
	}

	public void completeForm(DataTable table) throws InterruptedException {
		List<List<String>> data = table.raw();
		// input Flying from
		By byEleFlyingFrom1 = By.id("flight-origin-hp-flight");
		By byEleFlyingFrom2 = By.id("typeaheadDataPlain");
		By byEleFlyingFrom3 = By.id("typeaheadDataPlain");
		By byTagNameFlying = By.tagName("li");
		String value = data.get(1).get(1);
		String expect = data.get(2).get(1);
		selectOnAjax(byEleFlyingFrom1, byEleFlyingFrom2, byEleFlyingFrom3, byTagNameFlying, value, expect);
		// input Flying to
		By byEleFlyingTo1 = By.id("flight-destination-hp-flight");
		By byEleFlyingTo2 = By.id("typeaheadDataPlain");
		By byEleFlyingTo3 = By.id("typeaheadDataPlain");

		value = data.get(3).get(1);
		expect = data.get(4).get(1);
		selectOnAjax(byEleFlyingTo1, byEleFlyingTo2, byEleFlyingTo3, byTagNameFlying, value, expect);
		// input Departing
		By byEleDeparting1 = By.id("flight-departing-hp-flight");
		By byEleDeparting2 = By.id("flight-departing-wrapper-hp-flight");
		By byEleDeparting3 = By.xpath(".//*[@id='flight-departing-wrapper-hp-flight']/div/div/div[2]");
		By byTagNameDeparting = By.tagName("td");
		value = data.get(5).get(1);
		expect = data.get(6).get(1);
		selectOnAjax(byEleDeparting1, byEleDeparting2, byEleDeparting3, byTagNameDeparting, value, expect);
		// input Returning
		By byEleReturning1 = By.id("flight-returning-hp-flight");
		By byEleReturning2 = By.id("flight-returning-wrapper-hp-flight");
		By byEleReturning3 = By.xpath(".//*[@id='flight-returning-wrapper-hp-flight']/div/div/div[3]");

		value = data.get(7).get(1);
		expect = data.get(8).get(1);
		selectOnAjax(byEleReturning1, byEleReturning2, byEleReturning3, byTagNameDeparting, value, expect);

		Thread.sleep(3000);
		// click search
				WebElement btnSubmit = driver
						.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button"));
				btnSubmit.click();
	}

	public void seeMessage(DataTable table) {
		List<List<String>> data = table.raw();
		// verify search text
		// //input[@id='departure-airport-1']
		WebElement eleDepart = driver.findElement(By.xpath("//*[@id='departure-airport-1']"));
		System.out.println("[eleDepart:" + eleDepart.getAttribute("value").toString() + "]");
		// Ho Chi Minh City, Vietnam (SGN)
		String strActDepart = data.get(1).get(1);

		Assert.assertTrue(eleDepart.getAttribute("value").toString().contains(strActDepart), "Message not have!");
		// //input[@id='arrival-airport-1']
		WebElement eleArrival = driver.findElement(By.xpath("//*[@id='arrival-airport-1']"));
		System.out.println("[eleArrival:" + eleArrival.getAttribute("value").toString() + "]");
		// Hanoi, Vietnam (HAN)
		String strActArrival = data.get(2).get(1);
		Assert.assertTrue(eleArrival.getAttribute("value").toString().contains(strActArrival), "Message not have!");
		// //input[@id='departure-date-1']
		WebElement eleDepartDate = driver.findElement(By.xpath("//*[@id='departure-date-1']"));
		// 08/30/2018
		String strActDepartDate = data.get(3).get(1);
		System.out.println("[eleArrival:" + eleDepartDate.getAttribute("value").toString() + "]");
		Assert.assertTrue(eleDepartDate.getAttribute("value").toString().contains(strActDepartDate),
				"Message not have!");
		// //input[@id='return-date-1']
		WebElement eleReturnDate = driver.findElement(By.xpath("//input[@id='return-date-1']"));
		// 09/10/2018
		String strActReturnDate = data.get(4).get(1);
		System.out.println("[eleArrival:" + eleReturnDate.getAttribute("value").toString() + "]");
		Assert.assertTrue(eleReturnDate.getAttribute("value").toString().contains(strActReturnDate),
				"Message not have!");
	}

	public void flyingFrom(String arg1, String arg2) {
		// input Flying from
		By byEleFlyingFrom1 = By.id("flight-origin-hp-flight");
		By byEleFlyingFrom2 = By.id("typeaheadDataPlain");
		By byEleFlyingFrom3 = By.id("typeaheadDataPlain");
		By byTagNameFlying = By.tagName("li");
		String value = arg1;
		String expect = arg2;
		selectOnAjax(byEleFlyingFrom1, byEleFlyingFrom2, byEleFlyingFrom3, byTagNameFlying, value, expect);
	}

	public void flyingTo(String arg1, String arg2) {
		// input Flying to
		By byEleFlyingTo1 = By.id("flight-destination-hp-flight");
		By byEleFlyingTo2 = By.id("typeaheadDataPlain");
		By byEleFlyingTo3 = By.id("typeaheadDataPlain");
		By byTagNameFlying = By.tagName("li");
		String value = arg1;
		String expect = arg2;
		selectOnAjax(byEleFlyingTo1, byEleFlyingTo2, byEleFlyingTo3, byTagNameFlying, value, expect);
	}

	public void departing(String arg1, String arg2) {
		// input Departing
		By byEleDeparting1 = By.id("flight-departing-hp-flight");
		By byEleDeparting2 = By.id("flight-departing-wrapper-hp-flight");
		By byEleDeparting3 = By.xpath(".//*[@id='flight-departing-wrapper-hp-flight']/div/div/div[2]");
		By byTagNameDeparting = By.tagName("td");
		String value = arg1;
		String expect = arg2;
		selectOnAjax(byEleDeparting1, byEleDeparting2, byEleDeparting3, byTagNameDeparting, value, expect);
	}

	public void returning(String arg1, String arg2) {
		// input Returning
		By byEleReturning1 = By.id("flight-returning-hp-flight");
		By byEleReturning2 = By.id("flight-returning-wrapper-hp-flight");
		By byEleReturning3 = By.xpath(".//*[@id='flight-returning-wrapper-hp-flight']/div/div/div[3]");
		By byTagNameDeparting = By.tagName("td");
		String value = arg1;
		String expect = arg2;
		selectOnAjax(byEleReturning1, byEleReturning2, byEleReturning3, byTagNameDeparting, value, expect);
	}

	public void clickSearch() throws InterruptedException {
		Thread.sleep(3000);
		// click search
		WebElement btnSubmit = driver
				.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button"));
		btnSubmit.click();
	}
	
	@After
	public static void teardown(Scenario scenario){
		if (scenario.isFailed()) {
			try {
				byte[] animation = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(animation, "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void navigateto() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "src/test/resources/executables/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.expedia.com/");
	}

	public void PerformFlightForm() throws InterruptedException {
		// TODO Auto-generated method stub
		// input Flying from
				By byEleFlyingFrom1 = By.id("flight-origin-hp-flight");
				By byEleFlyingFrom2 = By.id("typeaheadDataPlain");
				By byEleFlyingFrom3 = By.id("typeaheadDataPlain");
				By byTagNameFlying = By.tagName("li");
				String value = "Ho Chi Minh";
				String expect = "Ho Chi Minh City, Vietnam";
				selectOnAjax(byEleFlyingFrom1, byEleFlyingFrom2, byEleFlyingFrom3, byTagNameFlying, value, expect);
				// input Flying to
				By byEleFlyingTo1 = By.id("flight-destination-hp-flight");
				By byEleFlyingTo2 = By.id("typeaheadDataPlain");
				By byEleFlyingTo3 = By.id("typeaheadDataPlain");

				value = "Ha Noi";
				expect = "Hanoi, Vietnam";
				selectOnAjax(byEleFlyingTo1, byEleFlyingTo2, byEleFlyingTo3, byTagNameFlying, value, expect);
				// input Departing
				By byEleDeparting1 = By.id("flight-departing-hp-flight");
				By byEleDeparting2 = By.id("flight-departing-wrapper-hp-flight");
				By byEleDeparting3 = By.xpath(".//*[@id='flight-departing-wrapper-hp-flight']/div/div/div[2]");
				By byTagNameDeparting = By.tagName("td");
				value = "30";
				expect = "30";
				selectOnAjax(byEleDeparting1, byEleDeparting2, byEleDeparting3, byTagNameDeparting, value, expect);
				// input Returning
				By byEleReturning1 = By.id("flight-returning-hp-flight");
				By byEleReturning2 = By.id("flight-returning-wrapper-hp-flight");
				By byEleReturning3 = By.xpath(".//*[@id='flight-returning-wrapper-hp-flight']/div/div/div[3]");

				value = "10";
				expect = "10";
				selectOnAjax(byEleReturning1, byEleReturning2, byEleReturning3, byTagNameDeparting, value, expect);

				Thread.sleep(3000);
				// click search
				WebElement btnSubmit = driver
						.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button"));
				btnSubmit.click();
	}

	public void VerifyMessage() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);

		// verify search text
		// //input[@id='departure-airport-1']
		WebElement eleDepart = driver.findElement(By.xpath("//*[@id='departure-airport-1']"));
		System.out.println("[eleDepart:" + eleDepart.getAttribute("value").toString() + "]");
		// Ho Chi Minh City, Vietnam (SGN)
		String strActDepart = "Ho Chi Minh City, Vietnam (SGN)";

		Assert.assertTrue(eleDepart.getAttribute("value").toString().contains(strActDepart), "Message not have!");
		// //input[@id='arrival-airport-1']
		WebElement eleArrival = driver.findElement(By.xpath("//*[@id='arrival-airport-1']"));
		System.out.println("[eleArrival:" + eleArrival.getAttribute("value").toString() + "]");
		// Hanoi, Vietnam (HAN)
		String strActArrival = "Hanoi, Vietnam (HAN)";
		Assert.assertTrue(eleArrival.getAttribute("value").toString().contains(strActArrival), "Message not have!");
		// //input[@id='departure-date-1']
		WebElement eleDepartDate = driver.findElement(By.xpath("//*[@id='departure-date-1']"));
		// 08/30/2018
		String strActDepartDate = "08/30/2018";
		System.out.println("[eleArrival:" + eleDepartDate.getAttribute("value").toString() + "]");
		Assert.assertTrue(eleDepartDate.getAttribute("value").toString().contains(strActDepartDate),
				"Message not have!");
		// //input[@id='return-date-1']
		WebElement eleReturnDate = driver.findElement(By.xpath("//input[@id='return-date-1']"));
		// 09/10/2018
		String strActReturnDate = "09/10/2018";
		System.out.println("[eleArrival:" + eleReturnDate.getAttribute("value").toString() + "]");
		Assert.assertTrue(eleReturnDate.getAttribute("value").toString().contains(strActReturnDate),
				"Message not have!");
	}

	public void ClickonFlightButton() {
		// TODO Auto-generated method stub
		// click Flight
				WebElement eleFlight = driver.findElement(By.id("tab-flight-tab-hp"));
				eleFlight.click();
	}


	public void performFlight(DataTable arg1) throws InterruptedException {
		// TODO Auto-generated method stub
		List<List<String>> data = arg1.raw();
//		for(int i=0;i<4;i++){
//			for(int j=0;j<4;j++){
//				System.out.println(data.get(i).get(j));
//			}
//		}
		// input Flying from
		By byEleFlyingFrom1 = By.id("flight-origin-hp-flight");
		By byEleFlyingFrom2 = By.id("typeaheadDataPlain");
		By byEleFlyingFrom3 = By.id("typeaheadDataPlain");
		By byTagNameFlying = By.tagName("li");
		String value = data.get(1).get(1);
		String expect = data.get(1).get(2);
		selectOnAjax(byEleFlyingFrom1, byEleFlyingFrom2, byEleFlyingFrom3, byTagNameFlying, value, expect);
		// input Flying to
		By byEleFlyingTo1 = By.id("flight-destination-hp-flight");
		By byEleFlyingTo2 = By.id("typeaheadDataPlain");
		By byEleFlyingTo3 = By.id("typeaheadDataPlain");

		value = data.get(2).get(1);
		expect = data.get(2).get(2);
		selectOnAjax(byEleFlyingTo1, byEleFlyingTo2, byEleFlyingTo3, byTagNameFlying, value, expect);
		// input Departing
		By byEleDeparting1 = By.id("flight-departing-hp-flight");
		By byEleDeparting2 = By.id("flight-departing-wrapper-hp-flight");
		By byEleDeparting3 = By.xpath(".//*[@id='flight-departing-wrapper-hp-flight']/div/div/div[2]");
		By byTagNameDeparting = By.tagName("td");
		value = data.get(3).get(1);
		expect = data.get(3).get(2);
		selectOnAjax(byEleDeparting1, byEleDeparting2, byEleDeparting3, byTagNameDeparting, value, expect);
		// input Returning
		By byEleReturning1 = By.id("flight-returning-hp-flight");
		By byEleReturning2 = By.id("flight-returning-wrapper-hp-flight");
		By byEleReturning3 = By.xpath(".//*[@id='flight-returning-wrapper-hp-flight']/div/div/div[3]");

		value = data.get(4).get(1);
		expect = data.get(4).get(2);
		selectOnAjax(byEleReturning1, byEleReturning2, byEleReturning3, byTagNameDeparting, value, expect);

		Thread.sleep(3000);
		// click search
		WebElement btnSubmit = driver
				.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button"));
		btnSubmit.click();
	}

	public void VerifyMessage(DataTable table) throws Exception {
		// TODO Auto-generated method stub
		List<List<String>> data = table.raw();
		
		Thread.sleep(3000);

		// verify search text
		// //input[@id='departure-airport-1']
		WebElement eleDepart = driver.findElement(By.xpath("//*[@id='departure-airport-1']"));
		System.out.println("[eleDepart:" + eleDepart.getAttribute("value").toString() + "]");
		// Ho Chi Minh City, Vietnam (SGN)
		String strActDepart = data.get(1).get(0);

		Assert.assertTrue(eleDepart.getAttribute("value").toString().contains(strActDepart), "Message not have!");
		// //input[@id='arrival-airport-1']
		WebElement eleArrival = driver.findElement(By.xpath("//*[@id='arrival-airport-1']"));
		System.out.println("[eleArrival:" + eleArrival.getAttribute("value").toString() + "]");
		// Hanoi, Vietnam (HAN)
		String strActArrival = data.get(1).get(1);
		Assert.assertTrue(eleArrival.getAttribute("value").toString().contains(strActArrival), "Message not have!");
		// //input[@id='departure-date-1']
		WebElement eleDepartDate = driver.findElement(By.xpath("//*[@id='departure-date-1']"));
		// 08/30/2018
		String strActDepartDate = data.get(1).get(2);
		System.out.println("[eleArrival:" + eleDepartDate.getAttribute("value").toString() + "]");
		Assert.assertTrue(eleDepartDate.getAttribute("value").toString().contains(strActDepartDate),
				"Message not have!");
		// //input[@id='return-date-1']
		WebElement eleReturnDate = driver.findElement(By.xpath("//input[@id='return-date-1']"));
		// 09/10/2018
		String strActReturnDate = data.get(1).get(3);
		System.out.println("[eleArrival:" + eleReturnDate.getAttribute("value").toString() + "]");
		Assert.assertTrue(eleReturnDate.getAttribute("value").toString().contains(strActReturnDate),
				"Message not have!");
	}
}
