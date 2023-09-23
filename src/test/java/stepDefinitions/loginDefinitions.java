package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.example.LoginPage;
import org.testng.Assert;


public class loginDefinitions {

    private LoginPage lgp;
    public loginDefinitions(){
        this.lgp = new LoginPage(Hooks.getdriver());
    }

    @Dado("que el usuario ingresa al login")
    public void queElUsuarioIngresaAlLogin(){
        lgp.abrirPagina("https://opencart.abstracta.us/");
        lgp.ingresarLogin();
    }

    @Cuando("el usuario ingresa un mail y una password Correcta y pulsa el boton Login")
    public void elUsuarioIngresaUnMailYUnaPasswordCorrectaYPulsaElBotonLogin() {
        lgp.login("juanpabloguingold@hotmail.com","123456789");

    }

    @Entonces("el usuario puede visualizar los datos de su cuenta")
    public void elUsuarioPuedeVisualizarLosDatosDeSuCuenta() {
        Assert.assertTrue(lgp.validarLogin());

    }
}
