package tests.orgApps.vwo;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class VwoWeb_Test {
    ChromeOptions option;
    WebDriver driver;


    @BeforeMethod
    public void openBrowser() {
        option = new ChromeOptions();
        option.setHeadless(false);
        option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(option);
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
    }
    @Test(priority =1,enabled =true)
    @Description("Create new user and verification ")
    public void NewRegistration() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.findElement(By.linkText("Start a free trial")).click();
        WebElement emailadd=driver.findElement(By.tagName("input"));
        //emailadd.sendKeys("Abc4321@gmail.com");//(1st user created)
        //emailadd.sendKeys("Abcd4321@gmail.com");//(2nd user created)
        emailadd.sendKeys("Eabcdefgh@gmail.com");//(3nd user created)
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(5000);
       WebElement name=driver.findElement(By.xpath("//*[@id='page-v1-fname']"));
        Thread.sleep(5000);
        actions.sendKeys(name,"abcd$#$").build().perform();
        WebElement Lastname=driver.findElement(By.xpath("//*[@id='page-v1-lname']"));
        actions.sendKeys(Lastname,"ABC").build().perform();

        WebElement Clist=driver.findElement(By.className("iti__flag-container"));
        actions.moveToElement(Clist).click().build().perform();
        Thread.sleep(5000);
        WebElement Ncountry=driver.findElement(By.xpath("//*[@class='iti__country-list']/li[2]/span[1]"));
        actions.moveToElement(Ncountry).click().build().perform();

        WebElement PhoneNum=driver.findElement(By.xpath("//*[@id='page-v1-pnumber']"));
        actions.sendKeys(PhoneNum,"203576946").build().perform();
        WebElement Psw=driver.findElement(By.xpath("//*[@id='page-v1-pwd']"));
        actions.sendKeys(Psw,"abcedrg@#$$$(*").build().perform();
        WebElement clickbutton=driver.findElement(By.tagName("button"));
        actions.moveToElement(clickbutton).doubleClick();
        String ActualTitle=driver.getTitle();
        System.out.println(ActualTitle);
        String ExpectedTitle="Get Started with Free Trial | VWO";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
        Thread.sleep(6000);
        driver.close();

    }

    @Test(priority = 2)
    @Description("Negetive  login  verification ")
    public void loginNegetiveTest() throws InterruptedException {
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("bb0@esiix.ccom");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("ify@1tt23");

        driver.findElement(By.id("js-login-btn")).click();
      WebElement element=new WebDriverWait(driver, Duration.ofSeconds(5)) //Explicit Wait
               .until(ExpectedConditions.presenceOfElementLocated(By.id("js-notification-box-msg")));
               // .until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));

        String ActualErrorMsgg =element.getText();
        System.out.println(ActualErrorMsgg);
        String ExpectedErroeMsg="Your email, password, IP address or location did not match";
        Assert.assertEquals(ActualErrorMsgg,ExpectedErroeMsg);

        driver.close();}

    @Test(priority = 3)
    @Description("positive login  verification ")
    public void loginPositiveTest() throws InterruptedException {
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("Abc4321@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("abcedrg@#$$$6");
        driver.findElement(By.id("js-login-btn")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)//
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {//Fluent Wait:
            @Override
            public WebElement apply(WebDriver webDriver) {
                return  driver.findElement(By.id("js-login-btn"));
            }
        });
        driver.findElement(By.id("js-login-btn")).click();
        String ActualloginpageTitle = driver.getTitle();
        String ExpectedloginpageTitle="Login - VWO";
        Assert.assertEquals(ActualloginpageTitle,ExpectedloginpageTitle);
        driver.close();}
    @Test(priority = 3)
    @Description("Valid  user login and logout verification ")
    public void VwoAssignment() throws InterruptedException {
        Actions actions= new Actions(driver);
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("vwouser@gmail.com");//(User 1)
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("!@#$%^&*()Abc");//(psw user 1)


        WebElement checkbox=driver.findElement(By.xpath("//*[@class='checked-login-icon text--highlight']"));
              actions.moveToElement(checkbox).click().build().perform();

        WebElement signin=new WebDriverWait(driver, Duration.ofSeconds(5)) //Explicit Wait
                .until(ExpectedConditions.presenceOfElementLocated(By.id("js-login-btn")));
                 actions.moveToElement(signin).doubleClick().build().perform();



        WebElement DashboardText=new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='page-sub-title']")));

        String ActuallDashbordPageText = DashboardText.getText();
        System.out.println("Login success Page Text:"+ActuallDashbordPageText);
        String ExpectedlDashbordPageText="Hi vwo1 bwo2, here's an overview of your experience optimization journey";

        Assert.assertEquals(ActuallDashbordPageText,ExpectedlDashbordPageText);
        WebElement Usermenu=driver.findElement(By.xpath("(//img[@alt='vwo1 bwo2'])[2]"));
        actions.moveToElement(Usermenu).click().build().perform();

        WebElement logout=driver.findElement(By.xpath("//*[@class='menu-content js-menu-content open']/menu-content/ul/li[2]"));
        boolean bb=logout.isDisplayed();
        System.out.println(logout.getText());

        actions.moveToElement(logout).doubleClick().build().perform();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until((ExpectedConditions.titleIs("Login - VWO")));
        System.out.println("Sign in Page Title:"+driver.getTitle());
        driver.close();}




    @AfterTest
    public void tearDown() {

        driver.quit();
}}
