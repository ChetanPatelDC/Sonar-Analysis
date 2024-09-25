//package stepDefinitions;
//
//import CommmonUtils.ExcelUtil;
//import CommmonUtils.TestContext;
//import TestResourceManager.WebDrivermanager;
//import pageObjects.SalesInvoicePage;
//import pageObjects.SalesOrderPage;
//import pageObjects.manualInvoicePage;
//import io.cucumber.java.en.*;
//
//public class StepDef_Scenario10 {
//
//	TestContext testContext;
//
//	WebDrivermanager webdrivermanager;
//	SalesOrderPage salesOrderPg;
//	SalesInvoicePage salesInvoicePg;
//	manualInvoicePage manualinvoicepg;
//	String methodName;
//
//	public StepDef_Scenario10(TestContext tstContext) {
//		testContext = tstContext;
//
//		salesOrderPg = testContext.getPageObjectManager().getSalesOrderPage();
//		salesInvoicePg = testContext.getPageObjectManager().getSalesInvoicePage();
//	}
//	
//	 @And ("Go to Sale Invoice page and click on Invoice no")
//	 public void  And_Go_to_Sale_Invoice_page_and_click_on_Invoice_no() throws InterruptedException {
//		 methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		
//		 try {
//		 salesInvoicePg.goToSaleInvoicePg();
//		// salesInvoicePg.clickOnDraftInvoiceNo();
//		 }
//		 catch(Exception e) {
//				System.out.println("In Catch Block");
//				e.printStackTrace();
//				ExcelUtil.logExceptionInExcel(methodName, e.toString());
//				throw e;
//			}
//	 }
//	 
//	 @And ("User will do On-Hold Invoice under Final Invoice")
//	 public void User_will_do_On_Hold_Invoice_under_Final_Invoice() throws Throwable {
//		 methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		 
//		 try {
//		 salesInvoicePg.goToSaleInvoicePg(); // temp code
//		 salesInvoicePg.clickOnInvoiceNoInFinalInvoicePg(testContext.Hmap.get("PDF_Name"));
//		// salesInvoicePg.clickOnInvoiceNoInFinalInvoicePg("eIN000859-LEADGB");
//
//		 salesInvoicePg.clickOn_OnHoldInvoice();
//		 }
//		 catch(Exception e) {
//				System.out.println("In Catch Block");
//				e.printStackTrace();
//				ExcelUtil.logExceptionInExcel(methodName, e.toString());
//				throw e;
//			}
//	 }
//
//	 @And("User will Release Invoice under On-Hold Invoice")
//		public void User_will_release_invoice_under_on_hold_invoice() throws InterruptedException {
//		 methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//		 
//		 try {
//		 salesInvoicePg.gotToOnHoldInvoiceTab_And_Release(testContext.Hmap.get("PDF_Name"), 2);
//	//	 salesInvoicePg.gotToOnHoldInvoiceTab_And_Release("eIN000859-LEADGB", 2);
//		 }
//		 catch(Exception e) {
//				System.out.println("In Catch Block");
//				e.printStackTrace();
//				ExcelUtil.logExceptionInExcel(methodName, e.toString());
//				throw e;
//			}
//		}
//	 
//		@And("User will do Post invoice under Final Invoice")
//		public void User_will_do_post_invoice_under_final_invoice() throws InterruptedException {
//			methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//			
//			try {
//			salesInvoicePg.postFinalInvoice(testContext.Hmap.get("PDF_Name"), 2);
//	//		salesInvoicePg.postFinalInvoice("eIN000859-LEADGB", 2);
//			}
//			catch(Exception e) {
//				System.out.println("In Catch Block");
//				e.printStackTrace();
//				ExcelUtil.logExceptionInExcel(methodName, e.toString());
//				throw e;
//			}
//		}
//
//		@Then("User Verify the details under the Post invoice Tab")
//		public void User_verify_the_details_under_the_post_invoice_tab() throws InterruptedException {
//			methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//			
//			try {
//			salesInvoicePg.gotToPostInvoiceTab_And_Validate_data(testContext.Hmap.get("PDF_Name"), 2);
//	//		salesInvoicePg.gotToPostInvoiceTab_And_Validate_data("eIN000859-LEADGB", 2);
//			}
//			catch(Exception e) {
//				System.out.println("In Catch Block");
//				e.printStackTrace();
//				ExcelUtil.logExceptionInExcel(methodName, e.toString());
//				throw e;
//			}
//		}
//	
//}
