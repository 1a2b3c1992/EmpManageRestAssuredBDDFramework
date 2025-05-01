package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= "src/test/java/FeatureFiles",
		glue= {"StepsApi"},
				monochrome=true,
			//	dryRun=false,
			//	tags="@RegressionSuite",
				plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
