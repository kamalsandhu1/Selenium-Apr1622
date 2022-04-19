package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {

	@Test
	public void invalidLogintest() throws IOException {
		String[][] data = GenericMethods.getData("C:\\Users\\sandh\\OneDrive\\Desktop\\IT course\\Test.xlsx", "Sheet2");
		Methods mtd = new Methods();
		
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			case"openBrowser":
				mtd.openBrowser();
				//dsfdsfsdf
				break;
			case"maxWindow":
				mtd.maximizeBrowserWindow();
				break;
			case"impWait":
				mtd.implicitWait();
				break;
			case"NavigatetoApp":
				mtd.navigateToApp(data[i][6]);
				break;
			case"enterinTextbox":
				mtd.enterInTextox(data[i][5], data[i][6]);
				break;
			case"clickButton":
				mtd.clickButton(data[i][4], data[i][5]);
				break;
			case"verifyMsg":
				String actualmsg = mtd.verifymsg(data[i][4], data[i][5]);
				String expectedtext = data[i][6];
				Assert.assertEquals(actualmsg, expectedtext);
				break;
			case"closeApp":
				mtd.closeBrowser();
				break;
				
			}
		}
	}
	
}
