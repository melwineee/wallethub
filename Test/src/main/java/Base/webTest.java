package Base;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import Base.webTest;
public class webTest {
	public static WebDriver driver;
	
	
	static String facebook_user ="";
	static String facebook_password ="";
	static String facebook_post ="Hello World";
	
	
	public static void main(String[] args) {
		try {
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
		
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		 //Scenario 	1
		 TC001_loginToFacebook();
		 TC002_createPost();
		 //Scenario 	2
		 WHTC001_loginWalletHub();
		 WHTC002_postReview();
		} catch (Exception e) {
			System.out.println("catch");
			e.printStackTrace();
		} finally {
			
			driver.close();
		}
		                                         
	}
	
	public static void TC001_loginToFacebook() throws InterruptedException {
		

		driver.get("https://en-gb.facebook.com/");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(facebook_user);
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).click();
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(facebook_password);
		driver.findElement(By.name("login")).click();
		Thread.sleep(8000);
		if(driver.findElements(By.xpath("//a[@aria-label='Home']")).size()==1)
		{
			System.out.println("Facebook logged in successfully");
		}else {
			
			System.out.println("Unable to login facebook");
		}
		}
	
	public static void TC002_createPost() throws InterruptedException {
		
	driver.findElement(By.xpath("//a[@aria-label='Home']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(text(),'your mind')]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[@data-block='true']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@data-block='true']")).sendKeys(facebook_post);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Post']")).click();
	Thread.sleep(10000);
	if(driver.findElements(By.xpath("//div[text()='"+facebook_post+"']")).size()==1)
	{
		System.out.println("Post updated in Facebook successfully");
	}else {
		
		System.out.println("Post update in Facebook Failed");
	}
	
}

	public static void WHTC001_loginWalletHub() throws InterruptedException {
		
		driver.get("http://wallethub.com/profile/test_insurance_company");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("bmelwin1311@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Mak282252$");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		
	}
	
	public static void WHTC002_postReview() throws InterruptedException {
		Thread.sleep(8000);
		driver.get("http://wallethub.com/profile/test_insurance_company/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Write a Review'])[2]")).click();
		Thread.sleep(4000);
		
		  Actions actions = new Actions(driver);
	        //Retrieve WebElement 'Music' to perform mouse hover 
	    	WebElement menuOption = driver.findElement(By.xpath("(//*[name()='svg' and @height='35.75' ])[4]"));
	    	//Mouse hover menuOption 'Music'
	    	actions.moveToElement(menuOption).perform();
	    	System.out.println("Done Mouse hover on 'STAR'");
	    	
	    	Thread.sleep(4000);
	    	if(driver.findElements(By.xpath("//*[name()='svg' and @height='35.75' ]//*[name()='path' and @fill='#4ae0e1']")).size()==4)
	    	{
	    		System.out.println("Stars got lit up");
	    	}else {
	    		
	    		System.out.println("Stars did not lit up");
	    	}
	    	
	    	driver.findElement(By.xpath("(//*[name()='svg' and @height='35.75' ])[4]")).click();
	     	Thread.sleep(4000);
	     	driver.findElement(By.xpath("//span[text()='Select...']")).click();
	    	Thread.sleep(1000);
	     	driver.findElement(By.xpath("//li[text()='Health Insurance']")).click();
	     	Thread.sleep(1000);
	     	driver.findElement(By.xpath("//textarea[@placeholder='Write your review...']")).sendKeys("In 2014 a friend of mine recommend that I reached out to Shawn Filkins at EW Smith to meet all my insurance needs reluctantly I did because I had been a loyal customer to AAA for over 20 yrs. Surprisingly the quote was an immediate monthly savings for better coverage. Within days of switching coverage Downriver had received record amount of rain and flooded most of Downriver. We were covered and received check for damage with no hassle for our recently finished basement. Sadly, so many didn’t understand that flood coverage and back up coverage is 2 separate things and lost everyone with no coverage. When opening my policy Shawn had gone over that coverage in detail and so thankful he had. Switching immediately to EW Smith initially was for cost savings however the best part of switching ended up being the outstanding coverage and the above and beyond customer services/support that I had received from Shawn Filkins. I always recommend Shawn to anyone looking to revisit their coverage especially if they want more than an insurance company its an insurance company that looks out for you and your needs  and for that I am so appreciative .My agent, Kathy Mosher, is the BEST! She's professional and a pleasure to deal with.  ");
	     	Thread.sleep(1000);
	     	Thread.sleep(4000);
	     	
	     	driver.findElement(By.xpath("//div[text()='Submit']")).click();
	
	    	Thread.sleep(18000);
	    	if(driver.findElements(By.xpath("//div[text()='We encountered an error. Please retry']")).size()==1)
	    	{
	    		System.out.println("Unable to post review due to application error");
	    	}else {
	    		
	    		System.out.println("Posted review successfully");
	    	}
	}
}
