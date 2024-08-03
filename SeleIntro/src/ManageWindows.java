import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//WebDriverWait ExpWait = new WebDriverWait(driver, Duration.ofSeconds(1));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> id = windows.iterator();
		String parentWindow = id.next();
		String childWindow = id.next();
		driver.switchTo().window(childWindow);
		driver.switchTo().window(parentWindow);
		
		//ExpWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("im-para.red")));
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		}

}
