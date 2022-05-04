package StepDefinitions;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RedBusDefinitions extends WebDriverClass  {
	
	String a,b,sum;
	WebDriver driver = WebDriverClass.initialiseDriver();
	Navigation nav = new Navigation();
	RedBusHome red = new RedBusHome();
	ViewSeats view = new ViewSeats();
	
	@Given("^i enter first string \"([^\"]*)\"$")
	public void i_enter_first_number(String x)
	{
		 a = x;
	}
	
	 @Given("^i enter second string \"([^\"]*)\"$")
	public void i_enter_second_number(String x)
	{
		 b = x;
	}
	
	@When("i add the two strings")
	public void i_add_the_numbers()
	{
		sum = a+b;
	}
	
	@Then("^concatination of above strings should be \"([^\"]*)\"$")
	public void addition_of_numbers_should_be(String expected)
	{
		assertEquals(sum, expected);
	}
	
	@Given("i am on Redbus Site")
    public void i_am_on_redbus_site(){
        
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
  
        }
	
	 @When("^i am on \"([^\"]*)\" page$")
	    public void i_am_on_something_page(String strArg1) throws Throwable {
		 Method method = nav.getClass().getMethod(strArg1, new Class[] {});
		 By locator = (By) method.invoke(nav, null);
		 	//String property = System.getProperty(strArg1);
	       driver.findElement(locator).click();
	    }
	 
	 @When("^i enter \"([^\"]*)\" in \"([^\"]*)\" field$")
	    public void i_enter_something_in_something_field(String strArg1, String strArg2) throws Throwable {
		 Method method = red.getClass().getMethod(strArg2, new Class[] {});
		 By locator = (By) method.invoke(red, null);
		 driver.findElement(locator).sendKeys(strArg1);
		 
	    }

	 @And("^i select \"([^\"]*)\" from the dropdown$")
	    public void i_select_something_from_the_dropdown(String strArg1) throws Exception 
	    {
	    	List<WebElement> element=driver.findElements(By.xpath("//*[@id='C120_suggestion-wrap']/descendant::li"));
	    	for (WebElement webElement : element)
	    	{   try {
	    	    if(webElement.getText().equals(strArg1))
	    	    {
	    	    	webElement.click();
	    	    	break;
	    	    }
	    	}
	    	catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
	    	}
	    	
	    }
	 
//	 @And("^i click \"([^\"]*)\" button$")
//	    public void i_click_something_button(String strArg1) throws Throwable {
//		 Method method = red.getClass().getMethod(strArg1, new Class[] {});
//		 By locator = (By) method.invoke(red, null);
//		 driver.findElement(locator).click();
//	    }
	 
	 @And("^i click \"([^\"]*)\" button on \"([^\"]*)\" page$")
	    public void i_click_something_button_on_something_page(String strArg1, String strArg2) throws Throwable {
		 String className = "StepDefinitions."+ strArg2;
		 Class dummy = Class.forName(className);
			Object	 obj = dummy.newInstance();
			 Method method = obj.getClass().getMethod(strArg1, new Class[] {});
			 By locator = (By) method.invoke(obj, null);
			 driver.findElement(locator).click();
	    }

}
