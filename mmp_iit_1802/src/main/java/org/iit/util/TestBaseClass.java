package org.iit.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestBaseClass {
	public WebDriver driver=null;
	@BeforeClass
	public void invokeBrowser()
	{
 	    WebDriverManager.chromedriver().setup();
 		driver = new ChromeDriver()
	}

}
