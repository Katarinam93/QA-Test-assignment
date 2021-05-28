package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	public  static  WebDriver driver;
	public  Properties props;

	public WebDriver initDriver() throws IOException {
		props = new Properties();

		FileInputStream fajl = new FileInputStream("./src/main/java/setup/file.properties");
		props.load(fajl);
		
		if(props.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//main//java//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(props.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//java//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(props.getProperty("browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//src//main//java//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(props.getProperty("browser").equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"//src//main//java//drivers//msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return driver;
		
	 }
}
