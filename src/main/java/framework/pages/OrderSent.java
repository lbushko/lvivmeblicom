package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSent extends BasePage {

    public OrderSent(WebDriver driver){
        super(driver);
    }

    private WebElement h2;

    By h2Locator = By.cssSelector("body > section > div > section > section > div > article > h2:nth-child(1)");

    private WebElement h2Manager;

    By h2ManagerLocator = By.cssSelector("body > section > div > section > section > div > article > h2:nth-child(3)");

    public String getH2(){
        h2 = (new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(h2Locator)));
        return h2.getAttribute("innerText").replace("[","").replace("]","");
    }

    public String getH2Manager(){
        h2Manager = (new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(h2ManagerLocator)));
        return h2Manager.getAttribute("innerText");
    }
}
