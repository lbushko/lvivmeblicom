package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPopUp extends BasePage {

    public CartPopUp(WebDriver driver){
        super(driver);
    }

    private WebElement makeAnOrder;

    By makeAnOrderLocator = By.cssSelector("#cart > div.bottom_block > div.cw_bottom > a.main_order.form_but");

    public OrderPage clickMakeAnOrder(){
        makeAnOrder = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(makeAnOrderLocator)));
        makeAnOrder.click();
        return new OrderPage(driver);
    }

}
