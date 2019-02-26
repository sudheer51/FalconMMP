import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;	
import org.openqa.selenium.phantomjs.PhantomJSDriver;
public class GoogleTests { 
	@Test
	public void verifyTitle()
	{
	 
		WebDriverManager.phantomjs().arch64().setup();
	 	WebDriver driver = new  PhantomJSDriver();
		driver.get("http://www.total-qa.com");
		String actual = driver.getTitle();
		String expected="Total-QA - Future of Software Testing";
		Assert.assertEquals(actual,expected);
	}
}
