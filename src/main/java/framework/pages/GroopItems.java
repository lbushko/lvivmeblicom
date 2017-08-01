package framework.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroopItems extends BasePage {

    public String URL = "https://lvivmebli.com/vitriny/";

    By itemcount = By.xpath("/html/body/section/div/section/section[1]/div/div/div/div[2]/header/div[1]/span");

    By oneGood = By.className("catalog_item fm");

    private WebElement item;

    By itemlink = By.cssSelector("#products_list > div:nth-child(1) > div > div.fm.og_photo > div > a > img");

    private WebElement upperPriceFilter;

    By upperPriceFilterLocator = By.className("noUi-handle noUi-handle-lower");

    private WebElement lowerPriceFilter;

    By lowerPriceFilterLocator = By.className("noUi-handle noUi-handle-upper");

    public GroopItems(WebDriver driver){
        super(driver);
    }

    public void getGroopItemsPage(){
        driver.get(URL);
    }

    public ItemPage goItemPage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        item = wait.until(ExpectedConditions.elementToBeClickable(itemlink));
        item.click();
        return new ItemPage(driver);
    }

    public void setPriceFilter(){

    }
}
