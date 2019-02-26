package org.iit.mmp.mmp_iit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.iit.util.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleCode extends TestBaseClass{
	By fname = By.name("fname");
	By dateOfBirth = By.id("datepicker");
	By license = By.id("license");
	HashMap<String,String> hmap = new HashMap<String,String>();

	@Test
	public void verifyLogic() {

		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
		enterLicense();

	}
	public void enterLicense() {
		driver.findElement(license).clear();
		String licenseValue = Integer.toString(getRandomNumber(10000000, 7));
		System.out.println("Entering License Value::" + licenseValue);
		driver.findElement(license).sendKeys(licenseValue);
		hmap.put("license", licenseValue);

	}

public int getRandomNumber(int limit, int digits) {
		Random rnd = new Random();
		String value = "";
		for (int i = 0; i < digits; i++) {
			value = value + "9";
		}
		int result = Integer.parseInt(value) + rnd.nextInt(limit);
		return result;
	}


	public void enterFirstName()
	{
		driver.findElement(fname).clear();
		String fNameValue = "testFN" + getRandomChar();
		driver.findElement(fname).sendKeys(fNameValue);
		hmap.put("fName",fNameValue);

	}

	public void enterDateOfBirth() 
	{
		WebElement datePicker = driver.findElement(dateOfBirth);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		datePicker.sendKeys(sdf.format(new Date()));
		hmap.put("date", datePicker.getAttribute("value"));
	}

	public char getRandomChar() 
	{
		Random rnd = new Random();
		int k = 97 + rnd.nextInt(26);
		System.out.println((char) k);
		return (char) k;
	}
}
