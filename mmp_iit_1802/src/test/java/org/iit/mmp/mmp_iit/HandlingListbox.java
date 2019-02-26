package org.iit.mmp.mmp_iit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingListbox {

	public static void main(String[] args) {
		
		WebElement e=null ;//= driver.findElement(By.id("day"));
		Select select =new Select(e);
		select.selectByValue("1");
		select.selectByVisibleText("Day");
		select.selectByIndex(0);
		
		List<WebElement> list = select.getOptions();
		for(int i=0;i<list.size();i++)
		{
			list.get(i).click();
			System.out.println(list.get(i).getText());
		}
		
//		Frames -> with in the html page
//		window-> a new browser
//		alert->popupwith out any properties..

		
	}
}
