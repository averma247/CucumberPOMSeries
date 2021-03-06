package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private String title;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		// Write code here that turns the phrase above into concrete actions
		//DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		loginPage.goToLoginPage();
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Step user gets the title of the page");
		title=loginPage.getLoginPageTitle();
		System.out.println("Page title: "+ title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("page title should be "+expectedTitleName);
		Assert.assertTrue(title.contains(expectedTitleName));

	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("forgot your password link should be displayed");
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("page title should be "+username);
		loginPage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("page title should be "+password);
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Steps user clicks on Login button");
		loginPage.clickOnLogin();
	}




}
