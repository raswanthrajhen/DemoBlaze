package org.demo.seleniumBase;



import java.util.Arrays;

import org.demo.utilz.ReadExcel;
import org.demo.utilz.UtilityClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class DemoBase extends UtilityClass {

	//protected WebDriver driver=null;
	String filename;
	
	@DataProvider(name="getData")
	public String[][] getData(){
	String[][] excelData=ReadExcel.raedExcel(filename);
	
	   for (String[] row : excelData) {
           System.out.println(Arrays.toString(row));
       }
		return excelData;
	}
	
	
	
	@BeforeClass
	@Parameters({"url","browsers","filename"})
	public void openwindow(String url,String browser,String filename) throws Exception {
			browserLaunch( url, browser);
			this.filename=filename;
		 	/*driver=new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));*/
	}
	
	
	@AfterClass
	public void teardown() {
		quitBrowser();
	}
	
}
