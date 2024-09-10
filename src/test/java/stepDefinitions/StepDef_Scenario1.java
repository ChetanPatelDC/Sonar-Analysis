package stepDefinitions;

import CommmonUtils.ExcelUtil;
import TestResourceManager.WebDrivermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import otherResources.TestContext;
import pageObjects.AddCampaignItemPage;
import pageObjects.EditCampaignItemPage;
import pageObjects.EproCampaignPage;
import pageObjects.EproCreateCampaignPage;
import pageObjects.EproHomePage;
import pageObjects.EproLoginPage;
import pageObjects.ManageCampaignPage;
import pageObjects.ManagePricePage;
import pageObjects.QuoteManagementPage;
import pageObjects.SubmitSupplierPricePage;

public class StepDef_Scenario1 {
	
	
	TestContext testContext;
    EproLoginPage eprologin;
    EproHomePage eprohome;
    EproCampaignPage eprocamppage;
    EproCreateCampaignPage eprocreatecamp;	
	AddCampaignItemPage addCampaignItem;
	EditCampaignItemPage editCampPage;
	SubmitSupplierPricePage submitSupplier;
	ManagePricePage managePrice;
    QuoteManagementPage quoteManage;
    ManageCampaignPage manageCampPage;
    WebDrivermanager webdrivermanager;
    
    
	
	
    public StepDef_Scenario1(TestContext tstContext) {
		testContext = tstContext;
		eprologin = testContext.getPageObjectManager().getEproLoginPage();
		eprohome = testContext.getPageObjectManager().getEproHomePage();
		eprocamppage = testContext.getPageObjectManager().getEproCampaignPage();
		eprocreatecamp = testContext.getPageObjectManager().getEproCreateCampaignPage();
		addCampaignItem = testContext.getPageObjectManager().getAddCampaignItemPage();
		editCampPage = testContext.getPageObjectManager().getEditCampaignItemPage();
		submitSupplier = testContext.getPageObjectManager().getSubmitSpplierPricePage();
		managePrice = testContext.getPageObjectManager().getManagePricePage();
		manageCampPage = testContext.getPageObjectManager().getManageCampaignPage();
		quoteManage = testContext.getPageObjectManager().getQuoteManagementPage();

	}

	

	@Given("^User launches Epro url and login with valid (.*) and (.*)$")
	public void User_launches_Epro_url_and_login_with_valid_staginguser_and_password(String Username, String Password) 
	{
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			eprologin.launchurl("https://uat.paragon-epro.com/");
			System.out.println("Browser launched");
			eprologin.EnterUsernameAndPassword(Username, Password);
			System.out.println("User Credentials entered");
			eprologin.Clksubmit();
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
		
	}

	@And("user navigate to Campaign page and create campaign")
	public void user_navigate_to_campaign_page_and_create_campaign() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		eprohome.ClkCampaign();
		eprocamppage.clkAddCampaign();
		eprocreatecamp.fillRequiredDetails();
		eprocreatecamp.submitCreateCampaignDetails();
		eprocreatecamp.ValidateCreateCampaignPopUp();

		String CampaignId = eprocreatecamp.storeCampaignID();
		testContext.Hmap.put("CampaignId", CampaignId);
		System.out.println("Campaign created successfully");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}

	}

	@Then("User add new Item in the Campaign using Create New Item button")
	public void user_add_new_item_in_the_campaign_using_create_new_item_button() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		eprocamppage.clickOnCampaignId(testContext.Hmap.get("CampaignId"));
		System.out.println("Campaign ID =" + testContext.Hmap.get("CampaignId"));
		addCampaignItem.addItemDetails();
		System.out.println("Campaign item added successfully");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@Then("Verify Campaign status as Created")
	public void verify_campaign_status_as_created_add_this_step() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		addCampaignItem.validateCreateCampaignPopup();
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
		
	}

	@And("Click on Submit for Costing button")
	public void click_on_submit_for_costing_button() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		manageCampPage.DetailsForsubmitCosting();
		manageCampPage.validateItemAddedPopup();
		manageCampPage.ClicksubmitCostingButton();
		manageCampPage.validateSubmitCostPopup();
		System.out.println("Costing submitted for campaign item successfully");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("User will add Supplier Cost using Submit supplier button")
	public void user_will_add_supplier_cost_using_submit_supplier_button() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		manageCampPage.clickSupplierPricebutton();
		submitSupplier.addSupplierPriceDetails();
		submitSupplier.validateSubmitSupplierCostPopup();
		System.out.println("Supplier price submitted successfully");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("User will manage the supplier price and add all required details")
	public void user_will_manage_the_supplier_price_and_add_all_required_details() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		manageCampPage.selectSupplierPrice();
		manageCampPage.validateItemSelectedPopup();
		manageCampPage.CreateQuote();
		manageCampPage.validateQuoteGeneratedPopup();
		System.out.println("Quote has been generated successfully");
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}

	}

	@And("User will navigate to Quote Managment tab and generate quote")
	public void user_will_navigate_to_quote_managment_tab_and_generate_quote() throws InterruptedException {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		quoteManage.verifyQuote();
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@And("User will accept the quote on clicking of Quote Accepted button")
	public void user_will_accept_the_quote_on_clicking_of_quote_accepted_button() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		quoteManage.acceptQuote();
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

	@Then("Verify status as Quote Accepted on Campaign Item Page")
	public void verify_status_as_quote_accepted_on_campaign_item_page() {
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
		quoteManage.validateAcceptQuotePopup();
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
			e.printStackTrace();
			ExcelUtil.logExceptionInExcel(methodName, e.toString());
			throw e;
		}
	}

}
