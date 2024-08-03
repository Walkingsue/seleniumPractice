import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DrpdownUdemy {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("chi");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		
		for(WebElement option:options) {
			if(option.getText().equals("Chile")) {
				option.click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector("input[id*='IndArm']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='IndArm']")).isSelected());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		
		for(int i = 1; i < 6; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.cssSelector("input[class='buttonN']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
	}
}
