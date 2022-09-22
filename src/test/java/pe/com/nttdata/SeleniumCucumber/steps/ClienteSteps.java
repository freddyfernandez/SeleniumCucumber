package pe.com.nttdata.SeleniumCucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Usuario;
import org.junit.Assert;
import pe.com.nttdata.SeleniumCucumber.selenium.BaseSelenium;
import pe.com.nttdata.SeleniumCucumber.selenium.Cliente;
import pe.com.nttdata.SeleniumCucumber.util.PropertyLoader;

public class ClienteSteps {
    PropertyLoader loadproperty = new PropertyLoader();
    Usuario usuario;

    @Given("soy un usuario")
    public void paso1() {
        usuario = new Usuario(loadproperty.loadProperties().getProperty("loginUsuario"), loadproperty.loadProperties().getProperty("passwordUsuario"));
    }

    @And("ingreso a la aplicacion")
    public void paso2() {
        BaseSelenium baseSelenium = new BaseSelenium();
        try {
            baseSelenium.setUp();
            Cliente login = new Cliente();
            login.login(usuario);
        } catch (Exception e) {
            System.out.println("Error connecting to Selenium Service. Error :" + e.getMessage());
        }
    }
    @When("damos de alta un cliente")
    public void paso3() {
        Cliente cliente = new Cliente();
        cliente.altaCliente();
    }
    @Then("el alta es exitosa")
    public void paso4() {
        Cliente cliente = new Cliente();
        Assert.assertTrue(cliente.validarAltaModificarCliente());
    }
    @When("modificamos un cliente")
    public void paso5() {
        Cliente cliente = new Cliente();
        cliente.modificarCliente();
    }
    @Then("la modificacion es exitosa")
    public void paso6() {
        Cliente cliente = new Cliente();
        Assert.assertTrue(cliente.validarAltaModificarCliente());
    }
    @When("eliminamos un cliente")
    public void paso7() {
        Cliente cliente = new Cliente();
        cliente.eliminarCliente();
    }
    @Then("la eliminacion es exitosa")
    public void paso8() {
        Cliente cliente = new Cliente();
        Assert.assertTrue(cliente.validarEliminarCliente());
    }
    @After
    public void close() {
        BaseSelenium baseSelenium = new BaseSelenium();
        baseSelenium.tearDown();
    }
}
