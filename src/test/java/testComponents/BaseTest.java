package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageClasses.LogInPage;

public class BaseTest {
	
	public  WebDriver driver;
	public Properties prop;
	public LogInPage lp;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\testComponents\\GlobalProperty.properties" );
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void lunchApplication() throws IOException {
		
		driver = initializeDriver();
		String URL = prop.getProperty("URL");
		lp = new LogInPage(driver);
		lp.goTo(URL);
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearOff() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		DataReadFromJson dr = new DataReadFromJson();
		List<HashMap<String, String>> data = dr.getDataFromJson();
		return new Object[][] {{data.get(0)}};
		
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"\\screenshots\\"+testCaseName+".png");
		FileUtils.copyFile(scr, des);
		return System.getProperty("user.dir")+"\\screenshots\\"+testCaseName+".png";
		
	}

}
