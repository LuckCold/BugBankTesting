package app.bugbank.pages.login;

import app.bugbank.utils.SetUp;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;



@Getter
@Component
public class LoginElementMap {

    public LoginElementMap(){
        PageFactory.initElements(SetUp.getDriver(), this);

    }

    @FindBy(id = "text-input")
    protected WebElement loginInput;

    @FindBy(id = "password-input")
    protected WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement loginButton;

    @FindBy(xpath = "//a[@href='/register']")
    protected WebElement registerLink;


    @FindBy(xpath = "//h1[contains(text(),'O banco com bugs')]/preceding-sibling::span")
    protected WebElement imgLogo;

    @PostConstruct
    public void init() {
        PageFactory.initElements(SetUp.getDriver(), this);
    }
}
