package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.web.WaitForHelper;
import utils.PropertyReaderOptimized;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    /*public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }*/
    public BasePage(WebDriver driver){this.driver=driver;}
    public void goTourl(String url)
    {
        driver.get(url);
    }
    public void waitForElementToAppear(By elementLocation){
        new WaitForHelper(driver).presenceOfElement(elementLocation);
    }
    public void waitForLoading(){ new  WaitForHelper(driver).implicitWait();}
    public void waitForTitle(String string){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until((ExpectedConditions.titleIs(string)));
    }

    public void click(By elementlocation){driver.findElement(elementlocation).click();}
    public void click(WebElement elementlocation){elementlocation.click();}

    public void writetext(By elementlocation,String text ){
        driver.findElement(elementlocation).clear();
        driver.findElement(elementlocation).sendKeys(text);
    }
    public void writetext(WebElement elementlocation,String text ){
        elementlocation.clear();
        elementlocation.sendKeys(text);
    }
    public String readText(By elementLocation){
        return driver.findElement(elementLocation).getText();
     }


    public void moveToElement(By elementLocation){ new Actions(driver).
            moveToElement(driver.findElement(elementLocation)).click().build().perform();}
    public void moveToElementDoubleClick(By elementLocation){ new Actions(driver).
            moveToElement(driver.findElement(elementLocation)).doubleClick().build().perform();}
}
