package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.baseclasses.TestBase;

public class TestUtil extends TestBase {
	
	public static long Page_load_timeout=20;
    public static long Implicit_wait=10;
    public static Workbook workbook = null;
	public static Sheet sheet = null;
	//public Row row = null;
	//public Cell cell = null;

    public static String testDataPath="C:\\Madhuri Naik DATA\\eclipse-workspace\\FreeCRMTest\\"
    		+ "src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRM.xlsx";
    
    //static Workbook book;
    //static Sheet sheet;
    public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException{
    	FileInputStream file=null;
    	try {
    		file=new FileInputStream(testDataPath);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	try {
    		 workbook=WorkbookFactory.create(file);
    		}catch(InvalidFormatException e) {
    			e.printStackTrace();
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
       sheet=workbook.getSheet(sheetName);
       Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
       for(int i=0;i<sheet.getLastRowNum();i++) {
    	   for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
    		   data[i][k]=sheet.getRow(i+1).getCell(k).toString();
    	   }
       }
     return data;
    }
    
    public static void takeScreenshotAtEndOfTest() throws IOException {
		/*File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileHandler.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));*/
       TakesScreenshot ts=(TakesScreenshot)driver;
       File src=ts.getScreenshotAs(OutputType.FILE);
       File desti=new File("C:\\Madhuri Naik DATA\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\screenshot\\myscreen.png");
       FileHandler.copy(src,desti);

    }

	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Check for jQuery on the page, add it if need be
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(5000);

		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");
//'"+color+"'"
		if (messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
		}else if(messageType.equals("info")){
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		}else if(messageType.equals("warning")){
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		}else
			System.out.println("no error message");
		// jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		Thread.sleep(5000);
	}

}

