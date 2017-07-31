package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main extends BasePage {

    public Main(WebDriver driver){
        super(driver);
    }

    public String URL = "https://lvivmebli.com/";

    private WebElement searchField;

    By searchFieldLocator = By.name("query");

    private WebElement searchButton;

    By searchButtonLocator = By.cssSelector("#search_form > form > a");

    public void getMain(){
        driver.get(URL);
    }

    public SearchResultPage search(String query){

        WebDriverWait wait = new WebDriverWait(driver,10);

        searchField = wait.until(ExpectedConditions.presenceOfElementLocated(searchFieldLocator));
        searchField.clear();
        searchField.sendKeys(query);

        searchButton = wait.until(ExpectedConditions.presenceOfElementLocated(searchButtonLocator));
        searchButton.click();
        return new SearchResultPage(driver);
    }
}
