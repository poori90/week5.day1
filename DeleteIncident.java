package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident extends BaseClassIncident{
	@Test (priority=3, enabled= false)

	public  void deleteIncident() throws InterruptedException {
		
		//3. Enter Incident in filter navigator and press enter"
		WebElement filter = driver.findElement(By.id("filter"));
		filter.sendKeys("incident");
		Thread.sleep(4000);
		filter.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(8000);
		driver.switchTo().frame("gsft_main");
		Thread.sleep(8000);
		//4. Search for the existing incident and navigate into the incident
		
		WebElement filter1 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		filter1.sendKeys("INC0010008");
		filter1.sendKeys(Keys.ENTER);
		System.out.println("search incident is:  Pass");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		System.out.println("Incident # has been selected from Incident table list");
		//5. Delete the incident
	
		driver.findElement(By.id("sysverb_delete")).click();
		System.out.println("Delete button selected");
		//		6. Verify the deleted incident

	}

}
