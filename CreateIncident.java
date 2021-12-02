package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncident extends BaseClassIncident{
		@Test (priority =0, alwaysRun =true)

	public  void createIncident() throws InterruptedException, IOException {
		
		//3. Enter Incident in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		System.out.println("Filtered Incident successfully");
		Thread.sleep(5000);
		//Step4: Click “All”
		
				driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
				driver.switchTo().frame("gsft_main");
				//Step5: Click New button
				
				driver.findElement(By.id("sysverb_new")).click();
				//Step6: Select a value for Caller and Enter value for short_description
				
				driver.findElement(By.id("lookup.incident.caller_id")).click();
				Set<String> Handles = driver.getWindowHandles();
				List<String> HandlesList = new ArrayList<String>();
				HandlesList.addAll(Handles);
				driver.switchTo().window(HandlesList.get(1));
				System.out.println("child window has been selected");
				Thread.sleep(3000);
				driver.findElement(By.className("glide_ref_item_link")).click();
				driver.switchTo().window(HandlesList.get(0));
				System.out.println("parent window has been selected");
				driver.switchTo().frame("gsft_main");
				driver.findElement(By.id("incident.short_description")).sendKeys("Added Description");
				System.out.println("description has been added");
				//Step7: Read the incident number and save it a variable
				
				String incidentnum = driver.findElement(By.id("incident.number")).getAttribute("value");
				//Step8: Click on Submit button
				
				driver.findElement(By.id("sysverb_insert_bottom")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(incidentnum);
				driver.findElement(By.xpath("(//label[text()='Search']/following::input)[1]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				String Incident = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
				
				//Step 9: Search the same incident number in the next search screen as below
				
				if (Incident.equals(incidentnum)) {
					System.out.println("Incident Created Successfully : " + incidentnum);
				} else
					System.out.println("Incident Not Created");


	}

}
