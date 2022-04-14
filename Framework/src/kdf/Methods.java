package kdf;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {
	
	WebDriver driver;
	public void openBrowser() {
		driver = new ChromeDriver();
		
	}
	public void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	public void navigateToApp(String url) {
		driver.get(url);
	}
	public void enterInTextox(String locvalue, String testdata) {
		driver.findElement(By.id(locvalue)).sendKeys(testdata);
	}
	public void clickButton(String loc, String locval) {
		if(loc.equals("name")) {
		driver.findElement(By.name(locval)).click();
		}
		else if(loc.equals("xpath")) {
			driver.findElement(By.xpath(locval)).click();
		}
	}
	public String verifymsg(String loc, String locval) {
		String Actualmsg = null;
		if(loc.equals("cssSelector")) {
		Actualmsg = driver.findElement(By.cssSelector(locval)).getText();
		}
		else if(loc.equals("id")) {
			Actualmsg = driver.findElement(By.id(locval)).getText();
		}
		return Actualmsg;
	}
	public void closeBrowser() {
		driver.quit();
	}
}
