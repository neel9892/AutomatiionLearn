package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonFunction {

    public static WebDriver driver;

    public void openbrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().fullscreen();


    }

    public void closebrowser()
    {
        driver.quit();


    }
}


