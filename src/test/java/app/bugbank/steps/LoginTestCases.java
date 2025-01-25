package app.bugbank.steps;
import app.bugbank.RunnerTest;
import app.bugbank.pages.login.LoginPageAction;
import io.cucumber.java.en.*;

public class LoginTestCases extends RunnerTest {

    LoginPageAction action = new LoginPageAction();
    @Given("I access the Home Page")
    public void i_access_the_home_page() {
        action.accesHomePage();

    }
    @When("click in Register")
    public void clickInRegister() {

    }

    @And("enter the email {string}")
    public void enterTheEmail(String email) {
        System.out.println("Email inserido: " + email);
    }

    @And("enter the name {string}")
    public void enterTheName(String name) {
        System.out.println("Nome inserido: " + name);
    }

    @And("enter the password {string}")
    public void enterThePassword(String password) {
        System.out.println("Senha inserida: " + password);
    }

    @And("confirm the password {string}")
    public void confirmThePassword(String password) {
        System.out.println("Senha confirmada: " + password);
    }

    @And("enable the account balance")
    public void enableTheAccountBalance() {
        System.out.println("Saldo da conta habilitado");
    }

    @And("create account")
    public void createAccount() {
        System.out.println("Clicou novamente no botão de Registro");
    }

    @Then("I back to the login page")
    public void iBackToTheLoginPage() {
    }
}
