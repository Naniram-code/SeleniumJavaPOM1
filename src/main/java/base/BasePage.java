package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import page.web.WaitForHelper;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){this.driver=driver;}
    public void goTourl(String url)
    {
        driver.get(url);
    }
    public void waitForElementToAppear(By elementLocation){
        new WaitForHelper(driver).presenceOfElement(elementLocation);
    }
    public void waitForLoading(){ new  WaitForHelper(driver).implicitWait();}
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
