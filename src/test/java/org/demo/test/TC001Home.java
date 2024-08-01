package org.demo.test;

import org.demo.pages.HomePage;
import org.demo.seleniumBase.DemoBase;
import org.testng.annotations.Test;

public class TC001Home extends DemoBase {
	
	@Test(dataProvider="getData")
	public void singIn(String[] data) throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.singIn(data[0],data[1]);
		
	
	}

}
