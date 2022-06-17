package com.selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	
		WebDriver driver;
	
		@BeforeMethod
		public void beforeTest() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
    
		@Test
		public void launchfacebook() {
			
			driver.get("https://www.facebook.com/");
			WebElement element = driver.findElement(By.id("email"));

			Actions action = new Actions(driver);
			action.moveToElement(element).click()
			//	.keyDown(element, Keys.SHIFT)
				.sendKeys(element, "hello")
			//	.keyUp(element, Keys.SHIFT)
				.doubleClick(element)
				.contextClick()
				.build().perform();
		}
/*			driver.navigate().to("http://twitter.com");
		
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			System.out.println(driver.getPageSource());
			
			driver.navigate().back();
			driver.navigate().forward();
			driver.navigate().refresh();
			
			
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.switchTo().newWindow(WindowType.TAB);
			driver.navigate().to("http://amazon.com");
			
			Set<String> handles=driver.getWindowHandles();
			for(String handle:handles) {
				String title=driver.switchTo().window(handle).getTitle();
				if(title.contains("Twitter")) {
					driver.close();
				}
			}
*/
			@AfterMethod
			public void afterMethod() {
				driver.quit();	
			}
						
}

