package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	public ChromeOptions options;
	public ChromeDriver driver;
	//launch browser 
	@Given("Launch the browser")
	public void launch_the_browser() {
		options = new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Selenium\\ChromeProfile");
		driver = new ChromeDriver(options);
		
	}
	//load url and maximize window

	@Given("load the url")
	public void load_the_url() {
		driver.get("https://login.salesforce.com\r\n");
		driver.manage().window().maximize();
	}

	//enter username
	@When("Enter Username")
	public void enter_username() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mopurisaivasavi870@agentforce.com");
	}
    //enter password
	@When("Enter password")
	public void enter_password() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Saivasavi@08");
	}
    //click on login
	@When("click on login")
	public void click_on_login() {
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	//Click on toggle menu
	@When("Click on toggle menu")
	public void click_on_toggle_menu() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}
	//Click on view All
	@When("Click view All")
	public void click_view_all() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	//click on Sales from App Launcher
	@When("click Sales from App Launcher")
	public void click_sales_from_app_launcher() throws InterruptedException {
		Thread.sleep(3000);
		//scrolldown to data cloud and locate sales
		WebElement scrollDown = driver.findElement(By.xpath("//p[text()='Data Cloud']"));
		Actions act2 = new Actions(driver);
		
		act2.scrollToElement(scrollDown).perform();
	    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	    Thread.sleep(4000);
	}
	//Click on Accounts tab

	@When("Click on Accounts tab")
	public void click_on_accounts_tab() {
		driver.findElement(By.xpath("(//div[@class='slds-context-bar__label-action slds-p-left_none'])[5]")).click();
	}
	//Click on New button
	@When("Click on New button")
	public void click_on_new_button() {
		WebElement a = driver.findElement(By.xpath("//span[text()='New Account']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", a);
	}
	//Enter account name
	@When("Enter {string} as account name")
	public void enter_as_account_name(String name) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
	    
	}
    //select ownership as public
	@When("Select Ownership")
	public void select_ownership() throws InterruptedException {
		//scrolldown and locate ownership
		WebElement scrollDown1 = driver.findElement(By.xpath("(//input[@class='slds-input'])[12]"));
		Actions act3 = new Actions(driver);
		Thread.sleep(3000);
		act3.scrollToElement(scrollDown1).perform();
	    driver.findElement(By.xpath("(//button[@type='button'])[21]")).click();
	    //click on public
	    driver.findElement(By.xpath("//span[text()='Public']")).click();
	}
	//click on save
	@When("Click save")
	public void click_save() {
	    driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	}
	//verify name by getText
	@Then("verify Account name")
	public void verify_account_name() throws InterruptedException {
		Thread.sleep(4000);
		String bb=driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		System.out.println(bb);
	}




}

