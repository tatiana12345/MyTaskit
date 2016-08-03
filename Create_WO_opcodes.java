import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class Create_WO_opcodes {

	static WebDriver wd = new FirefoxDriver();
	
    public static final String Pass = "password";
	public static final String EmailPRO ="MTSupervisor01_02@yahoo.com";
	public static final String EmailTECH ="MTTech01_02@yahoo.com";
	public static final String EmailCl ="MTClient03@yahoo.com";
	public static final String WOTitle = "UNIQUE WO TITLE";
	public static final String Client = "MTClient03";
	public static final String TechName = "MTTech01_02";
	
public static void main(String[] args) throws InterruptedException {
	
		
        wd.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);


		
		wd.get("http://qa.app.mytaskit.com");
		wd.manage().window().maximize();
		
		// Login as Supervisor
		
				wd.findElement(By.id("login_email")).sendKeys(new String [] {EmailPRO});
				wd.findElement(By.id("login_password")).sendKeys(new String [] {Pass});
				wd.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
				
				//Close pop-up 
			    //wd.findElement(By.xpath("//i[@class= 'glyphicon glyphicon-remove-circle']")).click();
			    
			    Actions action0 = new Actions(wd);
		        WebElement elems00 = wd.findElement(By.xpath("//i[@class= 'glyphicon glyphicon-remove-circle']"));
		        WebElement elems000 = wd.findElement(By.xpath("(//input[@type='text'])[10]"));
		        action0.moveToElement(elems00).click().perform();
		      Thread.sleep(4000);
		        action0.moveToElement(elems000).click().perform();
		      
		      
			    
			    Thread.sleep(2000);
			    
			    //type WO Title
			    wd.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys(WOTitle);
			    
			    //Click OBO button
			    wd.findElement(By.xpath("(//button[@type='button'])[210]")).click();
			    
			    //Type client's name
			    wd.findElement(By.partialLinkText("Enter client name or email")).click();
			    wd.findElement(By.xpath("//*[@id='container-wrapper']/div[2]/div/div[2]/div[1]/div/tk-create-task/div/div/div[1]/div/div/form/div/input")).sendKeys(Client);
			    
			    //Select Client
			    wd.findElement(By.linkText("MTClient03 | MTClient03@yahoo.com")).click();
			    
			    Thread.sleep(2000);
			    
			    //Click select client button
			    wd.findElement(By.xpath("//span[@class='glyphicon glyphicon-ok']")).click();
			    
			    //Click create WO/WOE
			    wd.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
			    
			    
			    //Click WO Radio Button - do not search by name / input name, it changes often
			    wd.findElement(By.xpath("//div[3]/div/label/input")).click();
			    
		      //Click OPCodes DD
		        Actions action1 = new Actions(wd);
		        WebElement elems01 = wd.findElement(By.xpath("(//button[@type='button'])[212]"));
		        WebElement elems001 = wd.findElement(By.xpath("//span[contains(text(),'1002 - PAINT BOTTOM & RUNNING GEAR')]"));
		        action1.moveToElement(elems01).click().perform();
		        action1.moveToElement(elems001).click().perform();
		
                
		        //Click Select boat DD
		        wd.findElement(By.xpath("(//option[@label='DRY BOAT'])")).click();
		        //wd.findElement(By.xpath("(//option[@value='10'])[4]")).click();
                
                //Click select equipment
                wd.findElement(By.id("ddmEquipment")).click();
                
                //Click link My Engy
                wd.findElement(By.linkText("MY engine")).click();
                
                //Select Start Date
                wd.findElement(By.xpath("(//button[@type='button'])[262]")).click();
                wd.findElement(By.xpath("(//button[@type='button'])[222]")).click();
                
                //Select Completion Date
                wd.findElement(By.xpath("(//button[@type='button'])[311]")).click();
                wd.findElement(By.xpath("(//button[@type='button'])[278]")).click();
                
                //Select Customer Promise Date
                wd.findElement(By.xpath("(//button[@type='button'])[360]")).click();
                wd.findElement(By.xpath("(//button[@type='button'])[334]")).click();
                
                //Select Location Code
                wd.findElement(By.xpath("//*[@title='Select a location code']")).click();
                wd.findElement(By.xpath("//a/span[contains (text(),'MyTaskit Pro - 401 South Dixie Hwy.')]")).click();
                
                //Click "Create WO" button 
                wd.findElement(By.xpath("//*[contains(text(),'Create Work Order')]")).click();
                
                //Verify notification message If element's present  
                if(!wd.findElements(By.cssSelector("div.toast.toast-success")).isEmpty()){ 
                    //Outprint Error Message
                	System.out.println("- Tech assigned, Notification message provided - PASS ");
                       }
                else{
                    //Outprint Success message
                     System.out.println("- No notification message provided - FAIL ");
                }
                
                //Print out popup text
                String WO_Created = wd.findElement(By.cssSelector("div.toast.toast-success")).getText();
                System.out.println("- Notification Popup text: " + WO_Created + " - PASS ");
                
                //Verify that WOTitle shows up in TM
                if(wd.getPageSource().contains(WOTitle))
				{
					System.out.println("- " + WOTitle + " found in TM - PASS ");
				}
				else
				{
				System.out.println("- " + WOTitle + " was not found in TM - FAIL ");
				}
                
              Thread.sleep(6000);
                //Copy 1st in In-box WO Title that contains WOTitle
              //String WO_title = wd.findElement(By.xpath("(//*[@title='Click to edit title'][contains(text(),"+WOTitle+")])[1]")).getText();
              String WO_title = wd.findElement(By.xpath("(//*[@title='Click to edit title'][contains(text(),'UNIQUE WO TITLE')])[1]")).getText();
              
              
                //Convert WO_title to a numeric string
                WO_title = WO_title.replaceAll("[^\\d.]", "");
                
              //Print out WO number
                System.out.println("- Created WO Nmebr: " + WO_title);
                
                //Type in WO in search field
                wd.findElement(By.id("searchTasks")).sendKeys(WO_title);

                //Click Search Button 
                wd.findElement(By.xpath("(//*[@class='glyphicon glyphicon-search'])[2]")).click();
                
                //Verify that WO number 
                if(wd.getPageSource().contains(WO_title))
				{
					System.out.println("- WO found throught search - PASS ");
				}
				else
				{
				System.out.println("- WO not found throught search - FAIL ");
				}
                
                //Verify Client Name
                if(wd.getPageSource().contains(Client))                ///////////////////
				{
					System.out.println("- Clent name verified in header - PASS ");
				}
				else
				{
				System.out.println("- Client name is not verified in header - FAIL ");
				}
                
                
                //Verify BOAT Name 
                if(wd.getPageSource().contains("DRY BOAT"))
				{
					System.out.println("- Boat name verified in header - PASS ");
				}
				else
				{
				System.out.println("- Boat is not verified in header - FAIL ");
				}
                
                //Expend WO details
                wd.findElement(By.xpath("(//div[@class='title-container list-title'])[1]")).click();                
                //wd.findElement(By.xpath("//*[@class='material-icons toggle-btn'][1]")).click();
                
                //Click expend task details
                wd.findElement(By.xpath("//*[@class='glyphicon pull-right glyphicon-chevron-down']")).click();
                
                //Click assign Tech tab
                wd.findElement(By.xpath("//a/span[@class='ng-scope' and text() = 'Service Technicians']")).click();
                
                //Click assign service Tech link
                wd.findElement(By.linkText("Select Service Tech")).click();
                
                //Type Tech's credentials
                wd.findElement(By.xpath("(//input[@type='text'])[21]")).sendKeys(TechName);
                
                //Select tech name in suggested 
                wd.findElement(By.partialLinkText(TechName)).click();
                
                //Click "ok" checkbox
                wd.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
                
                //Click assign Tech button
                wd.findElement(By.xpath("//div[3]/div[2]/div/div/button")).click();
                
              //Verify notification message If element's present  
                if(!wd.findElements(By.cssSelector("div.toast.toast-success")).isEmpty()){ 
                    //Outprint Error Message
                	System.out.println("- Notification message provided - PASS ");
                       }
                else{
                    //Outprint Success message
                     System.out.println("- No notification message provided - FAIL ");
                }
                
                
                //Verify Tech name
                if(wd.getPageSource().contains(TechName))
				{
					System.out.println("- Tech name verified in task details - PASS ");
				}
				else
				{
				System.out.println("- Tech name is not verified in task details - FAIL ");
				}
                
                Thread.sleep(6000);
                
                //Logout
                Actions action6 = new Actions(wd);
    		    WebElement elems06 = wd.findElement(By.id("navTopRightMenuDisplayName"));
    		    WebElement elems006 = wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]"));
    		    action6.moveToElement(elems06).click().perform();
    		    Thread.sleep(2000);
    		    action6.moveToElement(elems006).click().perform();
    		    
    		    Thread.sleep(3000);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    		    
    			
    		    //Launch as Tech
    		    
    		    wd.findElement(By.id("login_email")).sendKeys(new String [] {EmailTECH});
    			wd.findElement(By.id("login_password")).sendKeys(new String [] {Pass});
    			wd.findElement(By.xpath("//*[contains(text(),'Login')]")).click();

    		    Thread.sleep(2000);
 
    			//Type in WO # in search field 
                wd.findElement(By.id("searchTasks")).sendKeys(WO_title);

                //Click Search Button 
                wd.findElement(By.xpath("(//*[@class='glyphicon glyphicon-search'])")).click();

                
                Thread.sleep(9000);	
                
                //Verify WO number in TM
                if(wd.getPageSource().contains(WO_title))
				{
					System.out.println("- TECH: WO " + WO_title + " found through search - PASS ");
				}
				else
				{
				System.out.println("- TECH: WO " + WO_title + " not found through search - FAIL ");
				}
                
                
                //Logout
                Actions action2 = new Actions(wd);
    		    WebElement elems02 = wd.findElement(By.id("navTopRightMenuDisplayName"));
    		    WebElement elems002 = wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]"));
    		    action2.moveToElement(elems02).click().perform();
    		    Thread.sleep(2000);
    		    action2.moveToElement(elems002).click().perform(); 
               
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////             
                
                //Login client
    		    wd.findElement(By.id("login_email")).sendKeys(new String [] {EmailCl});
    			wd.findElement(By.id("login_password")).sendKeys(new String [] {Pass});
    			wd.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
                
    			//Type in WO # in search field
    			wd.findElement(By.id("searchTasks")).sendKeys(WO_title);
    			
    			//Click Search button
    			wd.findElement(By.xpath("(//*[@class='glyphicon glyphicon-search'])")).click();
    			 
    			//Verify WO number in TM - client
    			 Thread.sleep(9000);	
                 
                 if(wd.getPageSource().contains(WO_title))
 				{
 					System.out.println("- CLIENT: WO " + WO_title + " found through search - PASS ");
 				}
 				else
 				{
 				System.out.println("- CLIENT: WO " + WO_title + " not found through search - FAIL ");
 				}
    			
    			//Logout
                 Actions action3 = new Actions(wd);
     		    WebElement elems03 = wd.findElement(By.id("navTopRightMenuDisplayName"));
     		    WebElement elems003 = wd.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]"));
     		    action3.moveToElement(elems03).click().perform();
     		    Thread.sleep(2000);
     		    action3.moveToElement(elems003).click().perform();
     		    
                //wd.findElement(By.xpath("")).click();
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     		    
     		    
}}