package Pages;

import Utils.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPages extends TestBase {

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']/span[1]")
    WebElement overlayCheckout;

    @FindBy(xpath = "//input[@id='email']")
    WebElement username;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement password;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement loginbutton;

    @FindBy(xpath="//button[@type='submit']/span[contains(text(),'Proceed to checkout')]")
    WebElement deliveryAddress;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement confirmShip;

    @FindBy(xpath = "//button[@type='submit']/span[contains(text(),'Proceed to checkout')]")
    WebElement proceedShipping;

    @FindBy(xpath = "//a[@class='cheque']")
    WebElement pmntMethod;

    @FindBy(xpath = "//button[@type='submit']/span[contains(text(),'I confirm my order')]")
    WebElement pmntConfirm;

    public CheckoutPages() {
        PageFactory.initElements(driver, this);
    }

    public void selectOverlayCheckout()
    {
        overlayCheckout.click();
    }

    public void enterUserName()
    {
        username.sendKeys("zarmanshah@malomiesed.com");
    }
    public void enterPassword()
    {
        password.sendKeys("Testing123");
    }

    public void clickSignIn()
    {
        loginbutton.click();
    }

    public void selectDeliveryAddress()
    {
        deliveryAddress.click();
    }

    public void confirmShipping()
    {
        confirmShip.click();
        proceedShipping.click();
    }

    public void selectPaymentMode()
    {
        pmntMethod.click();
    }

    public void confirmPayment()
    {
        pmntConfirm.click();
    }

}
