package page.web;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage extends BasePage {
    WebDriver driver;
    public Loginpage(WebDriver driver){
        super(driver);
        this.driver=driver;

    }
                    By text=By.id("js-notification-box-msg");
                    By username=By.id("login-username");
                    By password=By.name("password");
                    By checkbox=By.xpath("//*[@class='checked-login-icon text--highlight']");

                    By loginpageText=By.id("js-sign-in-heading");
                    By signIn=By.id("js-login-btn");
                   public  String verificationMessage(){
                       waitForTitle("Login - VWO");
                       return readText(loginpageText);}
                  public  String verificationMessageNegativeTest(){
                     waitForTitle("Login - VWO");
                             return readText(text);}
                   public void inputusername(String email) {
                       writetext(username,email);
                      }
                   public void inputpassword(String pass){
                        writetext(password,pass);}
                    public void Checkboxclick(){moveToElement(checkbox);}
                    public void loginclickButton(){
                     click(signIn);}

    public DashbordPage LoginVwo(String email, String password)
    {
        goTourl("https://app.vwo.com");
        inputusername(email);
        inputpassword(password);
        Checkboxclick();
        loginclickButton();
    return new DashbordPage(driver);}

    }

