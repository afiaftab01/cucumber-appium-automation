
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps","hooks"},
        plugin = {"pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber-report/cucumber.json" // Generate JSON report
                },
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public static void afterAllScenarios() {
        // Code to execute after all scenarios have completed
        System.out.println("#################################After Class Junit######################################");
    }

    @BeforeSuite
    public static void BeforAllScenarios() {
        System.out.println("#################################Before Class Junit######################################");
    }

}
