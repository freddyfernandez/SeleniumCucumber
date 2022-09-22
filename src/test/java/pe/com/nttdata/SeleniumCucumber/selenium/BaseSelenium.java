package pe.com.nttdata.SeleniumCucumber.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseSelenium {

    public static WebDriver driver;
    public static Map<String, Object> vars;
    public static JavascriptExecutor js;

    public void setUp() throws MalformedURLException {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        driver.get("https://christophermen2.herokuapp.com/");
        driver.manage().window().maximize();
    }

    public void tearDown() {
        driver.quit();
    }

}