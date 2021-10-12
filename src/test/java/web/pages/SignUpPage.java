package web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

//tema
public class SignUpPage extends PageObject {

    @FindBy(xpath = "//button[@data-test-id='go-to-login-btn']")
    public WebElementFacade log_in_button;

    @FindBy(xpath = "//input[@value='business']")
    public WebElementFacade business_button;

    @FindBy(xpath = "//input[@value='personal']")
    public WebElementFacade personal_button;

    @FindBy(xpath = "//span[text()='CONTINUE']")
    public WebElementFacade continue_button;
}
