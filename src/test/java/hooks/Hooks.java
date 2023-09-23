package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Hooks {

    private static WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp(Scenario scenario){
        ChromeOptions options  = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.addArguments("--ignore-certificate-errors");


        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        //driver.get("https://opencart.abstracta.us/");

    }
    public static WebDriver getdriver() {
        return driver;
    }

    @After
    public void CerrarPagina(){
        if(driver != null){
           driver.quit();
        }
    }


}
