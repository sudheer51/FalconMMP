package org.iit.mmp.mmp_iit;

import java.util.List;

import org.iit.mmp.pages.LoginPage;
import org.iit.util.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//ctrl+shift+O organize imports


public class US_002_PatientDetailsTable extends TestBaseClass{
	
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
	@Test(priority=2,description="TC_0123")
	public void appoinmentDetails()
	{
		List<WebElement> hList = validatePatientTableHeaderValues();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(hList.get(0).getText().contains("Date"), "Date is not displayed in the header of the Patient Details Table");
		sa.assertTrue(hList.get(1).getText().contains("Time"), "Time is not displayed in the header of the Patient Details Table");
		sa.assertTrue(hList.get(2).getText().contains("Appointment"), "Appointment is not displayed in the header of the Patient Details Table");
		sa.assertTrue(hList.get(3).getText().contains("Doctor"), "Doctor is not displayed in the header of the Patient Details Table");
		sa.assertAll();
	}
	

 
	public List<WebElement> validatePatientTableHeaderValues()
	{
		Reporter.log("--Display of Appointments starts from here--", true);
		System.out.println("Sno. || Date || Time || Appointment || Doctor");
		List<WebElement> lheaderValue=driver.findElements(By.xpath("//table[@class='table']//th"));
		System.out.println("Number of header values " + lheaderValue.size());
		return lheaderValue;
	}
	
	
	
	

}
