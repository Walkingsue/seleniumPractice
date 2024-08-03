import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortedStream {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column
		//table/thead/tr/th[1]
		driver.findElement(By.xpath("//table/thead/tr/th[1]")).click();
		
		//capture all webelements into a list
		//table/tbody/tr/td[1]
		List<WebElement> List = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		
		//capture the text of all webelments into a new list
		 List<String> newList = List.stream().map(s->s.getText()).collect(Collectors.toList());
		 
		//sort the new list
		List<String> sortList = newList.stream().sorted().collect(Collectors.toList());
		
		//compare the new list with the sorted one
		Assert.assertTrue(newList.equals(sortList));
		
		List<String> vegsPrice = List.stream().filter(s->s.getText().contains("Banana"))
		.map(s->getPrice(s)).collect(Collectors.toList());
		vegsPrice.forEach(s->System.out.println(s));

	}

	public static String getPrice(WebElement s) {
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}
}
