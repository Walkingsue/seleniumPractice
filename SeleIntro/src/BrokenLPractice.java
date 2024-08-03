import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLPractice {

	public static void main(String[] args) throws IOException, URISyntaxException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();

		for (WebElement link : links) {

			String urlString = link.getAttribute("href");
			URL url = new URI(urlString).toURL();
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);

			a.assertTrue(respCode < 400, "The link with Text" + " " + link.getText() + " is broken with code" + " " + respCode);

		}
		a.assertAll();
	}
}
