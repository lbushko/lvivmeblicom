package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends BasePage {

    public OrderPage(WebDriver driver){
        super(driver);
    }

    private WebElement name;

    By nameLocator = By.id("order_name");

    private WebElement phoneNumber;

    By phoneNumberLocator = By.id("order_phone");

    private WebElement email;

    By emailLocator = By.id("order_email");

    private WebElement city;

    By cityLocator = By.id("order_city");

    private WebElement cityName;

    By cityNameLocator = By.cssSelector("body > div.autocomplete-suggestions > div:nth-child(7)");

    private WebElement delivery;

    By deliveryLocator = By.cssSelector("#order_delivery_type > li:nth-child(2) > a");

    private WebElement deliveryType;

    By deliveryTypeLocator = By.cssSelector("#order_delivery_company > a:nth-child(1)");

    private WebElement deliveryAddress;

    By deliveryAddressLocator = By.cssSelector("#order_store_type > div.right_col.fm > div > a:nth-child(2)");

    private WebElement department;

    By departmentLocator = By.cssSelector("#order_warehouse > div.right_col.fm > div > div.overflow");

    private WebElement departmentNumber;

    By departmentNumberLocator = By.cssSelector("#order_warehouse > div.right_col.fm > div > ul > li:nth-child(1) > a");

    private WebElement payment;

    By paymentLocator = By.cssSelector("#order_payment_selector > a:nth-child(1)");

    private WebElement orderButton;

    By orderButtonLocator = By.cssSelector("body > section > div > section > section > div > div > div.right_col.fm > div.fm.opm_col.opm_col_product > div.fm.bottom_cart_prod > div > a");

    public OrderSent enterOrderInfo() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,10);

        name = wait.until(ExpectedConditions.presenceOfElementLocated(nameLocator));
        name.clear();
        name.sendKeys("test");

        phoneNumber = wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumberLocator));
        phoneNumber.sendKeys("0933850394");

        email = wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));
        email.sendKeys("lybomur.bushko@gmail.com");

        city = wait.until(ExpectedConditions.presenceOfElementLocated(cityLocator));
        city.sendKeys("Львов");

        cityName = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(cityNameLocator)));
        cityName.click();

        delivery = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(deliveryLocator)));
        delivery.click();

        deliveryType = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(deliveryTypeLocator)));
        deliveryType.click();

        deliveryAddress = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(deliveryAddressLocator)));
        deliveryAddress.click();

        department = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(departmentLocator)));
        department.click();

        departmentNumber = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(departmentNumberLocator)));
        departmentNumber.click();

        payment = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(paymentLocator)));
        payment.click();

        orderButton = (new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderButtonLocator)));
        orderButton.click();

        return new OrderSent(driver);
    }
}
