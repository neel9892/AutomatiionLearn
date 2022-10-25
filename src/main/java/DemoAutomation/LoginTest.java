package DemoAutomation;

import com.beust.ah.A;
import com.beust.jcommander.Parameter;
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
public class LoginTest {

    public static WebDriver browser;

    @Before
    public void beforeTest()
    {
        WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com");
        Assert.assertEquals("Swag Labs", browser.getTitle());

    }

    @Test
    @Parameters({
            "standard_user, secret_sauce, PRODUCTS"
    })


    public void varifywithvaliddata(String validusername, String validpassword,
                                    String expectedHomeProductPageHeading) {


        browser.findElement(By.name("user-name")).sendKeys(validusername);
        browser.findElement(By.id("password")).sendKeys((validpassword));


        browser.findElement(By.name("login-button")).click();
        Assert.assertEquals(expectedHomeProductPageHeading, browser.findElement(By.className("title")).getText());

        browser.quit();

    }

    @Test
    @Parameters({
            "standard_userdiv, secret_saucediv,Epic sadface: Username and password do not match any user in this service"
    })


    public void verifywithinvaliddata(String invalidusername, String invalispassword,
                                      String expectedfailedloginmsg) {


        browser.findElement(By.id("user-name")).sendKeys(invalidusername);
        browser.findElement(By.name("password")).sendKeys(invalispassword);

        browser.findElement(By.id("login-button")).click();
        Assert.assertEquals(expectedfailedloginmsg, browser.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText());

        browser.quit();


    }

    @Test
    @Parameters({
            "Epic sadface: Username is required"
    })
    public void verifywithnodata(String expectedfailedloginmsg) {


        browser.findElement(By.id("login-button")).click();
        Assert.assertEquals(expectedfailedloginmsg, browser.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText());


        browser.quit();
    }

    @After
    public void afterTest()
    {
        browser.quit();
    }

}
