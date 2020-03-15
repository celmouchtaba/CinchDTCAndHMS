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

public class Hmsenrollment {

	WebDriver driver;
	public static String url ="https://uat.enroll.cinchhomeservices.com/real-estate/office-search";
	public static String browser = "chrome";
	public  ArrayList<String[]> mainList1 = new ArrayList<String[]>();
	public  ArrayList<String[]> mainList = new ArrayList<String[]>();
	public  ArrayList<String> fetchFromExcell = new ArrayList<String>();
	String []abc= {"","","","","",""};
	//Market 1
	public static String []arry0 = {"27519","%","100","2","Joe","Toulabi","6463458567","joe.toubi@GMAIL.COM","14 Scottslawn ave","APT 3","Joe","Toubi","4055011111111111","11","2025","634"};
	@Test
		 
		 public void A() {
	mainList.add(arry0);
	for (int i = 0; i<mainList.size(); i++) {
	try {
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\EL MOU"
		//		+ "CHTABA\\Desktop\\CCI Java\\CCI Example\\firefo\\geckodriver.exe");
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\EL MOU"
					+ "CHTABA\\Desktop\\CCI Java\\CCI Example\\chrom\\chromedriver.exe");
	driver  = new ChromeDriver();
		//driver  = new FirefoxDriver();
	driver.navigate().to(url);
	Thread.sleep(3000);
		    driver.manage().window().maximize();
		    driver.findElement(By.id("zip")).sendKeys(mainList.get(i)[0]);
	driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
	WebDriverWait wait=new WebDriverWait(driver, 20);
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']/tbody[1]/tr[1]/td[@class='text-center']/button[@class='btn']")));
		   driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr[1]/td[@class='text-center']/button[@class='btn']")).click();
	driver.findElement(By.id("lastName")).sendKeys(mainList.get(i)[1]);
		   driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
	 // driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']/tbody[1]/tr[1]/td[@class='text-center']/button[@class='btn']")));
		   driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr[1]/td[@class='text-center']/button[@class='btn']")).click();
		   //newpage 
		   JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("window.scrollBy(0,500)");
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zip")));
		   driver.findElement(By.id("zip")).sendKeys(mainList.get(i)[0]);
		   
		   Thread.sleep(5000);
		   Select drpCountry = new Select(driver.findElement(By.id("propType")));
			drpCountry.selectByVisibleText("Single Family Home");
			Select drpCountry1 = new Select(driver.findElement(By.id("planType")));
			drpCountry1.selectByVisibleText("Seller & Buyer Coverage");
			driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
	// Select drpCountry1 = new Select(driver.findElement(By.xpath("//div['dropdown bootstrap-select show-tick form-control ng-untouched ng-pristine ng-valid open']/button['btn dropdown-toggle btn-default']/div['filter-option']")));
		//  drpCountry1.selectByVisibleText(mainList.get(i)[5]);
			Thread.sleep(8000);
			//new page
			driver.findElement(By.xpath("//div[@class='panel-body']/div[2]/button[@class='btn btnLg text-center']")).click();
			Thread.sleep(8000);
			driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(.,'No')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(.,'No')]")).click();
			//new page 
			Thread.sleep(8000);
			driver.findElement(By.id("firstName")).sendKeys(mainList.get(i)[4]);
			driver.findElement(By.id("lastName")).sendKeys(mainList.get(i)[5]);
			driver.findElement(By.id("phone")).sendKeys(mainList.get(i)[6]);
			driver.findElement(By.id("email")).sendKeys(mainList.get(i)[7]);
			driver.findElement(By.id("address")).sendKeys(mainList.get(i)[8]);
			driver.findElement(By.id("address2")).sendKeys(mainList.get(i)[9]);
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
			System.out.println(plan_number);
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
		








}

