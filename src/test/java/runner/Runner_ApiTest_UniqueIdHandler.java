
package runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/PostApiTest.feature",
				glue= {"stepDefinition"},
				dryRun = false,
				tags = "@uniqueIdPerPost",
				monochrome = true, 
				format = {"pretty", "html:TestReports", "json:TestReports/cucumber.json", "junit:TestReports/cucumber.xml"}
				
		)
public class Runner_ApiTest_UniqueIdHandler {
}