import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise6 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 600)");
		
		int arrows = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size();
		System.out.println(arrows);
		int columns = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr/th")).size();
		System.out.println(columns);
		List<WebElement> text = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[3]/td"));
		
		for(int i = 0; i < text.size(); i++) {
			String content = text.get(i).getText();
			System.out.println(content);
		}
		

	}

}
