package com.corelib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.ProjectXpaths;

public class Library2 {
	Library1 lib1 = new Library1();

	public void handleScreenResolutionDialog(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectXpaths.screenresolution_dialog.label)));
			boolean isScreenResDialog = driver.findElement(By.xpath(ProjectXpaths.screenresolution_dialog.label))
					.isDisplayed();
			if (isScreenResDialog) {
				lib1.findAndClick(driver, ProjectXpaths.screenresolution_checkbox.label);
				lib1.findAndClick(driver, ProjectXpaths.screenresolution_okayButton.label);
			}

		} catch (Exception err) {
			throw err;
		}

	}
	
	public void handleEULADialog(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectXpaths.screenresolution_dialog.label)));
			boolean isScreenResDialog = driver.findElement(By.xpath(ProjectXpaths.eula_dialog.label)).isDisplayed();
			if (isScreenResDialog) {
				lib1.findAndClick(driver, ProjectXpaths.eula_acceptButton.label);
			}
		} catch (Exception err) {
			throw err;
		}
	}
	
	public void handleTimeAndDateWizard(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProjectXpaths.timeanddate_dialog.label)));
			boolean isScreenResDialog = driver.findElement(By.xpath(ProjectXpaths.timeanddate_dialog.label)).isDisplayed();
			if (isScreenResDialog) {		
				lib1.findAndClick(driver, ProjectXpaths.timeanddate_time_radiobutton.label);
				WebElement element = driver.findElement(By.xpath(ProjectXpaths.timeanddate_next.label));
				Actions actions = new Actions(driver);
				actions.moveToElement(element).click().build().perform();
			}
		} catch(Exception err) {
			throw err;
		}
	}
	
	public void handleHostnameAndPassword(WebDriver driver) {
		lib1.waitForElement(driver, xpath, seconds);
	}
	
	

}
