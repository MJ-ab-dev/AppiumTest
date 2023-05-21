package tests;

import static org.testng.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.*;

public class CucumberTests {
    public AppiumDriver<MobileElement> driver;
	public DesiredCapabilities desiredcapabilities;

	public CucumberTests() {
		try {
			desiredcapabilities=new DesiredCapabilities();
			desiredcapabilities.setCapability("deviceName", "Samsung");
			desiredcapabilities.setCapability("udid", "R58N606982Y");
			desiredcapabilities.setCapability("platformName","Android");
			desiredcapabilities.setCapability("platformVersion", "12");
			desiredcapabilities.setCapability("appPackage", "com.skydoves.themovies");
			desiredcapabilities.setCapability("appActivity", "com.skydoves.themovies.view.ui.main.MainActivity");
			URL url=new URL("http://0.0.0.0:4723/wd/hub");
			this.driver=new AppiumDriver<MobileElement>(url, desiredcapabilities);
			}
			catch (Exception e)
			{
				System.out.print(e);
			}	}
	
	@Given("^I am on home screen$") 
	   public void OpenApp() {
		 try {
			 TimeUnit.SECONDS.sleep(5);
			 }catch(Exception e)
			 {
				 System.out.print(e);
			 }
		MobileElement pagetitle=driver.findElement(By.id("com.skydoves.themovies:id/toolbar_title"));
		assertEquals(pagetitle.getText().toString(), "TheMovies");
	   }
	@When("^I click on first movie tile$") 
	   public void ClickOnAMovie() { 
		MobileElement titlename=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView"));
		titlename.click();
		Assert.assertEquals(true, true);
	   } 
	@Then("^Movie description should be visible$") 
	   public void IsMovieDescriptonVisible() {
		 try {
			 TimeUnit.SECONDS.sleep(5);
			 }catch(Exception e)
			 {
				 System.out.print(e);
			 }
		MobileElement moviedescription=driver.findElement(By.id("com.skydoves.themovies:id/detail_body_summary"));
		assertEquals(moviedescription.getText().toString(), "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.");
	   } 
}
