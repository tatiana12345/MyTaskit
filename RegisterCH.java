import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RegisterCH {

	public static final String Pass = "password";
	public static final String Email1 ="no_boat_00021@selenium.com";
	public static final String Email2 ="b_owner_00019@selenium.com";
	public static final String Email3 ="free_bu_00020@selenium.com";
	public static final String Email4 ="free_bus_00011@selenium.com";
	public static final String Name1 = "Jane";
	public static final String Last1 = "Air";
	public static final String DisplayName1 = "NoBoatDisplay";
	public static final String DisplayName2 = "BoatOwnerDisplay";
	public static final String DisplayName3 = "FreeBusiness1";
	public static final String DisplayName4 = "FreeBusDiffUpgrade";
	public static String baseURL = "http://qa.app.mytaskit.com";
	
	public static void main(String[] args) throws InterruptedException {
	  // Optional, if not specified, WebDriver will search your path for Chrome driver
	  
		
		System.setProperty("webdriver.chrome.driver", "/Users/tatianakesler/Desktop/Selenium/chromedriver");  
		WebDriver wd = new ChromeDriver();
		wd.get(baseURL);
	    wd.manage().window().maximize();
	    
	  //@CONSUMER_NO_BOAT_REG
	    
		   //Click SignUp as a consumer
		    wd.findElement(By.id("btnRegister")).click();
		    wd.findElement(By.id("personalTab")).click();
		    
		    //Type 1st, last , display name 
		    wd.findElement(By.id("FirstNameOwner")).sendKeys(new String [] {Name1});
		    wd.findElement(By.id("LastNameOwner")).sendKeys(new String[] {Last1});
		    wd.findElement(By.id("DisplayNameOwner")).sendKeys(new String [] {DisplayName1});
		    
		    //Type in email and confirm email
		    wd.findElement(By.id("EmailOwner")).sendKeys(new String[] {Email1});
		    wd.findElement(By.id("EmailConfirmOwner")).sendKeys(new String[] {Email1});
		    
		    //Type in Password and confirm password
		    wd.findElement(By.id("PasswordOwner")).sendKeys(new String [] {Pass});
		    wd.findElement(By.id("PasswordConfirmOwner")).sendKeys(new String [] {Pass});
		    
		    
		    //Type a zip code
		    wd.findElement(By.id("ZipCodeOwner")).sendKeys(new String [] {"33480"});
		    
		    //Uncheck im a boat Owner
		    wd.findElement(By.id("IsBoatOwner")).click();
		     
		    //Check terms of use
		    wd.findElement(By.id("termsOfUse")).click();
		    
		    //Click SignUp
		    wd.findElement(By.id("btnSaveData")).click();
		    
		Thread.sleep(7000);
		
		//Verify My Stuff tab
	    
		
		//Verify client's name
		     if(wd.getPageSource().contains(DisplayName1))
		     {
		    	 System.out.println("- Client (No boat) Registered - PASS ");
		    	 System.out.println("- Client name verified - " + DisplayName1 + " - PASS ");
		     }
		     else{
		    	 System.out.println("- Client name verified - " + DisplayName1 + " - FAIL ");
		     }
		     

		//Verify My Stuff tab
		     if(wd.getPageSource().contains("My Stuff"))
		     {
		    	 System.out.println("- My Stuff tab verified (no boat) - PASS ");
		     }
		     else{
		    	 System.out.println("- My Stuff tab not found (no boat) - FAIL ");
		     }
		
		//Close pop-up and logout and Logout
		if(wd.getPageSource().contains("glyphicon glyphicon-remove-circle"))
	    {
	    	wd.findElement(By.xpath("//i[@class= 'glyphicon glyphicon-remove-circle']")).click();
	    	
	    	//Logout();
	  		Actions action1 = new Actions(wd);
	  		WebElement elems01 = wd.findElement(By.id("navTopRightMenuDisplayName"));
	  		Thread.sleep(3000);
	  		WebElement elems001 = wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]"));   
	  		action1.moveToElement(elems01).click().perform();
	  		Thread.sleep(2000);
	  		action1.moveToElement(elems001).click().perform();
	  		
	    }
	    else
	    {
	    	//Logout();
	  		Actions action1 = new Actions(wd);
	  		WebElement elems01 = wd.findElement(By.id("navTopRightMenuDisplayName"));
	  		Thread.sleep(3000);
	  		WebElement elems001 = wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]"));  
	  		action1.moveToElement(elems01).click().perform();
	  		Thread.sleep(2000);
	  		action1.moveToElement(elems001).click().perform();	
	    }
		    

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	  
	  
	  //CONSUMER WITH BOAT REG
	    
		   //wd.get("http://qa.app.mytaskit.com");
		   
		    //Click SignUp as a consumer
		    wd.findElement(By.id("btnRegister")).click();
		    
		    wd.findElement(By.id("personalTab")).click();
		    
		    //Type 1st, last , display name 
		    wd.findElement(By.id("FirstNameOwner")).sendKeys(new String [] {Name1});
		    wd.findElement(By.id("LastNameOwner")).sendKeys(new String[] {Last1});
		    wd.findElement(By.id("DisplayNameOwner")).sendKeys(new String [] {DisplayName2});
		    
		    //Type in email and confirm email
		    wd.findElement(By.id("EmailOwner")).sendKeys(new String[] {Email2});
		    wd.findElement(By.id("EmailConfirmOwner")).sendKeys(new String[] {Email2});
		    
		    
		    //Type in Password and confirm password
		    wd.findElement(By.id("PasswordOwner")).sendKeys(new String [] {Pass});
		    wd.findElement(By.id("PasswordConfirmOwner")).sendKeys(new String [] {Pass});
		    
		    
		    //Type a zip code
		    wd.findElement(By.id("ZipCodeOwner")).sendKeys(new String [] {"33480"});
		    
		    //Type in boat info
		    wd.findElement(By.id("BoatName")).sendKeys(new String []{"Boat_automation"});
		    wd.findElement(By.id("BoatManufacturer")).sendKeys(new String []{"Volvo"});
		    wd.findElement(By.id("BoatLength")).sendKeys(new String[] {"35"});
		        
		    //Check terms of use
		    wd.findElement(By.id("termsOfUse")).click();
		    
		    //Click SignUp
		    wd.findElement(By.id("btnSaveData")).click();
		    
		    Thread.sleep(7000);
		   
		  //Verify client's name
		     if(wd.getPageSource().contains(DisplayName2))
		     {
		    	 System.out.println("- Client boat owner Registered, client name verified - PASS ");
		    	 System.out.println("- Client name verified - " + DisplayName2 + " - PASS ");
		     }
		     else{
		    	 System.out.println("- Client no boat name shows up on the TM page " + DisplayName2 +  " - Fail ");
		     }

				//Verify My Stuff tab
				     if(wd.getPageSource().contains("My Stuff"))
				     {
				    	 System.out.println("- My Stuff tab verified (boat owner) - PASS ");
				     }
				     else{
				    	 System.out.println("- My Stuff tab not found (boat owner) - FAIL ");
				     }
				     
		//Close pop-up and logout and Logout
