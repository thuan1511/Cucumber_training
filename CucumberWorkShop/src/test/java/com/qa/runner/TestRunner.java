/**
 * 
 */
package com.qa.runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;

/**
 * @author nhan.nguyen
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty", "html:target/cucumber" ,
				"json:target/cucumber.json"},
		features= {"src/test/java/com/qa/features/"}
		,glue={"com/qa/steps"},
		tags={"@tag2"}
		)
public class TestRunner {

}
