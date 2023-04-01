package page.web;

import org.bouncycastle.asn1.cms.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitForHelper {
    public WebDriver driver;
    public WaitForHelper(WebDriver driver ){this.driver =driver;}

    public void implicitWait(){driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS);}
    public WebElement presenceOfElement(final By elementLocation){
        return new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }
    public WebElement elementToBeClickable(final By elemmentIdentier){
        WebElement element=new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(elemmentIdentier));
                        return element;

    }
}