//		if(wd.getPageSource().contains("glyphicon glyphicon-remove-circle"))
//	    {
//	    	wd.findElement(By.xpath("//i[@class= 'glyphicon glyphicon-remove-circle']")).click();
//	    	
//	    	//Logout();
//	  		Actions action2 = new Actions(wd);
//	  		WebElement elems02 = wd.findElement(By.id("navTopRightMenuDisplayName"));
//	  		Thread.sleep(3000);
//	  		WebElement elems002 = wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]"));   
//	  		action2.moveToElement(elems02).click().perform();
//	  		Thread.sleep(2000);
//	  		action2.moveToElement(elems002).click().perform();
//	  		
//	    }
//	    else
//	    {
	    	//Logout();
	  		Actions action2 = new Actions(wd);
	  		WebElement elems02 = wd.findElement(By.id("navTopRightMenuDisplayName"));
	  		Thread.sleep(3000);
	  		WebElement elems002 = wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]"));  
	  		action2.moveToElement(elems02).click().perform();
	  		Thread.sleep(2000);
	  		action2.moveToElement(elems002).click().perform();	
	   // }
	 
	 
	  
	//FREE BUSINESS REGISTRATION 
	      
		    //Launch URL
		     
			
		   //Click SignUp as a business
		    wd.findElement(By.id("btnRegister")).click();
		    wd.findElement(By.id("businessTab")).click();
		    
		    //Type 1st, last , display name 
		    wd.findElement(By.id("BusinessNameBiz")).sendKeys(new String [] {DisplayName3});
		    wd.findElement(By.id("DisplayNameBiz")).sendKeys(new String [] {DisplayName3});
		    
		    //Type a ZIP code
		    wd.findElement(By.id("ZipCodeBiz")).sendKeys(new String [] {"33480"});
		    
		    //Check Business type check-boxes
		    wd.findElement(By.id("TypeIsBoatBuilder")).click();
		    wd.findElement(By.id("TypeIsServiceYard")).click();
		    wd.findElement(By.id("TypeIsYachtManagementCompany")).click();
		    wd.findElement(By.id("TypeIsYachtManagementCompany")).click();
		    wd.findElement(By.id("TypeIsEquipmentSupplier")).click();
		    
		    //Type in Administrator's 1st Name, last name
		    wd.findElement(By.id("FirstNameBiz")).sendKeys(new String [] {Name1});
		    wd.findElement(By.id("LastNameBiz")).sendKeys(new String [] {Last1});
		     
		    //Type in email and confirm email
		    wd.findElement(By.id("EmailBiz")).sendKeys(new String[] {Email3});
		    wd.findElement(By.id("EmailConfirmBiz")).sendKeys(new String[] {Email3});
		    
		    //Type in Password and confirm password
		    wd.findElement(By.id("PasswordBiz")).sendKeys(new String [] {Pass});
		    wd.findElement(By.id("PasswordConfirmBiz")).sendKeys(new String [] {Pass});
		        
		    //Check terms of use
		    wd.findElement(By.id("termsOfUse")).click();
		    
		    //Click SignUp
		    wd.findElement(By.id("btnSaveData")).click();
		    
		Thread.sleep(3000);
	        
	     //Verify that is is a free business account 
	     if(wd.getPageSource().contains("Get Professional"))
	     {
	    	 System.out.println("- Free Business Registration - PASS ");
	    	 System.out.println("- Get Professional button verified - PASS ");
	    	 
	     }
	     else{
	    	 System.out.println("- Free Business was NOT registered  " + DisplayName3 +  " - Fail ");
	    	 System.out.println("- Get Professional button NOT verified - PASS ");
	     }
	     
	   //Verify user name
	     if(wd.getPageSource().contains(DisplayName3))
	     {
	    	 System.out.println("- Free Business name verified - " + DisplayName3 + " - PASS ");
	     }
	     else{
	    	 System.out.println("- User name not verified " + DisplayName3 +  " - Fail ");
	     }
	
	//Close pop-up and logout and Logout
