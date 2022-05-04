package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverClass {
	
	public static WebDriver initialiseDriver()
	{
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			return driver;
	}

}
