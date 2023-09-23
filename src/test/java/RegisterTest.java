import org.example.LoginPage;
import org.example.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void ingresarRegister(){
        RegisterPage rpage = new RegisterPage(driver);
        LoginPage lgpage = new LoginPage(driver);

        lgpage.abrirPagina("https://opencart.abstracta.us/");
        rpage.ingresarRegister();
    }
    @Test
    public void register(){
        RegisterPage rpage = new RegisterPage(driver);
        LoginPage lgpage = new LoginPage(driver);
        rpage.register("Juan","Guingold","juanpabloguingold@gmail.com.ar","3541697697",
                "1234567890","1234567890");

    }
    @Test
    public void validarRegister(){
        Boolean titlePresente = this.wait.until(ExpectedConditions.textToBe(By.xpath("  //h1[text()='Account']"),"Account"));
        Assert.assertTrue(titlePresente);
    }
}
