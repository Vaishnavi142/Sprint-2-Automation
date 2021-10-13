package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
	features="src/test/java/Feature",
	glue= {"StepDefinition","hooks"},		//packages
	dryRun=false, 
	monochrome=true, 
	
	//tags="@SendmsgPending",
	
	//tags= "@regression",
	//tags= {"@Sanity", "@regression"},         //And condition
	//tags={"@Sanity,@Regression"},             //Or condition
	//tags= {"~@Smoke"},						//skiptag
	
	plugin= { "pretty" ,"html:target/cucumberassign-pretty","junit:target/report.xml","json:target/report.json"}
)

public class TestrunneR {
	

}
