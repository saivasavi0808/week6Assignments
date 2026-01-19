package week6day1parameter;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Sales extends Salespmeter {
	@Test
	public  void Srun() throws InterruptedException {


        //click on menu
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
        //click on view all
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        //scroll down to legal entity and locate it
		WebElement scrollDown = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		Actions act2 = new Actions(driver);
		Thread.sleep(3000);
		act2.scrollToElement(scrollDown).perform();
        //click on legal entity
		driver.findElement(By.xpath("//p[text()='Legal Entities']")).click();
		Thread.sleep(7000);
        //click on dropdown of legal entity
		driver.findElement(By.xpath("(//span[@part='boundary'])[21]")).click();
		Thread.sleep(4000);

		// click on New Legal Entity 
		WebElement a = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", a);

		// Form filling
		//enter company name
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		//enter description
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");
        //scroll down and locate status
		WebElement scrollDown1 = driver.findElement(By.xpath("(//button[text()='Save'])[2]"));
		Actions act3 = new Actions(driver);
		Thread.sleep(3000);
		act3.scrollToElement(scrollDown1).perform();

		//select active
		WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status']/following::button[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusDropdown);

		WebElement active = driver.findElement(By.xpath("//span[text()='Active']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", active);

		// click on Save
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
        //Verify the Alert message
		WebElement s = driver.findElement(By.xpath("//div[@class='fieldLevelErrors']"));
		System.out.println(s.getText());

	
	}
}
