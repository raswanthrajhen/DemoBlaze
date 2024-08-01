package org.demo.pages;

import java.time.Duration;

import org.demo.seleniumBase.DemoBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends DemoBase{

	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public HomePage singIn(String userName,String password) {
		try {
		
		//thread.sleep is for to avoid the random popUp
		Thread.sleep(6000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		By siginButtonLocator = By.id("signin2");
		WebElement locatorSigIn = wait.until(ExpectedConditions.visibilityOfElementLocated(siginButtonLocator));
		wait.until(ExpectedConditions.elementToBeClickable(locatorSigIn));
		click(locatorSigIn);
		
		//Assert checking in singInPage
		 WebElement userNameAssertField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='sign-username']")));
		 boolean userNameAssert=userNameAssertField.isDisplayed();
		
		 WebElement passwordAssertField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='sign-password']")));
		 boolean passwordAssert=passwordAssertField.isDisplayed();
		
		 checkAssert(userNameAssert,"singInPage");
		 checkAssert(passwordAssert,"singInPage");
		 
		 //Find the element for the userName and password textBox 
		 WebElement usernameField = driver.findElement(By.xpath("//input[@id='sign-username']"));
         WebElement passwordField = driver.findElement(By.xpath("//input[@id='sign-password']"));
         
          usernameField.clear();
          passwordField.clear();
          WebElement locatorusernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sign-username']")));
          locatorusernameField.sendKeys(userName);
          WebElement locatorpasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sign-password']")));
          locatorpasswordField.sendKeys(password);
		  click(driver.findElement(By.xpath("//button[normalize-space()='Sign up']")));
		
		  //Accept the sigIn Done Alert
          Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	      alert.accept();
		
		
		}
		catch(Exception e){
			System.out.println("Exception encountered: " + e.getMessage());
	        e.printStackTrace();
		}
		return this;
	}
	


	public void login(String userName,String password) throws InterruptedException {
		try {
			
			//thread.sleep is  To avoid the random popUp
			Thread.sleep(6000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
			By loginButtonLocator = By.xpath("//a[@data-target='#logInModal']");
			
			//Enter into loginpage
			WebElement locatorLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
			wait.until(ExpectedConditions.elementToBeClickable(locatorLogin));
			locatorLogin.click();
			
			
			//Assert checking in logInPage
			 WebElement userNameAssertField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='log-name']")));
			 boolean userNameAssert=userNameAssertField.isDisplayed();
			
			 WebElement passwordAssertField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='log-pass'][normalize-space()='Password:']")));
			 boolean passwordAssert=passwordAssertField.isDisplayed();
			
			 checkAssert(userNameAssert,"logInPage");
			 checkAssert(passwordAssert,"logInPage");
			 
			WebElement locatorUser=driver.findElement(By.xpath("//input[@id='loginusername']"));
			wait.until(ExpectedConditions.elementToBeClickable(locatorUser));
			locatorUser.sendKeys(userName);
			
			driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys(password);
			WebElement locator=driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
			click(locator);
			
			String nameOfUser=driver.findElement(By.xpath("//a[@id='nameofuser']")).getText();
			System.out.print(nameOfUser);
			}
		catch(Exception e){
			System.out.println("Exception encountered: " + e.getMessage());
	        e.printStackTrace();
		}
	}
}
