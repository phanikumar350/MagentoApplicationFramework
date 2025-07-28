package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.Setter;
import module.*;
import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SignUpDefinitions extends BaseTest {


    @Getter
    @Setter
    private String email;
    @Setter
    @Getter
    private String password;
    WebDriver driver;
    CreateAccount createAccount;
    HomePage homePage;
    SignOut signOut;
    AccountPage account;
    SignIn signIn;

    @Before
    public void setup() {
        driver = initializeDriver();
        homePage = new HomePage(driver);
        createAccount = new CreateAccount(driver);
        account = new AccountPage(driver);
        signOut = new SignOut(driver);
        signIn = new SignIn(driver);
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @When("User lands in homepage")
    public void uUser_lands_in_homepage() {
        homePage.createAccount();
    }

    @When("User provides the following details")
    public void user_provides_the_following_details(DataTable dataTable) {
        String email;
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Iterator<Map<String, String>> map = data.iterator();
        for (Iterator<Map<String, String>> it = data.iterator(); it.hasNext(); ) {
            Map<String, String> arg = it.next();
            String timeStamp = String.valueOf(System.currentTimeMillis());
            this.setEmail(arg.get("Email").replace("<timestamp>", timeStamp));
            email = this.getEmail();
            this.setPassword(arg.get("Password"));
            createAccount.fillSignupForm(arg.get("First Name"), arg.get("Last Name"), email, arg.get("Password"));
        }
    }

    @When("submits the registration form")
    public void submits_the_registration_form() {
        createAccount.submitForm();
    }

    @Then("A success message should be displayed indicating registration is complete {string}")
    public void aSuccessMessageShouldBeDisplayedIndicatingRegistrationIsComplete(String message) {
        account.isRegistrationSuccessful(message);
    }

    @Then("Sign out")
    public void signOut() {
        signOut.clickSignOut();
    }

    @When("Signing using credentials")
    public void signingUsingCredentials() {
        signIn.signInInUsingCredentials(this.getEmail(), this.getPassword());
    }

    @Then("user should be successfully logged in")
    public void userShouldBeSuccessfullyLoggedIn() {
        account.isSignInSuccessful();
    }

    @After
    public void quit() {
        super.tearDown();
    }
}
