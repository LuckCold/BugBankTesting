package app.bugbank;

import app.bugbank.utils.SeleniumUtils;
import app.bugbank.utils.SetUp;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;

import static app.bugbank.utils.ScenarioSupport.*;

@Slf4j
public class Hooks {

    @BeforeTest
    public void startDriver(){
        SetUp.startDriver(SeleniumUtils.getBrowser());
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        log.info(">>>AFTER STEP<<<");
        if (scenario.isFailed()){
            getInstance().scenario = scenario;
            final byte[] screenshot = ((TakesScreenshot) SetUp.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", getInstance().getTagsNames());
            scenario.getLine();
            scenario.isFailed();
        } else {
            getInstance().scenario = scenario;
            final byte[] screenshot = ((TakesScreenshot) SetUp.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", getInstance().getTagsNames());

        }

    }
}
