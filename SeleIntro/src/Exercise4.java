import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise4 {

	public static void main(String[] args) {
		//a[contains(text(), 'Multiple Windows')]
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(), 'Multiple Windows')]")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> id = windows.iterator();
		String parentWindow = id.next();
		String childWindow = id.next();
		//go to next window
		driver.switchTo().window(childWindow);
		System.out.println(driver.findElement(By.xpath("//div//h3")).getText());
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.xpath("//div//h3")).getText());
		driver.quit();

	}

}
