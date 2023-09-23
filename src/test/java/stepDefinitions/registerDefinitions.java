package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.example.LoginPage;
import org.example.RegisterPage;
import org.testng.Assert;

public class registerDefinitions {
    private LoginPage lgp;
    private RegisterPage rgp;

    public registerDefinitions(){
        this.lgp = new LoginPage(Hooks.getdriver());
        this.rgp = new RegisterPage(Hooks.getdriver());
    }

       @Dado("el usuario ingresa a la pagina web")
        public void elUsuarioIngresaALaPaginaWeb() {
           lgp.abrirPagina("https://opencart.abstracta.us/");
        }

        @Dado("aprieta el boton My Account")
        public void aprietaElBotonMyAccount() {
             rgp.ingresarRegister();
        }

        @Cuando("el usuario ingresa datos de registro correctamente")
        public void elUsuarioIngresaDatosDeRegistroCorrectamente() {
            rgp.register("Juan","Guingold","juanpabloguingold@gmail.com.pe","3541697697",
                    "1234567890","1234567890");
        }

        @Entonces("el usuario puede visualizar los datos de su cuenta creada")
        public void elUsuarioPuedeVisualizarLosDatosDeSuCuentaCreada() {
            Assert.assertTrue(rgp.validarLogin());
        }
}

