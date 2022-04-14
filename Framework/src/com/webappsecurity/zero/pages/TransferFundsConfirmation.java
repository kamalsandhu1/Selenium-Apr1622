package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirmation {
	
	@FindBy(css="#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement sccMsg;
	
	@FindBy(css="#settingsBox > ul > li:nth-child(3) > a")
	private WebElement usrnm;
	
	@FindBy(id="logout_link")
	private WebElement id;
	
	@FindBy(id="signin_button")
	private WebElement sbtn;
	
	
	public String getConfMsg() {
		String confmsg = sccMsg.getText();
		
		return confmsg;
	}
	
	public void logoutfromapp() {
		usrnm.click();
		id.click();
		sbtn.click();
		
		
		
	}
		public TransferFundsConfirmation(WebDriver driver) {
			PageFactory.initElements(driver, this);
		
	}
		
}
