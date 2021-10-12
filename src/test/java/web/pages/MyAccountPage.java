package web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.FieldValues;
import web.InputFields;

import java.util.List;

public class MyAccountPage extends PageObject {

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElementFacade my_account_button2;

    @FindBy(xpath = "//*[@d='M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v1c0 .55.45 1 1 1h14c.55 0 1-.45 1-1v-1c0-2.66-5.33-4-8-4z']")
    public WebElementFacade my_account_button1;

    @FindBy(xpath = "//span[text()='Account Info']")
    public WebElementFacade account_info_button;

    @FindBy(xpath = "//span[text()='Subscription']")
    public WebElementFacade subscription_button;

    @FindBy(xpath = "//*[@data-test-id='inline-save-field-button']")
    public WebElementFacade save_input;

    @FindBy(xpath = "//*[@data-test-id='inline-revert-field-button']")
    public WebElementFacade exit_input;

    @FindBy(xpath = "(//span[text()='Phone #']/parent::div/following-sibling::div//span)[2]")
    public WebElementFacade phone_value;

    @FindBy(xpath = "//*[@data-test-id='inline-action-field-button']")
    public WebElementFacade call_button;

    @FindBy(xpath = "//p[text()='invalid field value']")
    public List<WebElementFacade> invalid_first_name_message;

    @FindBy(xpath = "//label[text()='Last Name']/parent::div//p")
    public List<WebElementFacade> invalid_last_name_message;

    @FindBy(xpath = "//label[text()='Phone #']/parent::div//p")
    public List<WebElementFacade> invalid_phone_number_message;

    @FindBy(xpath = "//div[@data-test-id='account-contextual-panel-close-button']/button")
    public WebElementFacade exit_my_account;

    @FindBy(xpath = "//label[text()='First Name']/parent::div//input")
    public WebElementFacade correct_first_name;

    @FindBy(xpath = "//label[text()='Last Name']/parent::div//input")
    public WebElementFacade correct_last_name;

    @FindBy(xpath = "//label[text()='Phone #']/parent::div//input")
    public WebElementFacade correct_phone_number;

    //cand sunt prea multe lasam string nu mai facem enum
    public WebElement
    get_input_field_by_label(InputFields label) {
        getDriver().findElement(By.xpath("//label[text()='"+label+"']/parent::div//input")).clear();
        return getDriver().findElement(By.xpath("//label[text()='"+label+"']/parent::div//input"));
    }

    public WebElement get_value_field_by_label(FieldValues label){
        return getDriver().findElement(By.xpath("//span[text()='"+label+"']/parent::div/following-sibling::div//span"));
    }





}
