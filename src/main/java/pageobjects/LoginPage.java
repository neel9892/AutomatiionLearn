package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver)
    {

        PageFactory.initElements(driver,this);
    }


    @FindBy(id="user-name")
    public WebElement  usernametxtfld;

    @FindBy(name = "password")
    public  WebElement passwordtxtfld;

    @FindBy(id="login-button")
    public WebElement loginbtn;

    @FindBy(xpath="//h3[@data-test='error']")
    public WebElement validationlgnmsgarea;

    public void verifyloginpagelanding(String expectedtitletext)
    {


    }

    public void enterusername(String usernameval)
    {
        usernametxtfld.sendKeys(usernameval);

    }
    public void enterpassword(String passwordval)
    {
        passwordtxtfld.sendKeys(passwordval);

    }
    public void clickloginbtn()
    {
        loginbtn.click();

    }
    public void verifyinvalidlogin(String validationmsg)
    {

        Assert.assertEquals(validationmsg,validationlgnmsgarea.getText());
    }
}
