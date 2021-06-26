import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String strLdId ="";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		String strtitle = driver.findElement(By.xpath("//*[@id='header']//following::div[4]/h2")).getText();
        System.out.println(" The page title is " +strtitle);
        if(strtitle.contains("Demo Sales Manager"))
        {
        	System.out.println("Login successfull");
        }
        else
        {
        	System.out.println("Login is not successfull");
        	System.exit(0);
        	
        }
        
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//*[@id=\"label\"]/a")).click();
        driver.findElement(By.xpath("//a[text()='Leads']")).click();
        driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
        driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Gopi");
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(3000);
        
        //driver.findElement(By.xpath("//*[@id='findLeads']//*[@class='x-grid3-body']/div//a")).click();
        
        int size = driver.findElements(By.xpath("//*[@id='findLeads']//*[@class='x-grid3-body']/div")).size();
        
        System.out.println("Total number of records for given search criteria:"+size);
        
        if (size>0) {
        	
        	strLdId = driver.findElement(By.xpath("//*[@id='findLeads']//*[@class='x-grid3-body']/div[1]//a[1]")).getText();
        	System.out.println("Listed First Lead Id is >>>>>"+strLdId);
        	
        	driver.findElement(By.xpath("//*[@id='findLeads']//*[@class='x-grid3-body']/div[1]//a[text()='"+strLdId+"']")).click();
        	
        } else {
        	
        	System.out.println("No Results found for given criteria");
        	
        	System.exit(0);
        }
        
        
        
        /*for (int i=1; i<2;i++) {
        	
        	driver.findElement(By.xpath("//*[@id='findLeads']//*[@class='x-grid3-body']/div["+i+"]//a[1]")).click();
        	
        	}*/
        String str2 = driver.findElement(By.xpath("//div[@id='center-content-column']/div[1]/div/div/div/div/div")).getText();
        System.out.println("Navigated page title is ..."+str2);
        
        String strExpectedPgTitle = "View Lead";
        
        
        if (strExpectedPgTitle.equals(str2)) {
        	
        	driver.findElement(By.xpath("//a[text()='Edit']")).click();
        	
        	driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
        	
        	driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("TCS Canada");
        	
        	driver.findElement(By.xpath("//input[@value='Update']")).click();
        } else {
        	
        	System.out.println("Expected Pg title is 'View Lead'...actual Pg title is.... "+str2);
        	
        	System.exit(0);
        }
        
        String updtCmpyNm = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
        
        String exptCmpyNm = "TCS Canada ("+strLdId+")";
        
        if (updtCmpyNm.equals(exptCmpyNm)) {
        	
        	System.out.println("Expected updtcompany Name:"+ exptCmpyNm+"...actual name.."+updtCmpyNm);
        	
        	driver.close();
        } else {
        	
        	System.out.println("values are NOT matching Expected updtcompany Name:"+ exptCmpyNm+"...actual name.."+updtCmpyNm);
        	
        }
        
        
        
	}

}
