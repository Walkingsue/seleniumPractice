import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise7 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");

		Thread.sleep(2000);

		List<WebElement> options = driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));

		for(WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India"))	{
				option.click();
				break;
			}
		}
	}
}
