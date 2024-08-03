import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolldownpractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 600)");
		List<WebElement> values = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/td[3]"));
		
		int sum = 0;
		for(int i = 0; i < values.size(); i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());
			System.out.println(sum);
		}
	}

}
