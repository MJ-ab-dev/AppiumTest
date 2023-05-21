package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseClass {

	public DesiredCapabilities desiredcapabilities;
    public String deviceName;
    public String udid;
    public String platformName;
    public String platformVersion;
    public String appPackage;
    public String appActivity;
    AppiumDriver<MobileElement> driver;
    
    
	public BaseClass() {
		this.desiredcapabilities=new DesiredCapabilities();
		this.appActivity="com.skydoves.themovies.view.ui.main.MainActivity";
		//this.appActivity="myexportleftovers.android.app.activities.SplashActivity";
		this.appPackage="com.skydoves.themovies";
		//this.appPackage="myexportleftovers.android.app";
		this.deviceName="Galaxy A21s";
		this.platformName="Android";
		this.platformVersion="13";
		this.udid="R58N606982Y";
	}
	
	@BeforeTest
    public void Setup()
    {
		try {
			this.desiredcapabilities.setCapability("deviceName", this.deviceName);
			this.desiredcapabilities.setCapability("udid", this.udid);
			this.desiredcapabilities.setCapability("platformName",this.platformName);
			this.desiredcapabilities.setCapability("platformVersion", this.platformVersion);
			this.desiredcapabilities.setCapability("appPackage", this.appPackage);
			this.desiredcapabilities.setCapability("appActivity", this.appActivity);
			//URL url=new URL("http://localhost:4723/wd/hub/");
		  URL url=new URL("http://0.0.0.0:4723/wd/hub");
			this.driver=new AppiumDriver<MobileElement>(url, desiredcapabilities);
			}
			catch (Exception e)
			{
				System.out.print(e);
			}
    }
	@AfterTest
	public void TearDown()
	{
		//this.driver.close();
		//this.driver.quit();
	}
}
