package qa.helper;




import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverFactory {

	static WebDriver driver;
	private static String url= "https://www.saucedemo.com/";
	
	private DriverFactory() {
		
	}
	
	public static WebDriver getDriver() {
		if(driver == null)
			createDriver("Chrome");
			return driver;
		}

	private static void createDriver(String strBrowser) {
		if(strBrowser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(strBrowser.equals("Firefox")){
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().window().setSize(new Dimension(500, 100));
	}
	
	public static <T> T Na(Class<T> classe) {
		return PageFactory.initElements(driver, classe);
	}
	
	public static void KillDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
