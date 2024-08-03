import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait ExpWait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//label[2]//span[2]")).click();
		
		//ExplicitWait
		ExpWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.cssSelector("#okayBtn")).click();
		
		driver.findElement(By.cssSelector("select.form-control")).click();
		driver.findElement(By.xpath("//option[@value='consult']")).click();
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		//NextPage
		//AddBtn Xpath //button[@class='btn btn-info']
		//Select all elements
		//Wait for a bit
		ExpWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.card-title")));
		List<WebElement> allPhones = driver.findElements(By.cssSelector("h4.card-title"));
		
		//The products I want
		String[] desireProduct = {"iphone X", "Samsung Note 8"};
		List<String> productList = Arrays.asList(desireProduct);
		
		//iterate through the products
		//count of the product
		int j = 0;
		
		for(int i = 0; i < allPhones.size(); i++) {
			
			//get the index of the product
			//get the text of the product
			String name = allPhones.get(i).getText();
			
			//check if it contains the name of the product
			if(productList.contains(name)) {
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
				j++;
				
				if(j == desireProduct.length) {
					break;
				}
			}
		}
		
		//go to checkout Xpath //a[@class='nav-link btn btn-primary']
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		driver.quit();
	}
}
