package com.cucumber;

import org.openqa.selenium.WebDriver;
import com.constants.ProjectXpaths;
import com.corelib.Library1;
import com.corelib.Library2;
import com.corelib.io;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions {

	Library1 lib1 = new Library1();
	Library2 lib2 = new Library2();

	WebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Given("Open {string} browser and navigate to {string}")
	public void open_browser_and_navigate_to(String browser, String webAddress) {
		try {
			setDriver(lib1.navigateToWebpage(browser, webAddress));
		} catch (Exception err) {
			System.err.println(err.getMessage());
		}
	}

	@Then("Enter {string} and {string} to login page")
	public void enter_and_to_login_page(String username, String password) {

		try {
			lib1.findAndEnterText(driver, ProjectXpaths.loginpage_usernametextbox.label, username);
			lib1.findAndEnterText(driver, ProjectXpaths.loginpage_passwordtextbox.label, password);
		} catch (Exception err) {
			System.err.println(err.getMessage());
		}
	}

	@And("click submit button")
	public void click_submit_button() {
		try {
			lib1.findAndClick(driver, ProjectXpaths.loginpage_submitbutton.label);
		} catch (Exception err) {
			throw err;
		}
	}

	@And("handle screen resolution dialog")
	public void handle_screen_resolution_dialog() {
		try {
			lib2.handleScreenResolutionDialog(driver);
		} catch (Exception err) {
			System.err.println(err.getMessage());
		}
	}

	@Then("handle EULA dialog")
	public void handle_EULA_dialog() {
		try {
			lib2.handleEULADialog(driver);
		} catch (Exception err) {
			System.err.println(err.getMessage());
		}
	}

	@Then("handle Date and Time wizard screen")
	public void handle_Date_and_Time_wizard_screen() {
		try {
			lib2.handleTimeAndDateWizard(driver);
		} catch (Exception err) {
			System.err.println(err.getMessage());
		}
	}

}
