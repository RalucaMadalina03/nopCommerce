package Pages.Register.MyAccount;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProductReviewPage extends BasePage {
    public MyProductReviewsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='no-data']")
    private WebElement noReviewsMessage;

    public void validateNoReviewsMessage(){
        elementMethods.validateMessage(noReviewsMessage,"You haven't written any reviews yet");
        LoggerUtility.info("The no reviews message has been validated with success.");
    }

}
