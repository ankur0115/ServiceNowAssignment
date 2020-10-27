package StepDefinitions;

import Pages.CheckoutPages;
import Pages.HomePage;
import Utils.TestBase;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


public class purchaseStepDef extends TestBase {

    HomePage homepage;
    CheckoutPages checkoutpages;

    @Given("^User is on the automation practice homepage$")
    public void user_is_on_the_automation_practice_homepage() throws Throwable {
        TestBase.initialization();
    }

    @When("^user enters \"([^\"]*)\" in global search$")
    public void user_enters_in_global_search(String arg1) throws Throwable {
        homepage = new HomePage();
        homepage.searchText(arg1);
        homepage.clickSearchButton();
    }

    @When("^user selects lowest price value from dropdown$")
    public void user_selects_lowest_price_value_from_dropdown() throws Throwable {
        Select selectItem = new Select(driver.findElement(By.id("selectProductSort")));
        Thread.sleep(3000);
        selectItem.selectByIndex(1);
    }

    @When("^user selects the lowest price dress and adds to the cart$")
    public void user_selects_the_lowest_price_dress_and_adds_to_the_cart() throws Throwable {
        homepage = new HomePage();
        homepage.selectListView();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(2000);
        homepage.selectFirstDress();
        homepage.proceedToCheckout();
    }

    @When("^user proceeds to checkout$")
    public void user_proceeds_to_checkout() throws Throwable {
        checkoutpages = new CheckoutPages();
        checkoutpages.selectOverlayCheckout();
        String checkItemsIncart = driver.findElement(By.xpath("//a[@title='View my shopping cart']/span[@class='ajax_cart_quantity']")).getText();
        //Check whether the item was added into your cart
        Assert.assertEquals("1",checkItemsIncart);
    }
    @When("^user enters username and password$")
    public void user_enters_username_and_password() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)","");
        checkoutpages = new CheckoutPages();
        checkoutpages.enterUserName();
        checkoutpages.enterPassword();
        checkoutpages.clickSignIn();
        Thread.sleep(2000);
    }

    @When("^user selects default delivery address$")
    public void user_selects_default_delivery_address() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)","");
        checkoutpages = new CheckoutPages();
        checkoutpages.selectDeliveryAddress();
        Thread.sleep(2000);

    }

    @When("^user proceeds to shipping confirmation$")
    public void user_proceeds_to_shipping_confirmation() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)","");
        checkoutpages = new CheckoutPages();
        checkoutpages.confirmShipping();
        Thread.sleep(2000);
    }

    @When("^user selects payment method and confirms payment$")
    public void user_selects_payment_method_and_confirms_payment() throws Throwable {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)","");
        checkoutpages = new CheckoutPages();
        checkoutpages.selectPaymentMode();
        Thread.sleep(2000);

    }

    @Then("^order gets successfully placed$")
    public void order_gets_successfully_placed() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)","");
        checkoutpages = new CheckoutPages();
        checkoutpages.confirmPayment();

        // Checking that payment was successfully done
        String successMessage = driver.findElement(By.xpath("//p[@class = 'alert alert-success']")).getText();
        Assert.assertEquals("Your order on My Store is complete.",successMessage);
    }
    @Then("^browser is closed$")
    public void browser_is_closed() throws Throwable {
        Thread.sleep(3000);
        driver.quit();
    }

}
