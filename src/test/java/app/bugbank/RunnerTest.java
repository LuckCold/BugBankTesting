package app.bugbank;

import app.bugbank.utils.ListenerTest;
import app.bugbank.utils.ScenarioSupport;
import app.bugbank.utils.SetUp;
import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.*;

@CucumberOptions(
        tags = "",
        features = {"classpath:features"},
        plugin = {
                "app.bugbank.StepDetails",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        },
        glue = {"app.bugbank"},
        dryRun = false
)

@CucumberContextConfiguration
@SpringBootTest
@Slf4j
@Listeners({ListenerTest.class})
public class RunnerTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass(){
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(@NotNull PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        ScenarioSupport.getInstance().setTagsNames(pickleWrapper.getPickle().getTags().toString().replace("@","").replace(",","_").replace("[","").replace(" ",""));
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios(){
        return testNGCucumberRunner.provideScenarios();
    }
    @BeforeMethod
    public void setUp() {}

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        SetUp.getDriver().close();

    }

    @AfterClass (alwaysRun = true)
    public void AfterClass(){
        testNGCucumberRunner.finish();
    }
}

