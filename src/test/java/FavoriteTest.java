import org.example.FavoritoPage;
import org.example.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoriteTest extends BaseTest{
    @Test
    public void agregarFav(){
        LoginPage lgpage = new LoginPage(driver);
        lgpage.ingresarLogin();
        lgpage.login("juanpabloguingold@hotmail.com","123456789");
        FavoritoPage fpage = new FavoritoPage(driver);
        fpage.ingresarCamara();
        fpage.camaraFavorita();
    }

    @Test
    public void validarFav(){
        Boolean titlePresente = this.wait.until(ExpectedConditions.textToBe(By.xpath("//h2[text()='Account']"),"Account"));
        Assert.assertTrue(titlePresente);



    }

}
