package DemoAutomation;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(JUnitParamsRunner.class)
public class basketTest

    {

    public static WebDriver browser;
    @Before
    public void beforetest()
    {
        WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com");
        Assert.assertEquals("Swag Labs",browser.getTitle() );

        browser.findElement(By.name("user-name")).sendKeys("");
        browser.findElement(By.id("password")).sendKeys("");
        browser.findElement(By.name("login-button")).click();
        Assert.assertEquals("PRODUCTS", browser.findElement(By.className("title")).getText());


    }
    @Test
    @Parameters({

            "Sauce Labs Backpack"
    })
    public void verifyAddtobag(String expectedproductsinbag)
    {
        browser.findElement(By.id("add-to-cart-sauce-Labs-bike-light")).click();
        browser.findElement(By.className("shopping_cart_badge")).click();
        Assert.assertEquals(expectedproductsinbag,browser.findElement(By.className("inventory_details_name large_size")).getText());

    }
    @Test
    @Parameters({

            "Sauce Labs Backpack"
    })
    public void removefrombag(String expectedproductsinbag )
    {
        browser.findElement(By.id("add-to-cart-sauce-Labs-bike-light")).click();
        browser.findElement(By.className("shopping_cart_badge")).click();
        Assert.assertEquals(expectedproductsinbag,browser.findElement(By.className("inventory_details_name large_size")).getText());
        browser.findElement(By.id("remove-sauce-Labs-backpack")).click();
        Assert.assertFalse(browser.findElement(By.className("inventory_details_name large_size")).isDisplayed());



    }
    @After
    public void aftertest()
    {
    browser.quit();

    }
}
