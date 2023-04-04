/*
 * @author Naveen Khunteta
 * 
 */

package tests;

import java.io.IOException;

import Base.Testbase;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;


import page.web.DashbordPage;
import page.web.Loginpage;
import utils.TestUtil;

public class NegativeLoginTest extends Testbase {
	public NegativeLoginTest(){
		super();
	}
	String sheetName = "sheet1";
	@DataProvider
	public Object[][] getTestData(){ //data from excel file
		Object data[][] = TestUtil.getTestData(sheetName);//TestUtil--->getTestData--->read from excel
		return data;
	}
	@Test(priority=1, dataProvider="getTestData")
	public void validateNegitiveLogin(String email, String password){
		Loginpage loginpage=new Loginpage(driver);
		loginpage.LoginVwo(email,password);
		driver.manage().window().maximize();
		String ExpectvalidationMassage=loginpage.verificationMessageNegativeTest();
		System.out.println("Dashboard UserName="+ExpectvalidationMassage);
		Assert.assertEquals(ExpectvalidationMassage,"Your email, password, IP address or location did not match");
	}
	
	


	
	
	
	
}
