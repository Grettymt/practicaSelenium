package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void masterSetUp() {
        Logs.debug("Inicializando el Driver");
        driver = new ChromeDriver();

        Logs.debug("Maximizando la pantalla");
        driver.manage().window().maximize();

        Logs.debug("Borrando las cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("Aplicando implicit wait");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        new WebDriverProvider().set(driver);
    }

    @AfterMethod
    public void masterTearDown() {
        Logs.debug("Deteniendo el Driver");
        driver.quit();
    }
}