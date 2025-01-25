package app.bugbank.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

@Slf4j
public class SeleniumUtils {

    public static SetUp.Browser getBrowser(){
        String browser = System.getProperty("browser");
        if (browser == null) {
            log.info("Está sendo utilizado o Browser Default: Chrome");
            return SetUp.Browser.CHROME;
        } else {
            log.info("Está sendo utilizado o Browser: " + browser);
            return SetUp.Browser.valueOf(browser.toUpperCase());
        }
    }

    public static void waitUntilAppears(WebElement elementToWait, Long timeToWaitInSeconds) {
        WebDriverWait wait = new WebDriverWait(SetUp.getDriver(), Duration.ofSeconds(timeToWaitInSeconds));
        wait.until(ExpectedConditions.visibilityOf(elementToWait));
    }

    public static void takeScreenshot(String name) {
        try {
            File scrFile = ((TakesScreenshot) SetUp.getDriver()).getScreenshotAs(OutputType.FILE);
            String path = "target/screenshots/" + name + UUID.randomUUID() + "" + ".png";
            File screenshotLocation = new File(System.getProperty("user.dir")+ "/" + path);
            FileUtils.copyFile(scrFile, screenshotLocation);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
