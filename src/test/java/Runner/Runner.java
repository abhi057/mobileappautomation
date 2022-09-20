package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= "D:\\eclipse-ws\\appiumprojectautomation\\src\\test\\java\\Features",
		glue= "stepDef"
 )
public class Runner extends AbstractTestNGCucumberTests{

}
