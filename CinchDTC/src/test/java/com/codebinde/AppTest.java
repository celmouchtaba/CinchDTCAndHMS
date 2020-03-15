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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
	WebDriver driver;
	public static String url ="https://uat.enroll.cinchhomeservices.com/enrollment/";
	public static String browser = "chrome";
	
	public  ArrayList<String[]> mainList = new ArrayList<String[]>();
	public  ArrayList<String> fetchFromExcell = new ArrayList<String>();
	public static String []arry0 = {"85001","100","joe","MOUCH","celmouchtaba@cinchhs.com","1234567895","30 W 17TH STREET","joe","micheal","4055011111111111","10","11","2020","234"};
	public static String []arry1 = {"33308","125","joe","MOUCH","celmouchtaba@cinchhs.com","2345433425","30 W 17TH STREET","micheal","micheal","4055011111111111","10","11","2020","234"};
	public static String []arry2 = {"33308","150","joe","joe","celmouchtaba@cinchhs.com","7894568564","30 W 17TH STREET","micheal","micheal","4055011111111111","10","11","2020","234"};
	/*
	 * @Before public void setUp() {
	 * 
	 * System.setProperty("webdriver.gecko.driver","C:\\Users\\EL MOU" +
	 * "CHTABA\\Desktop\\CCI Java\\CCI Example\\firefo\\geckodriver.exe"); WebDriver
	 * driver = new FirefoxDriver(); driver.get(url); }
	 */
	 
	
	@Test
	
	public void A() {
		readExcell();
		System.out.println(fetchFromExcell.get(1));
		mainList.add(arry0);
		mainList.add(arry1);
		mainList.add(arry2);
		for (int i = 0; i<mainList.size(); i++) {
			
		
		System.out.println("TEST");
	
		
		
		try {
			if(browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\EL MOU"
					+ "CHTABA\\Desktop\\CCI Java\\CCI Example\\firefo\\geckodriver.exe");
			 driver  = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("IE")){
			 System.setProperty("webdriver.ie.driver","C:\\Users\\EL MOU"
						+ "CHTABA\\Desktop\\CCI Java\\CCI Example\\ie\\New Folder\\IEDriverServer.exe");
			
			 DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			 
			 caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); //disable protected mode settings
			                caps.setCapability("initialBrowserUrl", url);
			                driver = new InternetExplorerDriver(caps);



			 // driver  = new InternetExplorerDriver();
			 }
			 else  {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\EL MOU"
						+ "CHTABA\\Desktop\\CCI Java\\CCI Example\\chrom\\chromedriver.exe");
			 
				//WebDriver driver  = new FirefoxDriver();
				//WebDriver driver  = new InternetExplorerDriver();
				 driver  = new ChromeDriver();
			 }
			 
				//driver.get(url);
				driver.navigate().to(url);
				Thread.sleep(5000);
				driver.manage().window().maximize();
				driver.findElement(By.id("zip")).sendKeys(mainList.get(i)[0]);
			//driver.findElement(By.className("btn btnLg")).click();
			
			//driver.findElement(By.id("email")).sendKeys("tijmst@yahoo.fr");
			//driver.findElement(By.id("pass")).sendKeys("Tijmst&C02327");
			driver.findElement(By.xpath("//form[@id='zipForm']/div[3]/button")).click();
			//String a  = driver.findElement(By.cssSelector("//section[@id='deductSection']/form/input[1]/label")).getText();
			//System.out.println(a);
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='deductSection']/form/input[1]")));
			//Thread.sleep(5000);
