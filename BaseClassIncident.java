package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassIncident{
	
	public ChromeDriver driver;
	@BeforeMethod
		public void setup() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("----Disable Notifictions");
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://dev86680.service-now.com/navpage.do");
	Thread.sleep(5000);
	driver.switchTo().frame("gsft_main");
	System.out.println("frame has been selected");
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("Pass@1234");
	driver.findElement(By.id("sysverb_login")).click();
	System.out.println("logged into appln sucessfully");

	}	
		@AfterMethod
		public void turnof()
		{
			driver.close();
		}

	}


