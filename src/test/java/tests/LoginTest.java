package tests;

import Base.Testbase;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.web.DashbordPage;
import page.web.Loginpage;

import java.sql.SQLOutput;
import java.time.Duration;

public class LoginTest extends Testbase {

    public LoginTest(){
        super();
        }

        @Test(priority = 1,invocationCount = 1)//Repeat multiple time Test method
    @Owner("NaniRam")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Positive Login Page")
    public void VwoAssignment5(){
            Loginpage loginpage=new Loginpage(driver);
            loginpage.LoginVwo("93npu2yyb0@esiix.com","Wingify@123");
            driver.manage().window().maximize();
            DashbordPage dashbordPage= new DashbordPage(driver);
            String expectUserName=dashbordPage.loginUserName();
            System.out.println("Dashboard UserName="+expectUserName);
            Assert.assertEquals(expectUserName,"Wingify");
            Loginpage loginback= dashbordPage.LogOutUserFromDashbord();

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            System.out.println("Login page Verification Text:"+loginpage.verificationMessage());
            Assert.assertEquals(loginback.verificationMessage(),"SIGN IN TO VWO PLATFORM");

    }



}