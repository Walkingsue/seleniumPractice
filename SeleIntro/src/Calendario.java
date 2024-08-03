import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendario {

	public static void main(String[] args) {
		String month = "8";
		String year = "2035";
		String date = "22";
		String[] expList = {month, date, year};
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__next-button")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
		
		List<WebElement> currentList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i = 0; i < currentList.size(); i++) {
			
			currentList.get(i).getAttribute("value");
			Assert.assertEquals(currentList.get(i).getAttribute("value"), expList[i]);
		}

	}

}
