package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"stepDefinition", "hooks"},
        features = "src/test/resources/features",
        tags = "@Run",
        plugin = {"json:target/cucumber.json"})
public class TestRunner {
}
