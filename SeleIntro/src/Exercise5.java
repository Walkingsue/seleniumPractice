import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise5 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		 String text = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		 driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();
		 
		 WebElement staticDrpDown = driver.findElement(By.id("dropdown-class-example"));
		 Select drpDown = new Select(staticDrpDown);
		 drpDown.selectByVisibleText(text);
		 driver.findElement(By.name("enter-name")).sendKeys(text);
		 driver.findElement(By.id("alertbtn")).click();
		 
		 Alert confirmation = driver.switchTo().alert();
		 String alertText = confirmation.getText();
		 System.out.println(alertText);
		 confirmation.accept();
		 
		 //falto la confirmacion de la alerta
	}

}
