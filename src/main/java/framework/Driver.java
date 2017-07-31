package framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static WebDriver driver = null;

    public static WebDriver startdriver(String browser){

        if(browser.equalsIgnoreCase("Chrome")){

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\lbushko\\Desktop\\lvivmeblicom\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-web-security");
            options.addArguments("--no-proxy-server");

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service",false);
            prefs.put("profile.password_manager_enabled",false);

            options.setExperimentalOption("prefs",prefs);

            driver = new ChromeDriver(options);

        }else if(browser.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\lbushko\\Desktop\\lvivmeblicom\\chromedriver.exe");

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-web-security");
            options.addArguments("--no-proxy-server");

            driver = new FirefoxDriver(options);

        }

        return driver;
    }
}