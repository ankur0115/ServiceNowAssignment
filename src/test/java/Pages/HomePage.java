package Pages;

import Utils.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    //Finding elements on the page
    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement globalSearch;

    @FindBy(xpath = "//button[@name='submit_search']")
    WebElement searchButton;

    @FindBy(xpath = "//i[@class='icon-th-list']")
    WebElement selectList;

    @FindBy(xpath = "//li[@class='ajax_block_product first-in-line first-item-of-tablet-line first-item-of-mobile-line col-xs-12']//a[@class='button ajax_add_to_cart_button btn btn-default']/span")
    WebElement firstItem;

    @FindBy(xpath = "//a[@title = 'Proceed to checkout']")
    WebElement proceedToNext;

    //Initializing Page objects
    public HomePage()
    {
        PageFactory.initElements(driver, this);
    }

    public void searchText(String arg1)
    {
        globalSearch.sendKeys(arg1);
    }

    public void clickSearchButton()
    {
        searchButton.click();
    }

    public void selectListView()
    {
        selectList.click();
    }

    public void selectFirstDress()
    {
        firstItem.click();
    }

    public void proceedToCheckout()
    {
        proceedToNext.click();
    }
}