if (mainList.get(i)[1].equalsIgnoreCase("100")) {
	driver.findElement(By.xpath("//section[@id='deductSection']/form/input[1]")).click();
} else if(mainList.get(i)[1].equalsIgnoreCase("125")) {
	driver.findElement(By.xpath("//section[@id='deductSection']/form/input[2]")).click();
}else {
	driver.findElement(By.xpath("//section[@id='deductSection']/form/input[3]")).click();
}			
			
			driver.findElement(By.xpath("//tbody/tr[4]/td[1]/a")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Got it')]")));
			//Thread.sleep(5000);
			driver.findElement(By.xpath("//button[contains(.,'Got it')]")).click();
			
			Thread.sleep(3000);
			//scroll down
			if(browser.equalsIgnoreCase("ff")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("window.scrollBy(0,250)");}
			//Thread.sleep(3000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='btnTbl']/tbody/tr/td[2]/button[1]")));
			
			/*
			 * driver.findElement(By.
			 * xpath("//table[@class='comparePlansTbl table table-striped table-condensed table-responsive']/tbody/tr[6]/td[1]/a"
			 * )).click(); Thread.sleep(5000);
			 * driver.findElement(By.xpath("//button[contains(.,'Got it')]")).click();
			 * Thread.sleep(5000); driver.findElement(By.
			 * xpath("//table[@class='comparePlansTbl table table-striped table-condensed table-responsive']/tbody/tr[8]/td[1]/a"
			 * )).click(); Thread.sleep(5000);
			 * driver.findElement(By.xpath("//button[contains(.,'Got it')]")).click();
			 * Thread.sleep(5000); driver.findElement(By.
			 * xpath("//table[@class='comparePlansTbl table table-striped table-condensed table-responsive']/tbody/tr[10]/td[1]/a"
			 * )).click(); Thread.sleep(5000);
			 * driver.findElement(By.xpath("//button[contains(.,'Got it')]")).click();
			 * Thread.sleep(5000); driver.findElement(By.
			 * xpath("//table[@class='comparePlansTbl table table-striped table-condensed table-responsive']/tbody/tr[12]/td[1]/a"
			 * )).click(); Thread.sleep(5000);
			 * 
			 * driver.findElement(By.xpath("//button[contains(.,'Got it')]")).click();
			 * Thread.sleep(5000); driver.findElement(By.
			 * xpath("//table[@class='comparePlansTbl table table-striped table-condensed table-responsive']/tbody/tr[14]/td[1]/a"
			 * )).click(); Thread.sleep(5000);
			 * driver.findElement(By.xpath("//button[contains(.,'Got it')]")).click();
			 * Thread.sleep(5000); //driver.findElement(By.
			 * xpath("//table[@class='comparePlansTbl table table-striped table-condensed table-responsive']/tbody/tr[16]/td[1]/a"
			 * )).click(); //Thread.sleep(5000);
			 * //driver.findElement(By.xpath("//button[contains(.,'Got it')]")).click();
			 * 
			 * //Thread.sleep(5000);
			 */			
			driver.findElement(By.xpath("//table[@id='btnTbl']/tbody/tr/td[2]/button[1]")).click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='panel panel-default well']/div[1]/div[1]/div[1]/div/a/img")));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//section[@class='panel panel-default well']/div[1]/div[1]/div[1]/div/a/img")).click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='addonFooterSection']/div/div/button")));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id='addonFooterSection']/div/div/button")).click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Check out']")));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='Check out']")).click();
			//driver.findElement(By.xpath("//section[@id='scrolling']/div/section[4]/form/input[1]")).click();
			//driver.findElement(By.xpath("//input[@name='deductible' and @id='100' and @type='radio'")).click();
			//driver.findElement(By.xpath("//section[@id='deductSection']/form/input[1]/label")).click()
			//driver.get(url1);
			//driver.findElement(By.xpath("//table[@id='btnTbl']/tbody/tr/td[2]/button[1]")).click();
			//Thread.sleep(3000);

			//driver.findElement(By.xpath("//button[text()='Next']")).click();
			//sdriver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
			//driver.findElement(By.className("btn btnLg")).click();
			
			//driver.findElement(By.cssSelector(".(btn btnLg)")).click();
			Thread.sleep(3000);
			//driver.findElement(By.id("search_query_top")).sendKeys("Clothes");
			//driver.findElement(By.className("btn btnLg")).click();
			//driver.close();
			//String list = driver.findElement(By.cssSelector("#best-sellers_block_right div.block_content ul")).getText();
			//System.out.println(list);
			//List prices = new List();
			//String[] lines= list.split("\n");
			//for (int i = 2; i < lines.length; i=i+3) {
					//System.out.println("i="+i+" "+lines[i]);
			driver.findElement(By.id("firstName")).sendKeys(mainList.get(i)[2]);
			driver.findElement(By.id("lastName")).sendKeys(mainList.get(i)[3]);
			driver.findElement(By.id("email")).sendKeys(mainList.get(i)[4]);
			driver.findElement(By.id("email2")).sendKeys(mainList.get(i)[4]);
			driver.findElement(By.id("phone")).sendKeys(mainList.get(i)[5]);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("address")).sendKeys(mainList.get(i)[6]);
			driver.findElement(By.id("address2")).sendKeys(mainList.get(i)[6]);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			driver.findElement(By.id("annual")).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//input[@id='annual']/label")).click();
			driver.findElement(By.xpath("//button[text()='Next']")).click();
			driver.findElement(By.id("firstName")).sendKeys("Cheikh");
			driver.findElement(By.id("lastName")).sendKeys("EL MOUCHTABA");
			driver.findElement(By.id("ccNum")).sendKeys("4055011111111111");
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;  
			js1.executeScript("window.scrollBy(0,750)");
			Thread.sleep(8000);
			Select drpCountry = new Select(driver.findElement(By.id("expDateMonth")));
			drpCountry.selectByVisibleText("10");
			Select drpCountry1 = new Select(driver.findElement(By.id("expDateYear")));
			drpCountry1.selectByVisibleText("2020");
			driver.findElement(By.id("ccvNum")).sendKeys("234");
			driver.findElement(By.id("cCardBtn")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("check2")).click();
			driver.findElement(By.id("check3")).click();
			driver.findElement(By.id("check4")).click();
			driver.findElement(By.id("dob")).sendKeys("Nouakchott");
			driver.findElement(By.xpath("//button[text()='Agree and continue']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='Place order']")).click();
			Thread.sleep(3000);
			/*driver.findElement(By.id("password")).sendKeys("Tidjani8");
			driver.findElement(By.id("password2")).sendKeys("Tidjani8");
			driver.findElement(By.xpath("//button[text()='Create account']")).click();
			*/
				String plan_number = driver.findElement(By.xpath("//div[@class='contractNumWrap']/strong")).getText();
				System.out.println(plan_number);
				   BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/EL MOUCHTABA/Desktop/samplefile1.txt",true));
				   //writer.newLine();
				   	writer.write(plan_number);
				   	writer.newLine();
				   	writer.close();
			
			Thread.sleep(3000);

			
				
				
			//}
			//driver.quit();
		}
			
		catch(Exception ex)
		 {
			 ex.printStackTrace();
			 System.out.println("GTdfaegdstr" );
		 }
		//driver.quit();
		}
	}
	/*
	 * @Test public void secondTest() { System.out.println("bonjour"); }
	 * 
	 * @Test public void thirsTest() { System.out.println("Hello"); }
	 */
	
	@org.junit.After
	public void After() {
		//driver.quit();
	}
	
	public void readExcell(){
		try{
			
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\EL MOUCHTABA\\Selenium Excell Demo\\ReadExcell.xlsx")));
			XSSFSheet sheet = wb.getSheet("Demo");
			Iterator<Row> i = sheet.iterator();
			while (i.hasNext()) {
				Row row = i.next();
				Iterator<Cell> j = row.cellIterator();
				while (j.hasNext()) {
					Cell cell = j.next();
					//Adding Product details to list
					fetchFromExcell.add(cell.getStringCellValue());
					System.out.println(cell.getStringCellValue());
				}
				
			}
			
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		finally {
			System.out.println("abc");
		}
		
	}
	/*public void writeExcel(){
		try{
			FileInputStream fis = new FileInputStream(outputExcelFile);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(outputSheetName);
			int rowNum = 0;
			System.out.println(productDetailsList);
			for (int i = 0; i < productDetailsList.size(); i++) {
				Row row = sheet.createRow(rowNum++);
				int cellNum = 0;
				for (int j = 0; j < productDetailsList.get(i).size(); j++) {
					Cell cell = row.createCell(cellNum++);
					cell.setCellValue(cell.CELL_TYPE_STRING);
					cell.setCellValue(productDetailsList.get(i).get(j));
					System.out.println(productDetailsList.get(i).get(j)); 
					
				}
			}
			FileOutputStream fos = new FileOutputStream(outputExcelFile);
			wb.write(fos);
			fos.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
*/

	
}
