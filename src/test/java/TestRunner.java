import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // path to feature files
        features = {"src/test/Feature Files"},

        //specify the path of step definition files
        glue = {"StepDefinition", "Web"},

        //tag to be executed
        tags = {},

        // creates a default cucumber report


)



public class TestRunner {
}
