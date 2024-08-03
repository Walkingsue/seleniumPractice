import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class IntroSele {
	public static void main(String[] args) {
		
		//Chrome funciona
		//WebDriver driver = new ChromeDriver();
		
		//Firefox driver no funciona
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\josuevet\\Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//Microsoft Edge driver funciona
		System.setProperty("webdriver.Edge.driver", "\"C:\\Users\\josuevet\\Downloads\\edgedriver_win64\\msedgedriver.exe\"");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.youtube.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		}
}
