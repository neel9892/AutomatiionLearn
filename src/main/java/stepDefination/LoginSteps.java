package stepDefination;

import functionLibrary.CommonFunction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;

public class LoginSteps  extends  CommonFunction {

    LoginPage loginpage= new LoginPage(driver);


    @Given("i am on home page {string} with title  {string}")
    public void openHomepage(String url ,String expectedHomepagetitle)
    {

        driver.get(url);
        Assert.assertEquals(expectedHomepagetitle,driver.getTitle());
    }

    @When("i enter username {string} and password {string}")
    public void enterusernameandpassword(String username, String password)
    {
        loginpage.enterusername(username);
        loginpage.enterpassword(password);

    }




    @When("i click on login button")
    public void clickloginbutton()
    {
      loginpage.clickloginbtn();
    }
    @Then("i should get re-directed to products page with Heading {string}")
    public void verifysuccessfulLogin(String expectedpageheading)
    {
        Assert.assertEquals(expectedpageheading,driver.findElement(By.className("title")).getText());

    }
    @Then("i should not be allowed login instead {string}")
    public void verifyunsuccessfulLoginInvalid(String expectedvalidationmsg)
    {
       loginpage.verifyinvalidlogin(expectedvalidationmsg);

    }


}
