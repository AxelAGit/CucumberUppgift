package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;

public class StepDefinitions {

	private WebDriver driver;
	private String randomString = RandomGenerator.getRandomString(16); // this string is used to randomize the email
	private String expectedErrorMessage;

	@After
	public void tearDown() {
		driver.quit();
		System.out.println("Closed all the browsers");
	}

	@Given("I have navigated to the create user page")
	public void i_have_navigated_to_the_create_user_page() {
		String correctUrl = "https://forumet.vimla.se/register";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Computer\\Documents\\skola\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(correctUrl);
		ExplicitWait.correctWebsite(correctUrl, driver);
		Assertions.getWebsite(correctUrl, driver);
	}

	@Given("I have accepted the cookies")
	public void i_have_accepted_the_cookies() {
		ExplicitWait.clickButton(driver, By.id("cookie-continue-btn"));
	}

	@Given("I have entered a email {string}")
	public void i_have_entered_a_email(String email) {
		System.out.println(email);
		if (email.equals("thisEmailIsInUse@sharklasers.com")) {
			ExplicitWait.sendKeys(email, driver, By.id("email"));
		} else {
			ExplicitWait.sendKeys(randomString + email, driver, By.id("email"));
		}
	}

	@Given("I have entered a username {string}")
	public void i_have_entered_a_username(String username) {
		int i = Integer.parseInt(username);
		ExplicitWait.sendKeys(RandomGenerator.getRandomString(i) + Keys.ENTER, driver, By.id("username"));
	}

	@Given("I have entered a password {string}")
	public void i_have_entered_a_password(String password) {
		ExplicitWait.sendKeys(password, driver, By.id("password"));
	}

	@Given("I have entered a password in the repeat password box {string}")
	public void i_have_entered_a_password_in_the_repeat_password_box(String repeatPassword) {
		// Needed enter key to accept the password
		ExplicitWait.sendKeys(repeatPassword + Keys.ENTER, driver, By.id("password-confirm"));
	}

	@When("I press register user")
	public void i_press_register_user() {
		ExplicitWait.clickButton(driver, By.id("register"));
	}

	@Then("The result should be {string}")
	public void the_result_should_be(String login) {
		System.out.println(login);
		
		// successful login
		if (login.equals("https://forumet.vimla.se/")) {

			ExplicitWait.correctWebsite(login, driver);
			System.out.println(login);
			Assertions.getWebsite(login, driver);
			
		// long username error message	
		} else if (login.equals("longUsernameError")) {

			expectedErrorMessage = "Användarnamnet är för långt";
			login = ExplicitWait.textLocated(expectedErrorMessage, driver, By.id("username-notify"));
			System.out.println(login);
			Assertions.getText(expectedErrorMessage, login, driver);
			
		// passwords don't match error message	
		} else if (login.equals("passwordMismatchError")) {

			expectedErrorMessage = "Lösenorden är inte likadana. Var god skriv dem på nytt.";
			login = ExplicitWait.textLocated(expectedErrorMessage, driver, By.id("password-confirm-notify"));
			System.out.println(login);
			Assertions.getText(expectedErrorMessage, login, driver);
			
		// email is already in use error message
		} else if (login.equals("emailInUseError")) {

			expectedErrorMessage = "Denna mailadress finns redan registrerad på ett forumkonto";
			login = ExplicitWait.textLocated(expectedErrorMessage, driver, By.id("email-notify"));
			System.out.println(login);
			Assertions.getText(expectedErrorMessage, login, driver);
		}
	}
}
