import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[class*='ng-pristine']")).click();
		driver.findElement(By.cssSelector("input[class*='ng-pristine']")).sendKeys("Pepito Perez");
		driver.findElement(By.cssSelector("*[class*='ng-untouched']")).click();
		driver.findElement(By.cssSelector("*[class*='ng-untouched']")).sendKeys("pepe@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).click();
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Tuvieja2024");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/select/option[1]")).click();	
		driver.findElement(By.cssSelector("input#inlineRadio2")).click();
		driver.findElement(By.xpath("//input[@type='date']")).click();
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("11092001");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());	
	}
}
