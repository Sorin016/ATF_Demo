package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
//for RunWith avem nevoe de JUnit in pom.xml
@RunWith(Cucumber.class)
//for CucumberOptions avem nevoe de  cucumber junit
@CucumberOptions(
        glue={"StepDefinition"},
        features = "src/test/resources/Features",
        tags="@Run",
        plugin = {"pretty","html:target/HtmlReort"})
public class TestRunner {
}
