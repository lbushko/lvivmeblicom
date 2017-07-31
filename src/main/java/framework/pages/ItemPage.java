package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver){
        super(driver);
    }

    private WebElement addToCart;

    By addToCartLocator = By.cssSelector("#product_all > div.top_right_col.fm > div > div.fm.buy_me > a");

    public CartPopUp clickAddToCart() {
        addToCart = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(addToCartLocator)));
        addToCart.click();

        for (String handle : driver.getWindowHandles()
                ) {
            driver.switchTo().window(handle);
        }

        return new CartPopUp(driver);
    }
}
