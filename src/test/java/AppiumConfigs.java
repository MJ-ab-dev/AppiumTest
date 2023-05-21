import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;

public class AppiumConfigs {

	public DesiredCapabilities desiredcapabilities;
    public String deviceName;
    public String udid;
    public String platformName;
    public String platformVersion;
    public String appPackage;
    public String appActivity;
    AppiumDriver<MobileElement> driver;
    
	AppiumConfigs()
	{
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
	
	public AppiumDriver<MobileElement> getAppDriver()
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
		return driver;
		}
		catch (Exception e)
		{
			System.out.print(e);
			return null;
		}

	}
	
	public void findElement(AppiumDriver<MobileElement> apd)
	{
		List<MovieDetail>movieDetails=new ArrayList<MovieDetail>();
		AppiumDriver<MobileElement> driver=apd;
		
		String fistpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[";
	 
		String secondpath="]/android.widget.ImageView";

		MobileElement element;
		MobileElement moviename;
		MobileElement moviedate;
		MobileElement movierating;

			 for(int i=0;i<4;i++)
			 {
				 String path=fistpath+String.valueOf(i+1)+secondpath;
				 element=driver.findElement(By.xpath(path));
				 element.click();
				 try {
				 //TimeUnit.SECONDS.sleep(10);
				 }catch(Exception e)
				 {
					 System.out.print(e);
				 }
				 moviename=driver.findElement(By.id("com.skydoves.themovies:id/detail_header_title"));
				 moviedate=driver.findElement(By.id("com.skydoves.themovies:id/detail_header_release"));
				 movierating=driver.findElement(By.id("com.skydoves.themovies:id/detail_header_star"));
				 MovieDetail md=new MovieDetail(); 
				 md.moviename=moviename.getText();
				 md.releasedate=moviedate.getText();
				 md.movierating=new Float(movierating.getText());
				 movieDetails.add(md);
				 driver.navigate().back();
			 }
	}
}
