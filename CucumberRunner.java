package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//annotate cucumberoptions
@CucumberOptions(features="src/test/java/feature/Feature.feature",
glue="steps",
publish=true)
//extending AbstractTestNGCucumberTests
public class CucumberRunner extends AbstractTestNGCucumberTests{
	

}
