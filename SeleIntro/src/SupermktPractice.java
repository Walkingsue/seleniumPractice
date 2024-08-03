
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupermktPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> productName = driver.findElements(By.cssSelector("h4[class='product-name']"));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait ExpWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//Seleccionar los productos de la pagina
		String[] vegies = {"Tomato","Carrot","Mango"};
		List<String> productNeeded = Arrays.asList(vegies);
		
		int j = 0;
		
		for(int i = 0; i < productName.size(); i++) {
			
			String[] name = productName.get(i).getText().split("-");
			String formatName = name[0].trim();
			
			
			if(productNeeded.contains(formatName)) {
				j++;
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j == vegies.length) {
					break;
				}
			}
		}
		
		//Ir al carro de compras
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		ExpWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']")));
		
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		ExpWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		driver.findElement(By.cssSelector("span.promoInfo")).getText();
		
	}

}
