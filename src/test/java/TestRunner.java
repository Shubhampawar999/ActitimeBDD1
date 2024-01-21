import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features", glue = "com/StepDefinition",
        tags = " @DownFile"

//        plugin = {
//               "pretty",
//               "html:target/cucumber-reports.html",
//              "junit:target/cucumber-reports/Cucumber.xml"
//
//        }

                )


public class TestRunner {


}
