package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "Feature/feature.feature", 
glue = {"stepDefinitions","MyHooks"},
monochrome = true, plugin ={"html:target/cucumber/cucumber.html"})

public class TestRunnerTest extends AbstractTestNGCucumberTests {
	
	
	  @Override
	  @DataProvider(parallel = true) 
	  public Object[][] scenarios() { 
		  return  super.scenarios(); 
		  }
	  
	 
}
