package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    By searchItemLocator = By.xpath("//div[@class='fm og_name']/a");

    private WebElement searchItemCount;

    By searchItemCountLocator = By.cssSelector("body > section > div > section > section > div > div > div > div.catalog_box > div.results-title.fm");

    private WebElement nextPagelink;

    By nextPagelinkLocator = By.xpath("//*[@class='paginator']/a[@class='pag_right']");

    public List<String> getSearchItems(){

        List<WebElement> searchItems;

        List<String> searchItemsNames = new ArrayList<String>();

        searchItems = (new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchItemLocator)));

        for (WebElement e : searchItems
                ) {
            searchItemsNames.add(e.getAttribute("innerText"));
        }
        return searchItemsNames;
    }

    public int searchItemCout(){
        searchItemCount = (new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(searchItemCountLocator)));
        return Integer.parseInt(searchItemCount.getAttribute("innerText").replaceAll("\\D+",""));
    }

    public List<String> getAllItems(){
        List<String> allItems = new ArrayList<String>();
        boolean activeArrow = true;
        do {
            try {
                allItems.addAll(getSearchItems());
                nextPagelink = (new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(nextPagelinkLocator)));
                nextPagelink.click();
            }
            catch (Exception e){
                activeArrow = false;
            }
        }
        while (activeArrow);
        return allItems;
    }
}
