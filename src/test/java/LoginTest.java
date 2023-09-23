import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

@Test
    public void loginCorrecto(){
    LoginPage lgpage = new LoginPage(driver);
    lgpage.abrirPagina("https://opencart.abstracta.us/");
    lgpage.ingresarLogin();
    lgpage.login("juanpabloguingold@hotmail.com","123456789");

}
@Test
public void validarLogin(){

    Boolean titlePresente = this.wait.until(ExpectedConditions.textToBe(By.xpath("  //h2[text()='My Account']"),"My Account"));
    Assert.assertTrue(titlePresente);
}

}
