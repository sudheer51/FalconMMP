package org.iit.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class LoginPage extends UtilityFunctions {
	
	//Instantiate the WebDriver
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public boolean login(String uname,String pword)
	{
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
		Reporter.log("--Clicked on Login Button--", true);
		String actual = driver.findElement(By.xpath("//h3")).getText();
		String expected = uname;
		return actual.contains(expected);
	}

}
