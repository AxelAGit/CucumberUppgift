package stepDefinitions;

import org.openqa.selenium.WebDriver;

import org.junit.Assert;

//This class is used for test assertion
public class Assertions {
	// Asserts text
	static void getText(String expectedText, String actualText, WebDriver myDriver) {
		System.out.println("Entered Assertions.getText Class");
		try {
			Assert.assertEquals(expectedText, actualText);
			System.out.println(expectedText + " - Test successful");
		} catch (Throwable testFailed) {
			System.out.println(expectedText + " - Test failed");
			System.out.println("Expected: " + expectedText);
			System.out.println("Actual: " + actualText);
			Assert.fail(expectedText + " - Test failed");
		}
	}

	// Asserts Url
	static void getWebsite(String expectedText, WebDriver myDriver) {
		System.out.println("Entered Assertions.getWebsite Class");
		try {
			Assert.assertEquals(expectedText, myDriver.getCurrentUrl());
			System.out.println(expectedText + " - Test successful");
		} catch (Throwable testFailed) {
			System.out.println(expectedText + " - Test failed");
			System.out.println("Expected: " + expectedText);
			System.out.println("Actual: " + myDriver.getCurrentUrl());
			Assert.fail(expectedText + " - Test failed");
		}
	}
}
