package page.web;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashbordPage extends BasePage {

        WebDriver driver;

        public DashbordPage(WebDriver driver){
            super(driver);
            this.driver=driver;

        }

    By UsernameLogin=By.xpath("//span[@class='Fw(semi-bold) ng-binding']");
    By Usermenu=By.xpath("(//img[@alt='Wingify'])[2]");
    By LogOutUser=By.xpath("//li[@no-async-loader='true']");

        public String loginUserName()
        {
            waitForElementToAppear(UsernameLogin);
            return readText(UsernameLogin);
        }
    public void UsermenuOpt(){
            waitForElementToAppear(Usermenu);
            moveToElement(Usermenu);}
    public void logOut(){
        waitForElementToAppear(Usermenu);
        moveToElement(LogOutUser);}
    public Loginpage LogOutUserFromDashbord(){
            UsermenuOpt();
            logOut();
            waitForLoading();
            return new Loginpage(driver);}
}



