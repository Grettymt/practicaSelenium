package automation;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseTest;
import utilities.Logs;

public class SauceDemoTest extends BaseTest {
    @Test
    public void loginUITest() {
        Logs.info("Nevegando a la página");
        driver.get("https://www.saucedemo.com/");

        final var userNameLocator = By.id("user-name");
        final var passwordLocator = By.id("password");

        //Aserciones con TestNG
        final var softAssert = new SoftAssert();

        Logs.info("Verificando la UI de la página");
        //Validar que sean visibles los elementos
        softAssert.assertTrue(driver.findElement(userNameLocator).isDisplayed());
        softAssert.assertTrue(driver.findElement(passwordLocator).isDisplayed());

        /**
         * Cuando se utiliza una sola vez se puede realizar de esta manera, de lo contrario
         * crear variables constantes --> final var...
         */
        softAssert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void lockedUserTest() {
        Logs.info("Nevegando a la página");
        driver.get("https://www.saucedemo.com/");

        Logs.info("Escribiendo en el username");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");

        Logs.info("Escribiendo en el password");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        Logs.info("Clickeando el botón del login");
        driver.findElement(By.id("login-button")).click();

        final var errorWebElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        final var softAssert = new SoftAssert();

        Logs.info("Verificando el mensaje de error");
        softAssert.assertTrue(errorWebElement.isDisplayed());
        softAssert.assertEquals(errorWebElement.getText(),
                "Epic sadface: Sorry, this user has been locked out.");
        softAssert.assertAll();
    }

    @Test
    public void noExistingCredencialTest() {
        Logs.info("Nevegando a la página");
        driver.get("https://www.saucedemo.com/");

        Logs.info("Escribiendo en el username");
        driver.findElement(By.id("user-name")).sendKeys("user");

        Logs.info("Escribiendo en el password");
        driver.findElement(By.id("password")).sendKeys("password");

        Logs.info("Clickeando el botón del login");
        driver.findElement(By.id("login-button")).click();

        final var errorWebElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        final var softAssert = new SoftAssert();

        Logs.info("Verificando el mensaje de error");
        softAssert.assertTrue(errorWebElement.isDisplayed());
        softAssert.assertEquals(errorWebElement.getText(),
                "Epic sadface: Username and password do not match any user in this service");
        softAssert.assertAll();
    }
}