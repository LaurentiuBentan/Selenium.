package web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

//tema
public class ForgotPasswordPage extends PageObject {

    @FindBy(xpath = "//input[@placeholder='Enter your email']")
    public WebElementFacade email_input;

    @FindBy(xpath = "//p[text()='Please enter a valid email address!']")
    public WebElementFacade invalid_email_error;

    @FindBy(xpath = "//a[@data-test-id='sign-in-link']")
    public WebElementFacade back_to_login_button;

    @FindBy(xpath = "//a[@data-test-id='sign-up-link']")
    public WebElementFacade sign_up_button;

    @FindBy(xpath = "//span[text()='Send email']")
    public WebElementFacade send_email_button;

}
