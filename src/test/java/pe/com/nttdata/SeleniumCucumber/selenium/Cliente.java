package pe.com.nttdata.SeleniumCucumber.selenium;

import model.Usuario;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Cliente extends BaseSelenium{
    public void login(Usuario usuario) {
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys(usuario.getUsuario());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(usuario.getPassword());
        driver.findElement(By.cssSelector(".btn")).click();
    }
    public void altaCliente() {
        driver.findElement(By.linkText("Agregar")).click();
        driver.findElement(By.id("nombre")).click();
        driver.findElement(By.id("nombre")).sendKeys("freddy");
        driver.findElement(By.id("apellido")).click();
        driver.findElement(By.id("apellido")).sendKeys("fernandez");
        driver.findElement(By.id("direccion")).click();
        driver.findElement(By.id("direccion")).sendKeys("direccion");
        driver.findElement(By.id("telefono")).click();
        driver.findElement(By.id("telefono")).sendKeys("957490024");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("ffernacu@gmail.com");
        driver.findElement(By.id("pension")).click();
        driver.findElement(By.id("pension")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id("pension")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id("pension")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id("pension")).sendKeys("100000");
        driver.findElement(By.id("fechaNacimiento")).click();
        driver.findElement(By.id("fechaNacimiento")).sendKeys("03111982");
        js.executeScript("window.scrollBy(0,2000)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("pais")).click();
        {
            WebElement dropdown = driver.findElement(By.id("pais"));
            dropdown.findElement(By.xpath("//option[. = 'Argentina']")).click();
        }
        driver.findElement(By.id("tipoSeguro")).click();
        {
            WebElement dropdown = driver.findElement(By.id("tipoSeguro"));
            dropdown.findElement(By.xpath("//option[. = 'Rimac']")).click();
        }
        driver.findElement(By.cssSelector(".btn")).click();
    }
    public void modificarCliente() {
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.linkText("Editar")).click();
        js.executeScript("window.scrollBy(0,2000)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("pais")).click();
        {
            WebElement dropdown = driver.findElement(By.id("pais"));
            dropdown.findElement(By.xpath("//option[. = 'Brasil']")).click();
        }
        driver.findElement(By.id("tipoSeguro")).click();
        {
            WebElement dropdown = driver.findElement(By.id("tipoSeguro"));
            dropdown.findElement(By.xpath("//option[. = 'La Positiva']")).click();
        }
        driver.findElement(By.cssSelector(".btn")).click();
    }
    public boolean validarAltaModificarCliente() {
        String text = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success alert-dismissable fade show')]/strong")).getText();
        System.out.println("El valor es: " + text);
        if (text.equals("Cliente guardado con éxito!"))
            return true;
        else
            return false;
    }

    public void eliminarCliente() {
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.linkText("Eliminar")).click();
    }

    public boolean validarEliminarCliente() {
        String text = driver.findElement(By.xpath("//div[contains(@class,'alert alert-warning alert-dismissable fade show')]/strong")).getText();
        System.out.println("El valor es: " + text);
        if(text.equals("Cliente eliminado con éxito!"))
            return true;
        else
            return false;
    }


}
