package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.example.FavoritoPage;
import org.example.LoginPage;
import org.testng.Assert;

public class favoritoDefinitions {
    private LoginPage lgp;

    private FavoritoPage fgp;
    public favoritoDefinitions(){
        this.lgp = new LoginPage(Hooks.getdriver());
        this.fgp = new FavoritoPage(Hooks.getdriver());
    }



    @Dado("que el usuario ha elegido un producto como favorito")
    public void queElUsuarioHaElegidoUnProductoComoFavorito() {
        lgp.abrirPagina("https://opencart.abstracta.us/");
        lgp.ingresarLogin();
        lgp.login("juanpabloguingold@hotmail.com","123456789");
        fgp.ingresarCamara();

    }


    @Cuando("el usuario ingresa al producto a favoritos")
    public void elUsuarioIngresaAlProductoAFavoritos() {
        fgp.camaraFavorita();
    }

    @Entonces("el usuario visualiza su producto en favoritos")
    public void elUsuarioVisualizaSuProductoEnFavoritos() {
        Assert.assertTrue(fgp.validarLogin());
    }
}
