package com.codebinde;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Ccmid {
	
	WebDriver driver;
	public static String url ="https://uat.enroll.cinchhomeservices.com/real-estate/office-search";
	public static String browser = "chrome";
	public  ArrayList<String[]> mainList1 = new ArrayList<String[]>();
	public  ArrayList<String[]> mainList = new ArrayList<String[]>();
	public  ArrayList<String> fetchFromExcell = new ArrayList<String>();
	String []abc= {"","","","","",""};
	//groupe 3
	public static String []arry0 = {"141770762","%","80939","Single Family Home","Seller & Buyer Coverage","0","Joe","Toulabi","6463457567","joe.toubi@GMAIL.COM","4532 Marina Bay Dr","APT 3","Joe","Toubi","4055011111111111","11","2025","634"};
	public static String []arry1 = {"141770762","%","80261","Single Family Home","Seller & Buyer Coverage","1","Joe","Toulabi","6463457567","joe.toubi@GMAIL.COM","4532 Marina Bay Dr","APT 3","Joe","Toubi","4055011111111111","11","2025","634"};
	public static String []arry2 = {"142165996","%","80928","Single Family Home","Seller & Buyer Coverage","1","Joe","Toulabi","6463457567","joe.toubi@GMAIL.COM","62 Marina Bay Dr","APT 3","Joe","Toubi","4055011111111111","11","2025","634"};
	public static String []arry3 = {"142165996","%","80914","Townhouse, Condo","Seller & Buyer Coverage","1","Joe","Toulabi","6463457567","joe.toubi@GMAIL.COM","4532 Marina Bay Dr","APT 3","Joe","Toubi","4055011111111111","11","2025","634"};
	public static String []arry4 = {"142165994","%","80840","Multi Family","Seller & Buyer Coverage","1","Joe","Toulabi","6463457567","joe.toubi@GMAIL.COM","320 Marina Bay Dr","APT 3","Joe","Toubi","4055011111111111","11","2025","634"};
	public static String []arry5 = {"142165996","%","80940","Townhouse, Condo","Seller & Buyer Coverage","0","Joe","Toulabi","6463457567","joe.toubi@GMAIL.COM","4532 Marina Bay Dr","APT 3","Joe","Toubi","4055011111111111","11","2025","634"};  
	
	
	//group6 NO A/C coverage
	public static String []arry24 = {"141770223","%","85142","Single Family Home","Seller & Buyer Coverage","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55575","27551","0"};
	public static String []arry25 = {"142397111","%","92833","Multi Family","Seller & Buyer Coverage","1","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55576","27552","1"};
	public static String []arry26 = {"142221453","%","97843","Townhouse, Condo","Seller & Buyer Coverage","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55577","27553","0"};
	public static String []arry27 = {"142410570","%","89434","Townhouse, Condo","Buyer Coverage Only","1","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55578","27544","1"};
	public static String []arry28 = {"142420176","%","98671","Single Family Home","Buyer Coverage Only","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55579","27545","0"};
	public static String []arry29 = {"141770223","%","85382","Multi Family","Buyer Coverage Only","1","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55580","27546","1"};
	public static String []arry30 = {"142397111","%","77411","Single Family Home","New Construction","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55581","27547","0"};
	public static String []arry31 = {"142221453","%","97378","Single Family Home","Existing or Current Homeowner","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55582","27548","1"};
	public static String []arry32 = {"142410570","%","89316","Multi Family","Existing or Current Homeowner","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55583","27549","0"};
	public static String []arry33 = {"142420176","%","98020","Townhouse, Condo","Existing or Current Homeowner","1","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55584","27550","1"};
	//
//group6 NO A/C coverage
	public static String []arry34 = {"141770223","%","85222","Single Family Home","Seller & Buyer Coverage","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55585","27541","0"};
	public static String []arry35 = {"142397111","%","90232","Multi Family","Seller & Buyer Coverage","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55586","27542","1"};
	public static String []arry36 = {"142221453","%","97444","Townhouse, Condo","Seller & Buyer Coverage","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55587","27543","0"};
	public static String []arry37 = {"142410570","%","89032","Townhouse, Condo","Buyer Coverage Only","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55588","27534","1"};
	public static String []arry38 = {"142420176","%","98339","Single Family Home","Buyer Coverage Only","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55589","27535","0"};
	public static String []arry39 = {"141770223","%","85382","Multi Family","Buyer Coverage Only","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55590","27536","1"};
	public static String []arry40 = {"142397111","%","77411","Single Family Home","New Construction","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55591","27537","0"};
	public static String []arry41 = {"142221453","%","97378","Single Family Home","Existing or Current Homeowner","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55592","27538","1"};
	public static String []arry42 = {"142410570","%","89316","Multi Family","Existing or Current Homeowner","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Joe","Toubi","4055011111111111","11","2025","634","T55593","27539","0"};
	public static String []arry43 = {"142420176","%","98020","Townhouse, Condo","Existing or Current Homeowner","0","Joe","Toulabi","6463457567","jochin@cinchhs.com","45 S 20 Th Street ","APT 3","Mik","Toubi","4055011111111111","16","2035","456","T55594","27540","1"};
	
	//
	@Test
		 
		 public void A() {
	//mainList.add(arry0);
	//mainList.add(arry1);
		// readPdf ();
	//mainList.add(arry2);
		mainList.add(arry24);
	for (int i = 0; i<mainList.size(); i++) {
	try {
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\EL MOU"
		//	+ "CHTABA\\Desktop\\CCI Java\\CCI Example\\firefo\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\EL MOU"
				+ "CHTABA\\Desktop\\CCI Java\\CCI Example\\chrom\\chromedriver.exe");
		driver  = new ChromeDriver();
		//driver  = new FirefoxDriver();
	driver.navigate().to(url);
	//driver.findElement(By.id("memberNumber")).click();
	
	
	//Thread.sleep(8000);
		    driver.manage().window().maximize();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//section[@class='row']/div[@class='col-md-12']/div[@class='panel panel-default well']/div['searchOffice panel-body']/div[@class='radioWrap']/label[2]")).click();
		   // driver.findElement(By.cssSelector("#memberNumber")).click();
		    Thread.sleep(3000);
		    //driver.findElement(By.id("zip")).sendKeys(mainList.get(i)[0]);
		    driver.findElement(By.xpath("//div[@class='form-group']/input[@id='memberNumber']")).sendKeys(mainList.get(i)[0]); 
		    driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
		    WebDriverWait wait=new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']/tbody[1]/tr[1]/td[1]")));
		    Thread.sleep(3000);
		    String broker = driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr[1]/td[1]")).getText();
		   System.out.println(broker);
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']/tbody[1]/tr[1]/td[2]/button[@class='btn']")));
		   driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr[1]/td[2]/button[@class='btn']")).click();
		   driver.findElement(By.id("lastName")).sendKeys(mainList.get(i)[1]);
		   driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
	 // driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']/tbody[1]/tr[1]/td[@class='text-center']/button[@class='btn']")));
		  driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr[1]/td[@class='text-center']/button[@class='btn']")).click();
		  Thread.sleep(3000);
		   //
		   
		   //newpage 
		   
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zip")));
		   driver.findElement(By.id("zip")).sendKeys(mainList.get(i)[2]);
		   
		   Thread.sleep(5000);
		   Select drpCountry = new Select(driver.findElement(By.id("propType")));
			//drpCountry.selectByVisibleText("Single Family Home");
		   drpCountry.selectByVisibleText(mainList.get(i)[3]);
			Select drpCountry1 = new Select(driver.findElement(By.id("planType")));
			//drpCountry1.selectByVisibleText("Seller & Buyer Coverage");
			drpCountry1.selectByVisibleText(mainList.get(i)[4]);
			driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
	// Select drpCountry1 = new Select(driver.findElement(By.xpath("//div['dropdown bootstrap-select show-tick form-control ng-untouched ng-pristine ng-valid open']/button['btn dropdown-toggle btn-default']/div['filter-option']")));
		//  drpCountry1.selectByVisibleText(mainList.get(i)[5]);
			Thread.sleep(10000);
			//new page section 4
			//JavascriptExecutor js = (JavascriptExecutor) driver; 
			//js.executeScript("window.scrollBy(0,2700)");
		   //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='planWrap col-md-12']/div[4]/div[1]/div[2]/button[text()='Select']")));
		   //driver.findElement(By.xpath("//section[@class='planWrap col-md-12']/div[4]/div[1]/div[2]/button[text()='Select']")).click();
			// new page section 3
		   
		   JavascriptExecutor js3 = (JavascriptExecutor) driver; 
			js3.executeScript("window.scrollBy(0,2700)");
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='planWrap col-md-12']/div[3]/div[1]/div[2]/button[text()='Select']")));
		   driver.findElement(By.xpath("//section[@class='planWrap col-md-12']/div[3]/div[1]/div[2]/button[text()='Select']")).click();
		   //
		   //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='planWrap col-md-12']/div[2]/div[@class='panel-body']/div[2]/button[text()='Select']")));
			//driver.findElement(By.xpath("//section[@class='planWrap col-md-12']/div[2]/div[@class='panel-body']/div[2]/button[text()='Select']")).click();
			
		   Thread.sleep(5000);
			//System.out.println("hi");
			//driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//button[contains(.,'Yes')]")).click();
			System.out.println("hi");
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;  
			js1.executeScript("window.scrollBy(0,500)");
			//options
			Thread.sleep(3000);
			Select drpwpwbp = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[1]/td[1]/div[1]/select[1]")));//
			drpwpwbp.selectByVisibleText("1");
			Select drpstp = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[2]/td[1]/div[1]/select[1]")));//
			drpstp.selectByVisibleText("1");
			Select drpcpswh = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[3]/td[1]/div[1]/select[1]")));//
			drpcpswh.selectByVisibleText("1");
			Select drppwh = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[4]/td[1]/div[1]/select[1]")));//
			drppwh.selectByVisibleText("1");
			Select drpswh = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[5]/td[1]/div[1]/select[1]")));//
			drpswh.selectByVisibleText("1");
			Select drpowsglc = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[6]/td[1]/div[1]/select[1]")));//
			drpowsglc.selectByVisibleText("1");
			Select drpwdc = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[7]/td[1]/div[1]/select[1]")));//
			drpwdc.selectByVisibleText("1");
			Select drpogl = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[8]/td[1]/div[1]/select[1]")));//
			drpogl.selectByVisibleText("1");
			Select drpowl = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[9]/td[1]/div[1]/select[1]")));//
			drpowl.selectByVisibleText("3");
			Select drpPUP = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[10]/td[1]/div[1]/select[1]")));//
			drpPUP.selectByVisibleText(mainList.get(i)[5]);
			Select drposl = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[11]/td[1]/div[1]/select[1]")));//
			drposl.selectByVisibleText("4");
			Select drpws = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[12]/td[1]/div[1]/select[1]")));//
			drpws.selectByVisibleText("5");
			Select drpwp = new Select(driver.findElement(By.xpath("//div[@id='collapseFour']/div[1]/table[@class='combosTable table']/tbody[1]/tr[13]/td[1]/div[1]/select[1]")));//
			drpwp.selectByVisibleText("4");
			
			//System.out.println(drpPUP);
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//div[@id='collapseTwo']/table[]/tbody[]/tr[1]/td[1]/div[@class='dropdown bootstrap-select form-control']/button[]"))
			driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(.,'No')]")).click();
			Thread.sleep(3000);
			if(mainList.get(i)[5]=="0") {
				
				//System.out.println(drpwp.equals(0));
				Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(.,'No')]")).click();
			}
			//new page 
			Thread.sleep(8000);
			driver.findElement(By.id("firstName")).sendKeys(mainList.get(i)[6]);
			driver.findElement(By.id("lastName")).sendKeys(mainList.get(i)[7]);
			driver.findElement(By.id("phone")).sendKeys(mainList.get(i)[8]);
			driver.findElement(By.id("email")).sendKeys(mainList.get(i)[9]);
			driver.findElement(By.id("address")).sendKeys(mainList.get(i)[10]);
			driver.findElement(By.id("address2")).sendKeys(mainList.get(i)[11]);
			driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
			//new page 
			Thread.sleep(8000);
			//driver.manage().window().maximize();
			//driver.findElement(By.xpath("//div[@class='panel-body']/div[2]/input[@id='paymentType2']")).click();
			//panel-body
			//invoice
			driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
			//new page
			Thread.sleep(8000);
			driver.findElement(By.xpath("//button[contains(.,'Place my order')]")).click();
			//new page
			Thread.sleep(8000);
			String plan_number = driver.findElement(By.xpath("//div[@class='infoPanel panel panel-default']/p[1]")).getText();
			//System.out.println(plan_number);
			 System.out.println(plan_number);
			 Thread.sleep(3000);
			   driver.findElement(By.xpath("//a[contains(.,'View / Print Invoice')]")).click();
		       BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/celmouchtaba/Desktop/contractRealState.txt",true));
		       //writer.newLine();
		        writer.write(plan_number);
		        writer.newLine();
		        writer.close();
		   
		   
	}
		   
		  catch(Exception ex)
		   {
		    ex.printStackTrace();
		    System.out.println("GTdfaegdstr" );
		   }
		  //driver.quit();
		  }
		 }
	
	
	

	@org.junit.After
		 public void After() {
		  //driver.quit();
		 }
//Read pdf
	  public void readPdf (){
			try{
				
				FileInputStream obj = new FileInputStream("C:/Users/EL MOUCHTABA/Downloads/invoice-11182183.pdf");
						PDDocument objDoc = PDDocument.load(obj);
						PDFTextStripper objPDFStrp=new PDFTextStripper();
						String pdfContent=objPDFStrp.getText(objDoc );
						String linesp = System.lineSeparator();
						String[] paragraphs = pdfContent.split(linesp);
						/*int i=0;
						for(String p: paragraphs){
				            Scanner scan = new Scanner(p);
				            while((p=scan.next())!=null) {
				                if(p.startsWith("START"))
				                    do{
				                        i++;
				                        String nextline = scan.next();
				                        System.out.println(nextline); 
				                                        }while(i<5);
				            }
				            }*/
						//System.out.println(paragraphs[5]);
						System.out.println(pdfContent);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
//end read pdf
//end read pdf


}
