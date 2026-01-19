package week6day1parameter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class SDynamic extends Salespmeter {
	//test annotation with dataprovider
	@Test(dataProvider="legalEntityData")
	public  void Srun(String Ename) throws InterruptedException {
        //click on menu
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
        //click on view all
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        //scroll down and locate legal entities
		WebElement scrollDown = driver.findElement(By.xpath("//p[text()='Lightning Usage']"));
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

		//enter name
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(Ename);
		//click on save
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	//quit the browser
		 driver.quit();
    }

    @DataProvider(name = "legalEntityData")
  
	public String[][] sendData() {
		//declare array
		String [][] data=new String[2][1];
		//assign the data
		data[0][0]="Salesforce Automation by vasavi";
		data[1][0]="Salesforce Automation by sai";
		
		return data;
        
    }
}