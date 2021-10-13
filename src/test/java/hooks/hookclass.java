package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hookclass {
	public static WebDriver driver;
	@Before
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\driverchrome\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/index.php");
	}
	@After
	public void closedriver()
	{
		System.out.println("Browser is closing now");
		driver.quit();
	}
}
