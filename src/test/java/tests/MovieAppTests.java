package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class MovieAppTests extends BaseClass {

	public List<MovieDetail>moviedetails;
	
	public MovieAppTests()  {
		// TODO Auto-generated constructor stub
		moviedetails=new ArrayList<MovieDetail>();

	}
	
	@Test(priority=1, description = "Match the page title of the application")
public void CheckPageTitle()
{
	MobileElement pagetitle;
	pagetitle=driver.findElement(By.id("com.skydoves.themovies:id/toolbar_title"));
String titlenamefromelement=pagetitle.getText().toString();
if (titlenamefromelement.equals("TheMovies"))
    {
	System.out.println("Test: MatchTitleName: Success");
	}
else
{
	System.out.println("Test: MatchTitleName: Failed");
}
}
	
	

	
	@Test(priority=2, description = "Click on movie title", dependsOnMethods= {"CheckPageTitle"})
	public void ClickonMovieTitle()
	{
		 try {
			 TimeUnit.SECONDS.sleep(5);
			 }catch(Exception e)
			 {
				 System.out.print(e);
			 }
		
		MobileElement titlename=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView"));
		titlename.click();
		System.out.println("Clicked on Movie Title");
		driver.navigate().back();
	}
	
	@Test(priority=3, description = "Click on Multiple Movies",dependsOnMethods= {"ClickonMovieTitle"})
	public void ClickOnMovies()
	{
		String fistpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[";
		 
		String secondpath="]/android.widget.ImageView";
		try {
			 TimeUnit.SECONDS.sleep(5);
			 }catch(Exception e)
			 {
				 System.out.print(e);
			 }

		MobileElement element;

			 for(int i=0;i<4;i++)
			 {
				 String path=fistpath+String.valueOf(i+1)+secondpath;
				 element=driver.findElement(By.xpath(path));
				 element.click();
				 try {
				 TimeUnit.SECONDS.sleep(5);
				 }catch(Exception e)
				 {
					 System.out.print(e);
				 }
				 
				 driver.navigate().back();
				 try {
					 TimeUnit.SECONDS.sleep(5);
					 }catch(Exception e)
					 {
						 System.out.print(e);
					 }
			 }
		
	}
	
	@Test(priority=4, description = "Compare Movie Details", dependsOnMethods= {"ClickOnMovies"})
	public void CheckMovieDetails()
	{
		String fistpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[";
		 
		String secondpath="]/android.widget.ImageView";
		try {
			 TimeUnit.SECONDS.sleep(5);
			 }catch(Exception e)
			 {
				 System.out.print(e);
			 }
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
				 TimeUnit.SECONDS.sleep(5);
				 }catch(Exception e)
				 {
					 System.out.print(e);
				 }
				 moviename=driver.findElement(By.id("com.skydoves.themovies:id/detail_header_title"));
				 moviedate=driver.findElement(By.id("com.skydoves.themovies:id/detail_header_release"));
				 movierating=driver.findElement(By.id("com.skydoves.themovies:id/detail_header_star"));
				 MovieDetail md=new MovieDetail(); ;
				 md.moviename=moviename.getText();
				 md.releasedate=moviedate.getText();
				 md.movierating=new Float(movierating.getText());
				 System.out.println("-------------------------"+Integer.toString(i)+"------------------");
				 System.out.println(md.moviename);
				 System.out.println(md.releasedate);
				 System.out.println(md.movierating);
				 moviedetails.add(md);
				 System.out.println("-------------------------"+Integer.toString(i)+"------------------");

				 driver.navigate().back();
				 try {
					 TimeUnit.SECONDS.sleep(5);
					 }catch(Exception e)
					 {
						 System.out.print(e);
					 }
				 
			 }
			 new MovieDetail().CompareMovieDetails(moviedetails);

		
	}


	
//	@Test(priority=11, description = "Check Application Scrollability")
//	public void CheckScrollability()
//	{
//		 driver.findElement(MobileBy.AndroidUIAutomator(
//		            "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));		
//	
	
	@Test(priority=6, description = "Filter Movies on the basis of Rating", dependsOnMethods= {"CheckMovieDetails"})
	public void SortOnRating()
	{
		new MovieDetail().FilterMoviesByRating(moviedetails,7);
	}


	
	@Test(priority=7, description = "Scroll to a Specific Movie", dependsOnMethods= {"SortOnRating"})
	public void ScrollToAMovie()
	{
		String text="Sisu";
		 driver.findElement(MobileBy.AndroidUIAutomator(
				 "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));		
	}
	
	

}