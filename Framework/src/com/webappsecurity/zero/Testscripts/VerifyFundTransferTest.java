package com.webappsecurity.zero.Testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.pages.AccountSummary;
import com.webappsecurity.zero.pages.Login;
import com.webappsecurity.zero.pages.TransferFundsConfirmation;
import com.webappsecurity.zero.pages.TransferFundsPage;
import com.webappsecurity.zero.pages.TransferFundsVerify;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base{

	@Test
	
	public void verifyFunfTransfer() throws IOException {
		
		Login lp = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		TransferFundsPage tff = new TransferFundsPage(driver);
		TransferFundsVerify vrf = new TransferFundsVerify(driver);
		TransferFundsConfirmation cnf = new TransferFundsConfirmation(driver);
		
		String[][] data = GenericMethods.getData("C:\\Users\\sandh\\OneDrive\\Desktop\\IT course\\Test.xlsx", "Sheet1");
		
		
		for(int i=1;i<data.length;i++) {
		lp.applicationLogin(data[i][0] , data[i][1]);
		driver.navigate().back();
		acc.clickTranFund();
		tff.trnsfFnds(data[i][2], data[i][3]);
		vrf.clickSbmt();
		String actualText = cnf.getConfMsg();
		String expectedText = data[i][4];
		Assert.assertEquals(actualText, expectedText);
		cnf.logoutfromapp();
		}
	}
	
	
}
