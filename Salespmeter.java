package week6day1parameter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Salespmeter {
	public ChromeDriver driver;
	@Parameters({"url","username","Password"})
	@BeforeMethod
	public void Sprun(String url,String uName,String password) throws InterruptedException {
	//launch browser
	ChromeOptions options = new ChromeOptions();
	options.addArguments("user-data-dir=C:\\Selenium\\ChromeProfile");
	driver = new ChromeDriver(options);
    //launch url
	driver.get(url);
	//maximize window
	driver.manage().window().maximize();
	//enter username
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uName);
	//enter password
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	//click on login
	driver.findElement(By.xpath("//input[@id='Login']")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	


}
