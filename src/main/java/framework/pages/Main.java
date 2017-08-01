package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends BasePage {

    public Main(WebDriver driver){
        super(driver);
    }

    public String URL = "https://lvivmebli.com/";

    private WebElement searchField;

    By searchFieldLocator = By.name("query");

    private WebElement searchButton;

    By searchButtonLocator = By.cssSelector("#search_form > form > a");

    private WebElement reviewLink;

    By reviewLinkLocator = By.cssSelector("body > section > header > div.fm.for_top_menu > div > nav > ul > li:nth-child(2) > a");

    private List<WebElement> menu;

    By menuLocator = By.xpath("//nav[@class='main_nav']/ul/li[@class='has_drop']/a");

    private WebElement login;

    By liginLink = By.cssSelector("body > section > header > div.fm.for_top_menu > div > div.fmr.for_login > a");

    private WebElement emailField;

    By emailFieldLocator = By.name("login_email");

    private WebElement passwordField;

    By passwordFieldLocator = By.id("login_password");

    private WebElement submitButton;

    By submitButtonLocator = By.cssSelector("#login_send");

    private WebElement phoneMTS;

    By phoneMTSLocator = By.className("mts");

    private WebElement phoneKyivstar;

    By phoneKyivstarLocator = By.className("kyivstar");

    private WebElement phonelife;

    By phonelifeLocator = By.className("life");

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

    public ReviewPage clickReviewLink(){
        reviewLink = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(reviewLinkLocator)));
        reviewLink.click();
        return new ReviewPage(driver);
    }

    //TODO not working
    public void clickMenu(){

        getMain();

        String mainPage = driver.getWindowHandle();

        menu = (new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(menuLocator)));

        List<String> list = new ArrayList<String>();

        for (WebElement element : menu
                ) {
            Actions action = new Actions(driver);
            action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

            for (String handle: driver.getWindowHandles()
                 ) {
                driver.switchTo().window(handle);
            }

            list.add(driver.getTitle());

            driver.switchTo().window(mainPage);
        }

        for (String s: list
             ) {
            System.out.println(s);
        }
//        return null;
    }

    public void getLogin(String email, String password){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        login = wait.until(ExpectedConditions.elementToBeClickable(liginLink));
        login.click();

        for (String handle : driver.getWindowHandles()
             ) {
            driver.switchTo().window(handle);
        }

        emailField = wait.until(ExpectedConditions.presenceOfElementLocated(emailFieldLocator));
        emailField.sendKeys(email);

        passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(passwordFieldLocator));
        passwordField.sendKeys(password);

        submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButton.submit();
    }

    public String[] getPhones(){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        String[] arr = new String [3];

        phoneMTS = wait.until(ExpectedConditions.presenceOfElementLocated(phoneMTSLocator));
        arr[0] = phoneMTS.getAttribute("innerText").replaceAll("\\s+","");

        phoneKyivstar = wait.until(ExpectedConditions.presenceOfElementLocated(phoneKyivstarLocator));
        arr[1] = phoneKyivstar.getAttribute("innerText").replaceAll("\\s+","");

        phonelife = wait.until(ExpectedConditions.presenceOfElementLocated(phonelifeLocator));
        arr[2] = phonelife.getAttribute("innerText").replaceAll("\\s+","");

        return arr;
    }
}