//	if(wd.getPageSource().contains("glyphicon glyphicon-remove-circle"))

	     
	     
   	//Logout();
 		Actions action1 = new Actions(wd);
 		WebElement elems01 = wd.findElement(By.id("navTopRightMenuDisplayName"));
 		Thread.sleep(3000);
 		WebElement elems001 = wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]"));  
 		action1.moveToElement(elems01).click().perform();
 		Thread.sleep(2000);
 		action1.moveToElement(elems001).click().perform();	
  // }
 		
  
		    
	// FREE BUSINSS UPGRADE TO PRO option 1 -Annual 
		    
		  //Launch URL
		  	 //  wd.get("http://qa.app.mytaskit.com");
		  	   //Thread.sleep(3000);
		  
		  //Login as free business
		  		wd.findElement(By.id("login_email")).sendKeys(new String [] {Email3});
		  		wd.findElement(By.id("login_password")).sendKeys(new String [] {Pass});
		  		wd.findElement(By.xpath("//*[contains(text(), 'Login')]")).click();
		  				
		 	Thread.sleep(3000);
		
		 //Close pop-up and logout and Logout
		
			  //Click Upgrade to Pro
		  		wd.findElement(By.id("getProfessionalBtn")).click();    //-----------------------------UPGRADE TO PRO
		  		    
		  		//Type in PROMO CODE and click Apply
		  		wd.findElement(By.id("promo-code")).sendKeys(new String[] {"mvf&f"});
		  		wd.findElement(By.id("btnVerify")).click();
		  		
		  		Thread.sleep(3000);
		  		
		  	//Select licenses
		  		wd.findElement(By.id("licenses")).sendKeys(new String[] {"25"});
		  	
		  	//Select Billing Cycle and Payment Details - Annual	
		  		wd.findElement(By.id("billing-cycle-2")).click();
		  		
		   //Type in address / Phone 	
		  		wd.findElement(By.id("addManualAddress_addressLookup")).click();
		  		//Street address
		  		wd.findElement(By.id("address")).sendKeys(new String[] {"1115 45th Street"});
		  		//City
		  		wd.findElement(By.id("city")).sendKeys(new String [] {"West Palm Beach"});
		  		//Country
		  		wd.findElement(By.id("CountrySelect")).sendKeys(new String[] {"United States"});
		  		//ZIP CODE
		  		wd.findElement(By.id("zip-code")).sendKeys(new String[] {"33407"});
		  		//State
		  		wd.findElement(By.id("StateSelect")).sendKeys(new String[] {"FL"});
		  		//Phone
		  		wd.findElement(By.id("phone")).sendKeys(new String[] {"1234567890"});
		  		
		  		// Click submit payment
		  		wd.findElement(By.id("btnEnroll")).click();
		  	
		  	
		  		
		  		
		  	//Close Grid Modal
		 	//wd.findElement(By.xpath("/html/body/div[10]/div/div/div[3]/div/button[1]")).click();
		  	
		  		
		    Thread.sleep(2000);
		
		    //Verify that Boat has been added
				
				if(wd.getPageSource().contains("Get Professional"))
				{
					System.out.println("- Free business Upgrade to PRO (Annual) - FAIL");
				}
				else
				{
				System.out.println("- Free business Upgrade to PRO (Annual) - PASS");
				}
		 
		    Actions action3 = new Actions(wd);
		    WebElement elems03 = wd.findElement(By.id("navTopRightMenuDisplayName"));
		    WebElement elems003 = wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]"));
		    action3.moveToElement(elems03).click().perform();
		    Thread.sleep(2000);
		    action3.moveToElement(elems003).click().perform();
		    
		    Thread.sleep(4000);
		    
		 
		    
	/////////////////SELECT DIFFERENT PRICE OPTIONS/////////////////////////////////////////////////////////////////////////////////////////////////////////
		    //SELECT DIFFERENT PRICE OPTIONS
		  //Launch URL
			
		   //Click SignUp as a business
		    wd.findElement(By.id("btnRegister")).click();
		    wd.findElement(By.id("businessTab")).click();
		    
		    //Type 1st, last , display name 
		    wd.findElement(By.id("BusinessNameBiz")).sendKeys(new String [] {DisplayName4});
		    wd.findElement(By.id("DisplayNameBiz")).sendKeys(new String [] {DisplayName4});
		    
		    //Type a ZIP code
		    wd.findElement(By.id("ZipCodeBiz")).sendKeys(new String [] {"33480"});
		    
		    //Check Business type check-boxes
		    wd.findElement(By.id("TypeIsBoatBuilder")).click();
		    wd.findElement(By.id("TypeIsServiceYard")).click();
		    wd.findElement(By.id("TypeIsYachtManagementCompany")).click();
		    wd.findElement(By.id("TypeIsYachtManagementCompany")).click();
		    wd.findElement(By.id("TypeIsEquipmentSupplier")).click();
		    
		    //Type in Administrator's 1st Name, last name
		    wd.findElement(By.id("FirstNameBiz")).sendKeys(new String [] {Name1});
		    wd.findElement(By.id("LastNameBiz")).sendKeys(new String [] {Last1});
		     
		    //Type in email and confirm email
		    wd.findElement(By.id("EmailBiz")).sendKeys(new String[] {Email4});
		    wd.findElement(By.id("EmailConfirmBiz")).sendKeys(new String[] {Email4});
		    
		    //Type in Password and confirm password
		    wd.findElement(By.id("PasswordBiz")).sendKeys(new String [] {Pass});
		    wd.findElement(By.id("PasswordConfirmBiz")).sendKeys(new String [] {Pass});
		        
		    //Check terms of use
		    wd.findElement(By.id("termsOfUse")).click();
		    
		    //Click SignUp
		    wd.findElement(By.id("btnSaveData")).click();
		    
		Thread.sleep(3000);
		 //Close pop-up and logout and Logout
		  //  wd.findElement(By.xpath("//i[@class= 'glyphicon glyphicon-remove-circle']")).click();
		     
	//////////////////UPGRADE/////////////////////////////////////////////////////////////////////////////////////////	
		    Thread.sleep(2000);     
		        //Click Upgrade to Pro
		  		wd.findElement(By.id("getProfessionalBtn")).click();    //-----------------------------UPGRADE TO PRO
		
		  		Thread.sleep(3000);	    
		  		
		  		//Type in PROMO CODE and click Apply
		  		wd.findElement(By.id("promo-code")).sendKeys(new String[] {"mvf&f"});
		  		wd.findElement(By.id("btnVerify")).click();
		  		
		  		Thread.sleep(3000);
		  		
		  	    //Select licenses
		  		wd.findElement(By.id("licenses")).sendKeys(new String[] {"15"});
		  	
		  	    //Select Billing Cycle and Payment Details - Annual	
		  		wd.findElement(By.id("billing-cycle-1")).click();
		  		
		        //Type in address / Phone 	
		  		wd.findElement(By.id("addManualAddress_addressLookup")).click();
		  		//Street address
		  		wd.findElement(By.id("address")).sendKeys(new String[] {"1115 45th Street"});
		  		//City
		  		wd.findElement(By.id("city")).sendKeys(new String [] {"West Palm Beach"});
		  		//Country
		  		wd.findElement(By.id("CountrySelect")).sendKeys(new String[] {"United States"});
		  		//ZIP CODE
		  		wd.findElement(By.id("zip-code")).sendKeys(new String[] {"33407"});
		  		//State
		  		wd.findElement(By.id("StateSelect")).sendKeys(new String[] {"FL"});
		  		//Phone
		  		wd.findElement(By.id("phone")).sendKeys(new String[] {"1234567890"});
		  		
		  		// Click submit payment
		  		wd.findElement(By.id("btnEnroll")).click();
		  	
		  		Thread.sleep(4000);
		  		
		  	  //Verify that Boat has been added
				if(wd.getPageSource().contains("Get Professional"))
				{
					System.out.println("- Free Business upgrade to PRO (Monthly) - FAIL");
				}
				else
				{
				System.out.println("- Free Business upgrade to PRO (Monthly) - PASS");
				}
				
		  		
		    Thread.sleep(2000);
		 
		    Actions action6 = new Actions(wd);
		    WebElement elems06 = wd.findElement(By.id("navTopRightMenuDisplayName"));
		    WebElement elems006 = wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]"));
		    action6.moveToElement(elems06).click().perform();
		    Thread.sleep(2000);
		    action6.moveToElement(elems006).click().perform();
		    
			Thread.sleep(5000);

			
			wd.close();
	}
	

	}
	



