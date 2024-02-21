package Pages.Search;
import LoggerUtility.LoggerUtility;
import ObjectData.SearchObj;
import Pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".item-grid")
    private List<WebElement> productsTable;

    @FindBy(css = ".item-box")
    private WebElement productElement;

    @FindBy(xpath = "//h2/a[contains(text(),'5.0 Lollipop')]")

    private WebElement product1;

    @FindBy(xpath = "//h2/a[contains(text(),'Mini Blue')]")
    private WebElement product2;

    @FindBy(xpath = "//h2/a[contains(text(),'Lumia 1020')]")
    private WebElement product3;

    @FindBy(xpath = "//h1[contains(text(),'5.0 Lollipop')]")
    private WebElement product1Name;

    @FindBy(id = "main-product-img-18")
    private WebElement product1image;

    @FindBy(xpath = "//h1[contains(text(),'Mini Blue')]")
    private WebElement product2Name;

    @FindBy(id = "main-product-img-19")
    private WebElement product2image;

    @FindBy(xpath = "//h1[contains(text(),'Lumia 1020')]")
    private WebElement product3Name;

    @FindBy(id = "main-product-img-20")
    private WebElement product3image;

    @FindBy(id = "small-searchterms")
    private WebElement searchBox;

    @FindBy(xpath = "//span[contains(text(),'5.0 Lollipop')]")
    private WebElement firstSearchResult;

    @FindBy(xpath = "//h1[contains(text(),'5.0 Lollipop')]")
    private WebElement firstSearchResultTitle;

    @FindBy(id = "isc")
    private WebElement checkboxAutomaticallySearchSubCategory;
    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(css = "div[class='warning']")
    private WebElement warningSearch;

    @FindBy(id = "q")
    private WebElement deleteSearch;

    @FindBy(id = "advs")
    private WebElement advancedSearchBox;

    @FindBy(id = "cid")
    private WebElement categoryDropDown;

    @FindBy(xpath = "//button[contains(@class, 'search-button')]")
    private WebElement advancedSearchButton;

    @FindBy(css = "div[class='no-result']")
    private WebElement noProductFoundMessage;

    public void validateSearchesSuggestions(SearchObj searchObj) {
        elementMethods.clickElement(searchBox);
        LoggerUtility.info("The user is clicking on search box.");
        elementMethods.fillElement(searchBox, searchObj.getSearchBoxInput(), firstSearchResult);
        LoggerUtility.info("The user enters the value: " + searchObj.getSearchBoxInput() + " then clicks on the first result of the suggestions.");
        elementMethods.validateMessage(firstSearchResultTitle, searchObj.getProduct1Name());
        LoggerUtility.info("The user product's title has been validated.");
        pageMethods.clickBack();
        LoggerUtility.info("The user returns to previous page.");
    }

    public void searchBox(SearchObj searchObj) {
        elementMethods.clickElement(searchBox);
        LoggerUtility.info("The user is clicking on search box.");
        elementMethods.fillElement(searchBox, searchObj.getSearchBoxInput(), Keys.ENTER);
        LoggerUtility.info("The user enters the value: " + searchObj.getSearchBoxInput() + " then presses ENTER.");
    }

    public void validateSearches() {
        elementMethods.validateTable(".product-grid .item-box", 3);
        LoggerUtility.info("The results of search have been validated with success.");
    }

    public void selectProduct1() {
        elementMethods.clickElement(product1);
        LoggerUtility.info("The user clicks on the first product of the results.");
    }

    public void validateProduct1(SearchObj searchObject) {
        elementMethods.validateMessage(product1Name, searchObject.getProduct1Name());
        LoggerUtility.info("The product's name has been validated with success.");
        elementMethods.validatePresenceElement(product1image);
        LoggerUtility.info("The image of this product has been validated with success.");
        pageMethods.clickBack();
        LoggerUtility.info("The user returns to previous page.");
    }

    public void selectProduct2() {
        elementMethods.clickElement(product2);
        LoggerUtility.info("The user clicks on the second product of the results.");
    }

    public void validateProduct2(SearchObj searchObject) {
        elementMethods.validateMessage(product2Name, searchObject.getProduct2Name());
        LoggerUtility.info("The product's name has been validated with success.");
        elementMethods.validatePresenceElement(product2image);
        LoggerUtility.info("The image of this product has been validated with success.");
        pageMethods.clickBack();
        LoggerUtility.info("The user returns to previous page.");
    }

    public void selectProduct3() {
        elementMethods.clickElement(product3);
        LoggerUtility.info("The user clicks on the third product of the results.");
    }

    public void validateProduct3(SearchObj searchObj) {
        elementMethods.validateMessage(product3Name, searchObj.getProduct3Name());
        LoggerUtility.info("The product's name has been validated with success.");
        elementMethods.validatePresenceElement(product3image);
        LoggerUtility.info("The image of this product has been validated with success.");
        pageMethods.clickBack();
        LoggerUtility.info("The user returns to previous page.");
    }

    public void accessURL(SearchObj searchObject) {
        pageMethods.accessUrl(searchObject.getUrl());
        LoggerUtility.info("The user accesses following URL: " + searchObject.getUrl() + " .");
    }

    public void validateEmptySearch(SearchObj searchObject) {
        elementMethods.clickElement(searchButton);
        LoggerUtility.info("The user is clicking on search button.");
        Alert alert = driver.switchTo().alert();
        LoggerUtility.info("The focus is changed on alert.");
        String alertTextValue = alert.getText();
        Assert.assertEquals(alertTextValue, searchObject.getSearchAlertValue());
        LoggerUtility.info("The alert text has been validated with success.");
        alert.accept();
        LoggerUtility.info("The user clicks on OK to accept alert.");
        driver.switchTo().defaultContent();
        LoggerUtility.info("The focus is changed on base context of the page.");
    }

    public void validateInvalidSearch(SearchObj searchObj) {
        elementMethods.clickElement(searchBox);
        LoggerUtility.info("The user is clicking on search box.");
        elementMethods.fillElement(searchBox, searchObj.getInvalidSearch(), Keys.ENTER);
        LoggerUtility.info("The user enters invalid search, then presses ENTER.");
        Assert.assertTrue(warningSearch.isDisplayed(), "The warning message is not displayed.");
        LoggerUtility.info("The search warning is displayed and validated with success. ");
    }

    public void deleteSearch(SearchObj searchObj) {
        elementMethods.deleteContextElement(deleteSearch);
        LoggerUtility.info("The user is deleting search input.");
    }

    public void validateAdvancedSearch(SearchObj searchObj) {
        elementMethods.fillElement(deleteSearch, searchObj.getSearchBoxInput());
        LoggerUtility.info("The user fills search field with value:" + searchObj.getSearchBoxInput() + " .");
        elementMethods.clickElement(advancedSearchBox);
        LoggerUtility.info("The user ticks the advanced search box.");
        elementMethods.dropDownInterract(categoryDropDown, 4);
        LoggerUtility.info("The user clicks on the fourth result of category dropdown.");
        elementMethods.clickElement(checkboxAutomaticallySearchSubCategory);
        LoggerUtility.info("The user ticks the automatically search subcategory box.");
        elementMethods.clickElement(advancedSearchButton);
        LoggerUtility.info("The user clicks on search button.");
        elementMethods.validatePresenceElement(noProductFoundMessage);
        LoggerUtility.info("The message shown has been validated: " + searchObj.getNoProductFoundMessage());
    }
}
