package org.bas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Actions;
import org.apache.commons.io.FileUtils;

public class BaseClass {
    public static WebDriver driver;


    // Method to launch browser
    public static void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    // Method to maximize the browser window
    public static void windowMaximize() {
        driver.manage().window().maximize();
    }

    // Method to launch a URL
    public static void launchUrl(String url) {
        driver.get(url);
    }

    // Method to get and print the page title
    public static void pageTitle() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    // Method to get and print the current page URL
    public static void pageUrl() {
        String url = driver.getCurrentUrl();
        System.out.println(url);
    }

    // Method to pass text to a WebElement
    public static void passText(String txt, WebElement ele) {
        ele.sendKeys(txt);
    }

    // Method to close the entire browser
    public static void closeEntireBrowser() {
        driver.quit();
    }
        
        public static void clickBtn(WebElement ele) {
        	ele.click();
        	
        }        	  

        	    // Method to take a screenshot
        	    public static void screenShot(String imgName) throws IOException {
       	        TakesScreenshot ts = (TakesScreenshot) driver;
        	        File source = ts.getScreenshotAs(OutputType.FILE);
        	        File destination = new File("screenshots/" + imgName + ".png"); // Specify your desired folder
        	        FileUtils.copyFile(source, destination);
        	        System.out.println("Screenshot saved at: " + destination.getAbsolutePath());
        	    }

        	    // Method to move the cursor to a target WebElement
        	    public static void moveTheCursor(WebElement targetWebElement) {
       	        Actions actions = new Actions(driver);
        	        actions.moveToElement(targetWebElement).perform();
        	        System.out.println("Cursor moved to the target element.");
        	    }

        	    // Method to perform drag-and-drop
        	    public static void dragDrop(WebElement dragWebElement, WebElement dropElement) {
        	        Actions actions = new Actions(driver);
        	        actions.dragAndDrop(dragWebElement, dropElement).perform();
        	        System.out.println("Drag-and-drop performed successfully.");
        	    }
        	    public static JavascriptExecutor js;
        	    public static void scrollThePage(WebElement tarWebEle) {
        	    js = (JavascriptExecutor)driver;
        	    js.executeScript("arguments[0].scrollIntoView(true)",tarWebEle);
}
        	    public static void scroll(WebElement element) {
        	    	js = (JavascriptExecutor)driver;
        	    	js.executeScript("arguments[0].scrollIntoView(false)",element);
        	    }

                // Method to read data from an Excel file
                public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
                    File file = new File("ExcelLocation.xlsx");
                    FileInputStream fis = new FileInputStream(file);
                    Workbook wb = new XSSFWorkbook(fis);
                    Sheet mysheet = wb.getSheet("Data");
                    Row r = mysheet.getRow(rowNum);
                    Cell c = r.getCell(cellNum);
                    int cellType =c.getCellType();
                    
                     String value ="";
                    if (cellType == 1) {
                        String value2 = c.getStringCellValue();
                    }
                        
                    else if (DateUtil.isCellDateFormatted(c)) {
                    	Date dd = c.getDateCellValue();
                    	SimpleDateFormat s = new SimpleDateFormat(value);
                    	String value1 = s.format(dd);
                    }
                    else {
                    	double d = c.getNumericCellValue();
                    	long l = (long) d;
                    	String valueOf = String.valueOf(1);
                    }
                }       

 			
            // Method to create a new Excel file
            public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
                File file = new File("ExcelLocation.xlsx");
                XSSFWorkbook newWorkbook = new XSSFWorkbook();
                XSSFSheet newSheet = newWorkbook.createSheet("Datas");
                Row newRow = newSheet.createRow(rowNum);
                Cell newCell = newRow.createCell(cellNum);
                newCell.setCellValue(writeData);
                FileOutputStream fos = new FileOutputStream(file);
                newWorkbook.write(fos);
                fos.close();
                System.out.println("New Excel file created successfully.");
            }

            // Method to create a new cell in an existing Excel file
            public static void createCell(int getRow, int createCell, String newData) throws IOException {
                File file = new File("ExcelLocation.xlsx");
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheet("Datas");
                Row row = sheet.getRow(getRow);
                Cell cell = row.createCell(createCell);
                cell.setCellValue(newData);
                FileOutputStream fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.close();
                System.out.println("New cell created successfully.");
            }

            // Method to create a new row in an existing Excel file
            public static void createRow(int createRow, int createCell, String newData) throws IOException {
                File file = new File("ExcelLocation.xlsx");
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheet("Datas");
                Row row = sheet.createRow(createRow);
                Cell cell = row.createCell(createCell);
                cell.setCellValue(newData);
                FileOutputStream fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.close();
                System.out.println("New row created successfully.");
            }

            // Method to update data in an existing cell
            public static void updateDataToCell(int getRow, int getCell, String existingData, String writeNewData) throws IOException {
                File file = new File("ExcelLocation.xlsx");
                FileInputStream fis = new FileInputStream(file);
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheet("Datas");
                Row row = sheet.getRow(getRow);
                Cell cell = row.getCell(getCell);
                String cellData = cell.getStringCellValue();
                if (cellData.equals(existingData)) {
                    cell.setCellValue(writeNewData);
                }
                FileOutputStream fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.close();
                System.out.println("Cell data updated successfully.");
                       
                    
                    
                
                
            }
}


       

            


