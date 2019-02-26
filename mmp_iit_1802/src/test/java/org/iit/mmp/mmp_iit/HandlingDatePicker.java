package org.iit.mmp.mmp_iit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.iit.util.TestBaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandlingDatePicker extends TestBaseClass{
	
	@Test
	public void selectDate()
	{
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/providers.php");
		driver.findElement(By.id("opener")).click();
		
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();
		String actual = driver.findElement(By.className("ui-datepicker-title")).getText();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 2);
		
		
		Date dt =c.getTime();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM YYYY");
		System.out.println( sdf1.format(dt));
		 
		String expected = sdf1.format(dt);
		if(!(actual.equals(expected)))
		{
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			driver.findElement(By.linkText("20")).click();
		}
		else
		{
			System.out.println("Dates are matching ");
			driver.findElement(By.linkText("25")).click();
		}
		
	}

}
