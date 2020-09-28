package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//This class deals with explicit wait

public class ExplicitWait {
	// waits for expectedText to load in a specific element
	static String textLocated(String expectedText, WebDriver myDriver, By by) {
		System.out.println("Entered ExplicitWait.textLocated Class");
		try {
			(new WebDriverWait(myDriver, 10)).until(ExpectedConditions.textToBe(by, expectedText));
			return myDriver.findElement(by).getText();

		} catch (Throwable couldNotFind_expectedText) {
			System.out.println(expectedText + " could not be found");
			return expectedText + " could not be found";
		}
	}

	// waits for a specific button to be clickable
	static void clickButton(WebDriver myDriver, By by) {
		System.out.println("Entered ExplicitWait.clickButton Class");
		try {
			(new WebDriverWait(myDriver, 10)).until(ExpectedConditions.elementToBeClickable(by));
			myDriver.findElement(by).click();

		} catch (Throwable couldNotClick_expectedButton) {
			System.out.println(by + "button could not be clicked");
		}
	}

	// Waits for the Url to be a specific one
	static void correctWebsite(String expectedWebpage, WebDriver myDriver) {
		System.out.println("Entered ExplicitWait.correctWebsite Class");
		try {
			(new WebDriverWait(myDriver, 10)).until(ExpectedConditions.urlToBe(expectedWebpage));
		} catch (Throwable couldNotClick_expectedButton) {
			System.out.println("Didn't load " + expectedWebpage);
		}
	}

	// Waits until text field elements have loaded to send text
	static void sendKeys(String text, WebDriver myDriver, By by) {
		System.out.println("Entered ExplicitWait.sendKeys Class");
		try {
			(new WebDriverWait(myDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
			myDriver.findElement(by).sendKeys(text);
		} catch (Throwable couldNot_sendKeys) {
			System.out.println("Could not send " + text);
		}
	}

}
