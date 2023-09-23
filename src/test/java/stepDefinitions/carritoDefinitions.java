package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.example.CarritoPage;
import org.example.FavoritoPage;
import org.example.LoginPage;
import org.example.RegisterPage;
import org.testng.Assert;

public class carritoDefinitions {
    private LoginPage lgp;

    private FavoritoPage fgp;
    private CarritoPage cgp;

    public carritoDefinitions() {
        this.lgp = new LoginPage(Hooks.getdriver());
        this.fgp = new FavoritoPage(Hooks.getdriver());
        this.cgp= new CarritoPage(Hooks.getdriver());
    }

    @Dado("que el usuario ha elegido un producto")
    public void queElUsuarioHaElegidoUnProducto() {
        lgp.abrirPagina("https://opencart.abstracta.us/");
        lgp.ingresarLogin();
        lgp.login("juanpabloguingold@hotmail.com","123456789");
        fgp.ingresarCamara();

    }

    @Cuando("el usuario ingresa al producto al carrito")
    public void elUsuarioIngresaAlProductoAlCarrito() {
        cgp.agregarCarrito();
    }

    @Entonces("el usuario puede visualizar los datos del producto en su carrito")
    public void elUsuarioPuedeVisualizarLosDatosDelProductoEnSuCarrito() {
        Assert.assertTrue(cgp.validarLogin());
    }
}