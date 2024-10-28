package com.automation.pages.login.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utility.ExtentReportsUtility;

public class BasePage {

	protected WebDriver driver;
	private WebDriverWait wait = null;
	private Logger mylog = LogManager.getLogger(BasePage.class);
	protected ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			mylog.info("data is entered in the " + objectName);
			extentReport.logTestinfo("data is entered in the" + objectName);

		} else {
			mylog.error(objectName + "textbox is not displayed");
			extentReport.logTestFailed("data is entered in the" + objectName);

		}
	}

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = null;
		if (ele.isDisplayed()) {
			data = ele.getText();
			mylog.info("text is extracted from " + objectName);
		} else {
			mylog.error(objectName + " not dispalyed");
		}
		return data;
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			mylog.info(objectName + "button is clicked");
		} else {
			mylog.error(objectName + "button is not displayed");
		}
	}

	public void SelectElement(WebElement ele, String objectName) {
		if (!ele.isSelected()) {
			ele.click();
			mylog.info(objectName + "button is selected");
		} else {
			mylog.error(objectName + "button is already selected");
		}

	}

	public void selectByValue(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
	}

	public static void selectByText(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByVisibleText(value);
	}

	public void selectByIndex(WebElement ele, int value) {
		Select select = new Select(ele);
		select.selectByIndex(value);
	}

	public void mouseOverOnElement(WebElement ele, String objName) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		mylog.info("cursor moved to element=" + objName);
	}

	public Alert switchtoAlert() {
		waitForAlertToPresent(30, "error loginalert box");
		Alert alert = driver.switchTo().alert();
		mylog.info("switched to an alert");
		return alert;
	}

	public String getAlertText(Alert alert, String objectname) {
		mylog.info("etracting text in the " + objectname + "alert");
		String text = alert.getText();
		mylog.info("text is extracted from alert box is ==" + text);
		return text;
	}

	public void AcceptAlert(Alert alert) {
		alert.accept();
		mylog.info("Alert accepted");
	}

	public void CancelAlert(Alert alert) {
		alert.dismiss();
		mylog.info("Alert cancelled");
	}

	public void ContextClickOnElement(WebElement ele, String objName) {
		Actions action = new Actions(driver);
		action.contextClick(ele).build().perform();
	}

	public void waitForVisibility(WebElement ele, long timeInSec, String objectName) {
		mylog.info(objectName + "waiting for visibility for maximum of " + timeInSec + "sec");
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForAlertToPresent(long timeInSec, String objectName) {
		mylog.info(objectName + "waiting for visibility for maximum of " + timeInSec + "sec");
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForElementToClickable(WebElement ele, long timeInSec, String text, String objectName) {
		mylog.info(objectName + "waiting for visibility for maximum of " + timeInSec + "sec");
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitFortextToBePresentInElement(WebElement ele, long timeInSec, String objectName) {
		mylog.info(objectName + "waiting for visibility for maximum of " + timeInSec + "sec");
		WebDriverWait wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.textToBePresentInElement(ele, objectName));
	}

	public void waitForVisibility(WebElement ele, int time, int pollingtime, String objectName) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(pollingtime)).pollingEvery(Duration.ofSeconds(pollingtime))
				.ignoring(ElementNotInteractableException.class)
				.withMessage(objectName + "is not visible.fluent wait time expires");
		wait.until(ExpectedConditions.visibilityOf(ele));
		mylog.info(objectName + "is waited for visibility using fluent wait");

	}

}
