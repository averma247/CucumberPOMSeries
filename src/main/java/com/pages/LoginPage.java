package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	/**
	 * Locators used in the page.
	 */
	@FindBy(name="email")
	private WebElement emailID;
	
	@FindBy(name="passwd")
	private WebElement passwd;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInButton;
	
	@FindBy(linkText="Forgot your password?")
	private WebElement forgotPwdLink;
	
	@FindBy(linkText="Sign in")
	private WebElement loginLink;
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean isForgotPwdLinkExist(){
		return forgotPwdLink.isDisplayed();
	}
	
	public void enterUsername(String username){
		emailID.sendKeys(username);
	}
	
	public void enterPassword(String password){
		passwd.sendKeys(password);
	}
	
	public void clickOnLogin(){
		signInButton.click();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		emailID.sendKeys(un);
		passwd.sendKeys(pwd);
		signInButton.click();
		return new AccountsPage(driver);
	}
	
	public void goToLoginPage(){
		if(loginLink.isDisplayed())
			loginLink.click();
	}
	
	
}
