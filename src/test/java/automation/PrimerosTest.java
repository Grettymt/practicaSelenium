package automation;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.BaseTest;
import utilities.Logs;

public class PrimerosTest extends BaseTest {
    @BeforeMethod
    public void setUp() {
        System.out.println("Precondición del test");
    }

    @Test
    public void primerTest(){
        Logs.info("Navegar a la página");
        driver.get("https://www.saucedemo.com/");

        final var url = driver.getCurrentUrl();

        Logs.info("Verificando la URL");
        Assert.assertEquals(url, "https://www.saucedemo.com/");

        /**
         * Hard Asserts de TestNG: Sirven para verificar condiciones
         */
        /**
        Assert.assertTrue(3 > 0);
        Assert.assertEquals(3,3);
        */

        /**
         * Hard Asserts de TestNG en bloque
         */
        /**
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(3 > 0);
        softAssert.assertEquals(5, 5);
        softAssert.assertAll(); //Verifica bloques anteriores
         */
    }

    @Test
    public void segundoTest(){
        Logs.info("Navegar a Internet heroku app");
        driver.get("https://the-internet.herokuapp.com/");

        Logs.info("Navegar a GitHub");
        driver.get("https://github.com/");

        Logs.info("Regresando a la página anterior");
        driver.navigate().back();

        final var url = driver.getCurrentUrl();

        Logs.info("Verificando la URL");
        Assert.assertEquals(url, "https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Postcondición del test");
    }
}