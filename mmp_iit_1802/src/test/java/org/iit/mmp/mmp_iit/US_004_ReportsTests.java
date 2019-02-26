package org.iit.mmp.mmp_iit;

import java.util.List;

import org.iit.mmp.pages.LoginPage;
import org.iit.util.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_004_ReportsTests extends TestBaseClass{
	

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
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/viewreports.php");
  } 
	
	
	public boolean isReportExists(String description)
	{
		boolean result = false;
		List<WebElement> descriptionList = driver.findElements(By.xpath("//table[@class='table']//p"));
		for(int i =0;i<descriptionList.size();i++)
		{
			if(descriptionList.contains(description))
			{
				result = true;
			}
		}
		return result;

	}
	
	
	
	
	
	
	
	
	
	
	

}
