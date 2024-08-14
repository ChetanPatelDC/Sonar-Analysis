package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommmonUtils.BaseAction;

public class EproCampaignPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public BaseAction ba;
	public int rowNum;

	private final By element5 = By.xpath("//img[@src='assets/images/assign-suppliers.svg']");
	private final By element = By.xpath("//div[@id='mat-select-value-13']");

	public EproCampaignPage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		 this.wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(20));
		 ba = new BaseAction(driver);
	}

	public void clkAddCampaign() {


		
		 // click on add icon
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='assets/images/assign-suppliers.svg']"))).click();
       // click on business unit box //div[@id='mat-select-value-13']

		
		
}
	
	
	public void clickOnCampaignId(String num) {
		
		// click on the search icon to get the context on the base page

		// String UTnumber = "UT01183";
		//String UTnumber = num;
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).clear();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']")))
				.sendKeys(num);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search..']"))).click();

		WebElement ManageCAmp = driver.findElement(By.xpath("//*[text()='" + num + "']"));
		ba.retryMechanism(driver, ManageCAmp);

		// click on Manage campaign
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='UT01118']"))).click();

	}

	
	public void clickOnSendPO() throws InterruptedException {
		 // click on send po button
	     
	       String campaign_ID = ba.handleWebTable("//*[@role='table']/tbody/tr", "Quote Accepted", 2, "getText");
	       System.out.println("campaign_ID = "+campaign_ID);
	       rowNum = ba.getMatchRowNum("//*[@role='table']/tbody/tr", "Quote Accepted", 2, "getRowNum");
	       System.out.println("rowNum  = "+rowNum);
	      //*[@role='table']/tbody/tr[5]/td[11]/button[not(@hidden)]//img[@src='assets/images/send-for-approval.svg']
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//table[@role=\"table\"]//tbody/tr["+rowNum+"]/td/button[not(@hidden)]//img[@src='assets/images/send-for-approval.svg']"))); 
			

	       ba.retryMechanism(driver, driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),' Yes')]")));
	       
	}
	
	public void clickOnCreatePO () {
		// click on create PO
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//table[@role='table']//tbody/tr["+rowNum+"]/td/button[not(@hidden)]//img[@src='assets/images/generate_doc_create_po.svg']"))); // hard coded value
	       //click on close (popup)
	       ba.retryMechanism(driver, driver.findElement(By.xpath("//*[text()='Close']")));
	       
	}
	
	
	
	
}