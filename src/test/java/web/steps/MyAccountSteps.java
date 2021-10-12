package web.steps;

import net.thucydides.core.annotations.Step;
import org.testng.Assert;
import web.FieldValues;
import web.InputFields;
import web.pages.MyAccountPage;

public class MyAccountSteps {
    MyAccountPage my_account;

    @Step
    public void open_my_account(){
        my_account.my_account_button1.waitUntilClickable();
        my_account.my_account_button1.click();
        my_account.my_account_button2.waitUntilClickable();
        my_account.my_account_button2.click();
    }
    @Step
    public void complete_first_name(String first_name){
        my_account.get_value_field_by_label(FieldValues.FIRST_NAME).click();
        my_account.correct_first_name.clear();//uneori clear merge doar pentru webelementfacade:(
        my_account.get_input_field_by_label(InputFields.FIRST_NAME).sendKeys(first_name);

    }
    @Step
    public void complete_last_name(String last_name) {
        my_account.get_value_field_by_label(FieldValues.LAST_NAME).click();
        my_account.correct_last_name.clear();
        my_account.get_input_field_by_label(InputFields.LAST_NAME).sendKeys(last_name);
    }
    @Step
    public void complete_phone(String phone_number) {
        my_account.phone_value.click();
        my_account.correct_phone_number.clear();
        my_account.get_input_field_by_label(InputFields.PHONE).sendKeys(phone_number);
    }

    @Step
    public void verify_invalid_first_name_message(){
        Assert.assertEquals(my_account.invalid_first_name_message.get(0).getText(),"invalid field value");
    }

    @Step
    public void verify_invalid_first_name_message_not_displayed(){
        Assert.assertEquals(my_account.invalid_first_name_message.size(),0);
    }

    @Step
    public void verify_invalid_last_name_message(){
        Assert.assertEquals(my_account.invalid_last_name_message.get(0).getText(),"invalid field value");
    }
    @Step
    public void verify_invalid_last_name_message_not_displayed(){
        Assert.assertEquals(my_account.invalid_last_name_message.size(),0);
    }

    @Step
    public void verify_invalid_phone_number_message(){
        Assert.assertEquals(my_account.invalid_phone_number_message.get(0).getText(),"Please enter a valid phone number!");
    }

    @Step
    public void verify_invalid_phone_number_message_not_displayed(){
        Assert.assertEquals(my_account.invalid_phone_number_message.size(),0);
    }

    @Step
    public void exit_my_account(){
        my_account.exit_my_account.waitUntilVisible();
        my_account.exit_my_account.click();
    }

    @Step
    public void verify_first_name(String expected){
        Assert.assertEquals(my_account.get_value_field_by_label(FieldValues.FIRST_NAME).getText(),expected);
    }

    @Step
    public void verify_last_name(String expected){
        Assert.assertEquals(my_account.get_value_field_by_label(FieldValues.LAST_NAME).getText(),expected);
    }

    @Step
    public void verify_phone_number(String expected){
        Assert.assertEquals(my_account.phone_value.getText(),expected);
    }


}
