import java.*;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
public class AppiumTestMainClass {

	public static void main (String [] args)
	{
		 AppiumConfigs apg= new AppiumConfigs();
        System.out.print("Application started"); 
        System.out.print("Application started"); 
		AppiumDriver<MobileElement>apd= apg.getAppDriver();
		apg.findElement(apd);
        System.out.print("Application finished"); 
	}
}
