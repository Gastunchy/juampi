import org.example.CarritoPage;
import org.example.FavoritoPage;
import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarritoTest extends BaseTest {

    @Test
    public void agregarCarrito() {
        LoginPage lgpage = new LoginPage(driver);
        lgpage.ingresarLogin();
        lgpage.login("juanpabloguingold@hotmail.com","123456789");
        FavoritoPage fpage = new FavoritoPage(driver);
        fpage.ingresarCamara();
        CarritoPage cpage= new CarritoPage(driver);
        cpage.agregarCarrito();
    }
    @Test
    public void validarCarrito(){
        Boolean titlePresente = this.wait.until(ExpectedConditions.textToBe(By.xpath("//h2[text()='What would you like to do next?']"),"What would you like to do next?"));
        Assert.assertTrue(titlePresente);

        WebElement camaraPresente = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div[2]/div/div/form/div/table/tbody/tr/td[1]/a/img")));
        Assert.assertTrue(camaraPresente.isDisplayed());
    }
}