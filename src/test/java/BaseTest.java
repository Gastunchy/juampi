import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

import java.time.Duration;


public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeTest
    public void Setup(){
        ChromeOptions options  = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.addArguments("--ignore-certificate-errors");


        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(60));

        this.driver.get("https://opencart.abstracta.us/");
    }
   @AfterTest
    public void CerrarPagina(){
        if(this.driver != null){
             this.driver.quit();
            }
     }

}





