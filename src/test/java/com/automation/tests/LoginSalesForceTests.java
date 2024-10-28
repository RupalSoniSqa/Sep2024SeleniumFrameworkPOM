package com.automation.tests;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.login.LoginPage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

@Listeners(com.automation.utility.FirebaseListenerUtility.class)
public class LoginSalesForceTests extends BaseTest {

	@Test
	public void SalesForce_login() throws InterruptedException, IOException {

		String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameData);
		loginpage.enterPasswrod(passwordData);
		driver = loginpage.clickLoginButton();
		loginpage.clickremembermeButton();
		closeDriver();
	}

	@Test
	public void Check_RememberMe() throws InterruptedException, IOException {

		String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameData);
		loginpage.enterPasswrod(passwordData);
		loginpage.clickrememberme();
		Thread.sleep(3000);
		driver = loginpage.clickLoginButton();
		loginpage.clickremembermeButton();
		closeDriver();

	}

	@Test
	public void Forgot_Password() throws InterruptedException, IOException {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickforgotpasswordEle();
		Thread.sleep(5000);
		loginpage.clickUserNameEle();
		loginpage.continueButtonEle();
		Thread.sleep(5000);
		loginpage.returntologinEle();
		Thread.sleep(5000);

		closeDriver();
	}

	public void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		LoginSalesForceTests ob = new LoginSalesForceTests();

		// ob.SalesForce_login();
		// ob.Check_RememberMe();
		ob.Forgot_Password();
	}
}
