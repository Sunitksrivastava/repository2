package com.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesTest {
	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.switchTo().frame("SingleFrame");
		WebElement element=driver.findElement(By.xpath("//div[@class=\"col-xs-6 col-xs-offset-5\"]//input[@type=\"text\"]"));
		element.sendKeys("Sunit");
		driver.switchTo().parentFrame(); //switch to parent frame
// or	driver.switchTo().defaultContent(); // switch to top level window
	    driver.findElement(By.xpath("//a[@href=\"#Multiple\"]")).click();
		
	
		
	}

}
