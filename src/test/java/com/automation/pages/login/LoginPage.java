package com.automation.pages.login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.pages.login.base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(id = "username")WebElement userNameEle;
	@FindBy(id = "password")WebElement passwordElement;
	@FindBy(id = "Login")WebElement loginButtonElement;
	@FindBy(xpath ="//*[@id=\"editPage\"]/p[2]/a[1]")WebElement remembermeButtonElement;
	@FindBy(id ="rememberUn")WebElement remembermeEle;
	@FindBy(id ="forgot_password_link")WebElement forgotpasswordEle;
	@FindBy(id="continue")WebElement continueButtonEle;
	@FindBy(id = "un")WebElement userNameElement;
	@FindBy(xpath="//*[@id=\\\"forgotPassForm\\\"]/a")WebElement returntologinEle;

	public LoginPage(WebDriver driver) {
		// PageFactory.initElements(driver, this);
		super(driver);
	}

	public void enterUserName(String data) {
		enterText(userNameEle, data, "username field");
	}

	public void enterPasswrod(String data) {
		enterText(passwordElement, data, "password field");
	}

	public WebDriver clickLoginButton() {
		clickElement(loginButtonElement, "login button");
		return driver;
	}
	
	public void clickremembermeButton() {
		clickElement(remembermeButtonElement, "rememberme button");
	}
	
	public void clickrememberme() {
		clickElement(remembermeEle, "rememberme checkbox");
	}
	
	public void clickforgotpasswordEle() {
		clickElement(forgotpasswordEle, "forgotpassword link");
	}
	
	public void continueButtonEle() {
		clickElement(continueButtonEle, "continue button");
	}
	
	public void returntologinEle() {
		clickElement(returntologinEle, "returntologin button");
	}
	public void clickUserNameEle() {
		clickElement(userNameEle, "username field");
	}
	
	
	public Alert switchToErrorAlert() {
		return switchtoAlert();
	}
	public String extractTextFromAlert(Alert a) {
		return getAlertText(a, "LoginError Alert");
			}
	public void acceptErrorAlert(Alert a) {
		AcceptAlert(a);
	}
	public void rejectErrorAlert(Alert a) {
		CancelAlert(a);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
