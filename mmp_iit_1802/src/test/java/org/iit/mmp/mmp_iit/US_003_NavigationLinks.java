package org.iit.mmp.mmp_iit;

import org.iit.mmp.pages.LoginPage;
import org.iit.util.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_003_NavigationLinks extends TestBaseClass{


	@Parameters({"url"})
	@BeforeClass
	public void launchApplication(String url)
	{
		driver.get(url);
	}
	@Parameters({"username","password"})
	@Test(priority=1,description="TC_001")
	public void loginPatient(String username,String password)
	{
		LoginPage lPage = new LoginPage(driver);
		boolean result = lPage.login(username,password);
		Assert.assertTrue(result,"Login is successful");
		 
		 

	}
	@Test(priority=2,description="Verify Navigation Links")
	public void validateNavigationPath()
	{
		
		boolean result = verifyNavigationLink("Schedule Appointment","Current Appointments");
		Assert.assertTrue(result,"Failed to navigate to the Patient Profile Page");
	}
	public boolean verifyNavigationLink(String linkText,String expectedHeading)
	{
		 
		driver.findElement(By.xpath("//ul/li/a/span[contains(text(),'"+linkText+"')]")).click();
		String actualHeading = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		return actualHeading.contains(expectedHeading);
	}

}
