package framework.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroopItems extends BasePage {

    public GroopItems(WebDriver driver){
        super(driver);
    }

    public String URL = "https://lvivmebli.com/vitriny/";

    By itemcount = By.xpath("/html/body/section/div/section/section[1]/div/div/div/div[2]/header/div[1]/span");

    By oneGood = By.className("catalog_item fm");

    private WebElement item;

    By itemlink = By.cssSelector("#products_list > div:nth-child(1) > div > div.fm.og_photo > div > a > img");

    private WebElement upperPriceFilter;

    By upperPriceFilterLocator = By.className("noUi-handle noUi-handle-lower");

    private WebElement lowerPriceFilter;

    By lowerPriceFilterLocator = By.xpath("//*[@id=\"price_slider\"]/div/div[1]/div");

    private WebElement priceSlider;

    By priceSliderLocator = By.cssSelector("#price_slider > div");

    private WebElement price_asc;

    By price_ascLocator = By.cssSelector("#catalog_sort > ul > li:nth-child(1) > a");

    private WebElement price_desc;

    By price_descLocator = By.cssSelector("#catalog_sort > ul > li:nth-child(2) > a");

    private WebElement popular;

    By popular_Locator = By.cssSelector("#catalog_sort > ul > li:nth-child(3) > a");

    private WebElement sortDropDown;

    By sortDropDownLocator = By.id("catalog_sort");

    private WebElement selectedSort;

    By selectedSortLocator = By.cssSelector("#catalog_sort > ul > li.selected > a");

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
        WebDriverWait wait = new WebDriverWait(driver, 10);

        priceSlider = wait.until(ExpectedConditions.presenceOfElementLocated(priceSliderLocator));

        Dimension sliderSize = priceSlider.getSize();
        int sliderWidth = sliderSize.getWidth() / 3;

        lowerPriceFilter = wait.until(ExpectedConditions.presenceOfElementLocated(lowerPriceFilterLocator));
        int xCoord = lowerPriceFilter.getLocation().getX();

        Actions builder = new Actions(driver);
            builder.moveToElement(priceSlider)
                .click()
                .dragAndDropBy(lowerPriceFilter,xCoord+sliderWidth, 0)
                .build()
                .perform();
    }

    public String sortByPriceAsc(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        sortDropDown = wait.until(ExpectedConditions.elementToBeClickable(sortDropDownLocator));
        sortDropDown.click();
        price_asc = wait.until(ExpectedConditions.elementToBeClickable(price_ascLocator));
        price_asc.click();

        selectedSort = wait.until(ExpectedConditions.presenceOfElementLocated(selectedSortLocator));
        return selectedSort.getAttribute("innerText");
    }

    public String sortByPriceDesc(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        sortDropDown = wait.until(ExpectedConditions.elementToBeClickable(sortDropDownLocator));
        sortDropDown.click();
        price_desc = wait.until(ExpectedConditions.elementToBeClickable(price_descLocator));
        price_desc.click();

        selectedSort = wait.until(ExpectedConditions.presenceOfElementLocated(selectedSortLocator));
        return selectedSort.getAttribute("innerText");
    }

    public String sortByPopular(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        sortDropDown = wait.until(ExpectedConditions.elementToBeClickable(sortDropDownLocator));
        sortDropDown.click();
        popular = wait.until(ExpectedConditions.elementToBeClickable(popular_Locator));
        popular.click();

        selectedSort = wait.until(ExpectedConditions.presenceOfElementLocated(selectedSortLocator));
        return selectedSort.getAttribute("innerText");
    }

}
