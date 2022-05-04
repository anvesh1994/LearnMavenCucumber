package StepDefinitions;

import org.openqa.selenium.By;

public class RedBusHome {
	
	public By Source() { return By.id("txtSource"); }
	public By Destination() { return By.id("txtDestination"); }
	public By OnWardDate() {return By.id("txtOnwardCalendar");}
	public By SearchBuses() {return By.xpath("//Button[text()='Search Buses']");}

}
