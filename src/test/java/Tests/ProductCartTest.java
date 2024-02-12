package Tests;

import ObjectData.ProductCartObj;
import Pages.HomePage;
import Pages.ProductCart.ProductCartPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class ProductCartTest extends Hooks {
    @Test
    public void testMethod(){

        ProductCartObj productCartObj = new ProductCartObj(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.electronicsInterract();

        ProductCartPage productCartPage = new ProductCartPage(getDriver());
        productCartPage.addToCart();
        productCartPage.cartValidation(productCartObj);
        productCartPage.checkoutProducts(productCartObj);
    }
}
