package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
//for RunWith avem nevoe de JUnit in pom.xml
@RunWith(Cucumber.class)
//for CucumberOptions avem nevoe de  cucumber junit
@CucumberOptions(
        glue={"stepDefinition","hooks"},
        features = "src/test/resources/features",
        tags="@Run",
        plugin = {"pretty","html:target/HtmlReort"})
public class TestRunner {
}
