package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateIncident extends BaseClassIncident {

		@Test  (priority=1)
	public  void updateIncident() throws InterruptedException {
		
		//3. Enter Incident in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		System.out.println("Filtered Incident successfully");
		Thread.sleep(5000);
		
		//4. Search for the existing incident and click on the incident
		
		driver.findElement(By.xpath("(//tr[@class='list_row list_odd'])//td[3]")).click();
		
		//5. Update the incidents with Urgency as High and State as In Progress
		WebElement urg = driver.findElement(By.id("incident.urgency"));
		new Select(urg).selectByIndex(0);
		
		WebElement state = driver.findElement(By.id("incident.state"));
		new Select(state).selectByIndex(1);
		//6. Verify the priority and state 
		
		String InciStateVerify =driver.findElement(By.id("incident.state")).getText();
		
		if (InciStateVerify.contains ("In Progress")) {
			System.out.println("Displayed State is: Correct");
		} else
			System.out.println("Displayed State is: Not Correct");
		
		driver.findElement(By.id("sysverb_update_bottom")).click();
			
		System.out.println("Incident has been updated sucessfully");		
	}

}
