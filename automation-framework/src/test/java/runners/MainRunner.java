package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinitions"},
        tags = "@contact-us",
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cubumber.json"
        }
)
public class MainRunner extends AbstractTestNGCucumberTests {
}
