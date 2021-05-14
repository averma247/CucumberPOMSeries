package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = {"src/test/resources/com/features"},
		glue = {"stepdefinitions","apphooks"},
		plugin={"pretty"}
		)

public class MySerenityTestRunner {
	
	/**
	 * This is used to publish Serenity Test report. 
	 * Change the setting under surefile plugin in pom.xml to publish Test report
	 */

}
