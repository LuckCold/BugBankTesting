package app.bugbank.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SetUp {
    protected static WebDriver driver;
    private static SetUp instance;

    public enum Browser{
        CHROME(0),
        EDGE(1),
        FIREFOX(2),
        IE(3);

        private Integer value;
        Browser(Integer value){
            this.value = value;
        }
    }
    SetUp(){}

    public static void startDriver(Browser browser) {
        try {
            switch (browser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e){
            log.error(e.getMessage());
            throw new WebDriverException("ERRO AO INICIAR O WEBDRIVER!" + e);
        }
    }
    public static WebDriver getDriver(){
        if (Objects.isNull(driver)){
            SetUp.startDriver(SeleniumUtils.getBrowser());
        }
        return driver;
    }


}
