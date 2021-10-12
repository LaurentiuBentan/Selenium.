package web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class SignInPage extends PageObject { //extends ne ajuta sa mostenim toate metodele din clasa page object
    //page object model = un model de a structura cadrul de lucru
    //fiecare pagina din aplicatia web va avea clasa separata in care punem elementele

    //identificam elementele
    @FindBy(xpath = "//span[text()='Log in']")
    public WebElementFacade log_in_button;

    @FindBy(xpath = "//input[@placeholder='Enter your email']")
    public WebElementFacade email_input;

    @FindBy(xpath = "//input[@placeholder='Enter your password']")
    public WebElementFacade pass_input;

    @FindBy(xpath = "//span[text()='Invalid email/password combination']")
    public WebElementFacade invalid_credentials_error;

    @FindBy(xpath = "//p[text()='Please enter a valid email address!']")
    public WebElementFacade invalid_email_error;

    @FindBy(xpath = "//a[@data-test-id='sign-up-link']")
    public WebElementFacade sign_up_link;

    @FindBy(xpath = "//a[text()='Forgot password?']")
    public WebElementFacade forgot_password_link;


}
