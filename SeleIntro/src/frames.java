import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frames {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		WebElement disCoupon = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		disCoupon.findElements(By.tagName("a")).size();
		
		for(int i = 0; i < disCoupon.findElements(By.tagName("a")).size(); i++) {
			
			String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			disCoupon.findElements(By.tagName("a")).get(i).sendKeys(clickLink);
			
		}

	}

}
