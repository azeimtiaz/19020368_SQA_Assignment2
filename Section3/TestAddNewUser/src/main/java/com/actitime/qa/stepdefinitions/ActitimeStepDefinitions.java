package com.actitime.qa.stepdefinitions;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class ActitimeStepDefinitions extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	UsersPage usersPage;
	String sheetName = "Users";
	TestUtil testUtil;
	Logger log = Logger.getLogger(this.getClass());

	@Given("^User in the Actitime Loging Page$")
	public void user_in_the_Actitime_Loging_Page() throws Throwable {
	    
		initialization();
		loginPage = new LoginPage();
	}

	@When("^User Enter the User Name as  \"([^\"]*)\"$")
	public void user_Enter_the_User_Name_as(String userName) throws Throwable {
		loginPage.enterUserName(userName);
	}

	@Then("^User Enter the Password as  \"([^\"]*)\"$")
	public void user_Enter_the_Password_as(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@Then("^User click in Loging button$")
	public void user_click_in_Loging_button() throws Throwable {
		homePage =loginPage.clickSubmitButton();
	}

	@Then("^User should be able to successfuly loging to Actitime$")
	public void user_should_be_able_to_successfuly_loging_to_Actitime() throws Throwable {
	    
		homePage.validateActiTimeLogo();
		driver.quit();
		
	}

	//	Create new user steps
	@Given("^User is logged in to the application$")
	public void user_is_logged_in_to_app() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		loginPage.loging(properties.getProperty("username"), properties.getProperty("password"));
		homePage = loginPage.clickSubmitButton();
	}

	@Given("^User is in the Users page$")
	public void user_is_in_the_Users_Page() throws Throwable {
		usersPage = homePage.clickOnUsersLink();
	}

	@When("^User clicks add new user button$")
	public void user_clicks_add_new_user_button() throws Throwable {
		usersPage.clickNewUserButton();
	}

	@And("^User enters the firstname of new user as  \"([^\"]*)\"$")
	public void user_enters_the_firstname_as(String firstName) throws Throwable {
		usersPage.enterFirstName(firstName);
	}

	@And("^User enters the lastname of new user as  \"([^\"]*)\"$")
	public void user_enters_the_lastname_as(String lastName) throws Throwable {
		usersPage.enterLastName(lastName);
	}

	@And("^User enters the email of new user as \"([^\"]*)\"$")
	public void user_enters_the_email_as(String email) throws Throwable {
		usersPage.enterEmail(email);
	}

	@And("^User clicks the submission button$")
	public void user_clicks_the_submission_button() throws Throwable {
		usersPage.clickCreateUserLink();
	}

	@Then("User should be created successfully with first name {string} and last name {string}")
	public void user_is_created_successfully(String firstName, String lastName) {
		String userCreationMessage = usersPage.getUserCreationMessage();
		String validationMessage = "Account for " + firstName + " " + lastName + " has been created.";

		try {
			Assert.assertEquals(userCreationMessage, validationMessage);
			log.info("User " + firstName + " " + lastName + " created successfully");
		} catch (AssertionError error) {
			log.fatal("User creation failed");
			Assert.fail();
		}
		driver.quit();
	}
}
