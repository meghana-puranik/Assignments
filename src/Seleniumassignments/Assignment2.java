package Seleniumassignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.bluestone.com/");
		
		
		WebElement eleAJ = driver.findElement(By.xpath("//a[.='All Jewellery ']"));
		Actions action = new Actions(driver);
		action.moveToElement(eleAJ).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Kadas']")).click();
		Thread.sleep(3000);
		driver.findElements(By.xpath("//div[@id='grid-view-result']//a/img")).get(0).click();
		Thread.sleep(2000);
		WebElement size = driver.findElement(By.id("ringselect"));
		Select sel =new Select(size);
		sel.selectByValue("02");
		String sizecap = sel.getFirstSelectedOption().getText().trim();
		String expectedSize ="2-2(2 2/16\")";
		System.out.println("Size is as expected");
		Assert.assertEquals(sizecap, expectedSize);
		driver.findElement(By.id("buy-now")).submit();
		String exErrmsg="* This field is required";
		driver.close();
		

	}

}

