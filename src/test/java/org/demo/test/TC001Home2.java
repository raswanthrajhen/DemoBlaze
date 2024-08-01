package org.demo.test;

import org.demo.pages.HomePage;
import org.demo.seleniumBase.DemoBase;
import org.testng.annotations.Test;

public class TC001Home2 extends DemoBase {
	
	@Test  (dataProvider="getData")
	public void logIn(String[] data) throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.login(data[0],data[1]);
	}
}
