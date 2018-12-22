package Seleniumassignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Assignment1 {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.bluestone.com/");
		//rfwr;
		WebElement eleAJ = driver.findElement(By.xpath("//a[.='All Jewellery ']"));
		Actions action = new Actions(driver);
		action.moveToElement(eleAJ).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Kadas']")).click();
		Thread.sleep(3000);
		driver.findElements(By.xpath("//div[@id='grid-view-result']//a/img")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.id("buy-now")).submit();
		String exErrmsg="* This field is required";
		String errmsg = driver.findElement(By.xpath("//div[@class='formErrorContent']")).getText();
		Assert.assertEquals(errmsg, exErrmsg);
		System.out.println("Sucessful");
		driver.close();
		

	}
}
