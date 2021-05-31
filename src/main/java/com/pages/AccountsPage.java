package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {


	private WebDriver driver;

	/**
	 * Locators used in the page.
	 */

	@FindBys({
		@FindBy(how = How.CSS, using = "div#center_column span"),
	})
	private List<WebElement> accountSections;



	public AccountsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public int getAccountsSectionCount() {
		return accountSections.size();
	}
	
	public List<String> getAccountsSectionsList() {

		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList = accountSections;

		for (WebElement e : accountsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);
		}

		return accountsList;

	}
	

}
