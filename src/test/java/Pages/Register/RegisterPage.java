package Pages.Register;

import ObjectData.RegisterPageObj;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import LoggerUtility.LoggerUtility;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    private WebElement gender;
    @FindBy(id = "FirstName")
    private WebElement firstName;
    @FindBy(id = "LastName")
    private WebElement lastName;
    @FindBy(id = "Email")
    private WebElement email;
    @FindBy(id = "Password")
    private WebElement password;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmpassword;
    @FindBy(id = "register-button")
    private WebElement registerButton;
    @FindBy(xpath = "//div[@class='result' and contains(text(), 'Your registration completed')]")
    private WebElement successRegisterMessage;
    @FindBy(xpath = "//a[contains(@class, 'button-1')]")
    private WebElement continueButton;
    @FindBy(className = "ico-login")
    private WebElement logInButtonHomepage;
    @FindBy(xpath = "//button[contains(@class, 'login-button')]")
    private WebElement loginButton;
    @FindBy(className = "ico-logout")
    private WebElement logoutButton;


    public void fillRegisterForm(RegisterPageObj registerPageObj){
        elementMethods.clickElement(gender);
        LoggerUtility.info("The user ticks the male gender box.");
        elementMethods.fillElement(firstName,registerPageObj.getFirstName());
        LoggerUtility.info("The user fills first name field with value : "+registerPageObj.getFirstName());
        elementMethods.fillElement(lastName,registerPageObj.getLastName());
        LoggerUtility.info("The user fills last name field with value : "+registerPageObj.getLastName());
        elementMethods.fillElement(email,registerPageObj.getEmail());
        LoggerUtility.info("The user fills email field with value :"+registerPageObj.getEmail());
        pageMethods.scrollByPixel(0,200);
        LoggerUtility.info("The user scrolls down the page.");
        elementMethods.fillElement(password,registerPageObj.getPassword());
        LoggerUtility.info("The user fills password field with value :"+registerPageObj.getPassword()+" .");
        elementMethods.fillElement(confirmpassword, registerPageObj.getPassword());
        LoggerUtility.info("The user fills confirm password field with value :"+registerPageObj.getPassword()+" .");
        elementMethods.clickElement(registerButton);
        LoggerUtility.info("The user clicks on Register button.");
        elementMethods.validatePresenceElement(successRegisterMessage);
        LoggerUtility.info("The successful register message has been validated with success.");
        elementMethods.clickElement(continueButton);
        LoggerUtility.info("The user clicks on Continue button.");
    }

    public void logInAccount(RegisterPageObj registerPageObj){
        elementMethods.clickElement(logInButtonHomepage);
        LoggerUtility.info("The user clicks on login button.");
        elementMethods.fillElement(email,registerPageObj.getEmail());
        LoggerUtility.info("The user fills email field with value :"+registerPageObj.getEmail());
        elementMethods.fillElement(password,registerPageObj.getPassword());
        LoggerUtility.info("The user fills password field with value :"+registerPageObj.getPassword()+" .");
        elementMethods.clickElement(loginButton);
        LoggerUtility.info("The user clicks on Log In button.");
    }

    public void logInAccountWithNewCredentials(RegisterPageObj registerPageObj){
        elementMethods.clickJSelement(logInButtonHomepage);
        LoggerUtility.info("The user clicks on login button.");
        elementMethods.fillElement(email,registerPageObj.getNewEmail());
        LoggerUtility.info("The user fills email field with new value.");
        elementMethods.fillElement(password,registerPageObj.getNewPassword());
        LoggerUtility.info("The user fills password field with new value.");
        elementMethods.clickElement(loginButton);
        LoggerUtility.info("The user clicks on Log In button.");
    }
}
