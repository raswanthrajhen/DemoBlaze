package org.demo.utilz;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class UtilityClass {
	
	public  WebDriver driver=null;
	public static Properties prop;
	public String sheetname;
	
	
	
	/** Luanch the browser and common utility available in this method
	 * 
	 * @param url
	 * @param browser
	 * @throws Exception
	 */
	
	public void browserLaunch(String url, String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("headless")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		} else {
			driver = new ChromeDriver();
		}
		
		// Validate broken link
		
		// make the connection
		
		URL link = new URL(url);  
		HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(3000);
		httpURLConnection.connect();
		
		// Get the response code and validate
		
		if(httpURLConnection.getResponseCode()== 200) {
			System.out.println(url +" - "+ httpURLConnection.getResponseMessage());
			driver.get(url);
		} else {
			System.out.println(url +" - "+ httpURLConnection.getResponseMessage());
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	

	public void checkAssert(boolean assertValue,String pageName) {
		try {
		Assert.assertEquals(true, assertValue);
		}
		catch(Exception ex) {
			 System.out.println("The assert vale chane in "+ pageName);
		}
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public void click(WebElement elements) {
	
	        int attempts = 0;
	        while (attempts < 3) {
	            try {
	                elements.click();
	                break;
	            } catch (StaleElementReferenceException e) {
	                attempts++;
	                System.out.println("StaleElementReferenceException caught. Attempting again...");
	            } catch (ElementClickInterceptedException e) {
	                attempts++;
	                System.out.println("ElementClickInterceptedException caught. Attempting again...");
	             
	            }
	        }
	}

}
