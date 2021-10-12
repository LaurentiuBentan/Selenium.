package web.steps;

import net.thucydides.core.annotations.Step;
import web.pages.SignUpPage;

//tema fara open
public class SignUpSteps {
    //sing up page se importa cu alt+enter
    SignUpPage sign_up;
    @Step
    public void click_business_button(){
        sign_up.business_button.waitUntilClickable();
        sign_up.business_button.click();
    }

    @Step
    public void click_personal_button() {
        sign_up.personal_button.waitUntilClickable();
        sign_up.personal_button.click();
    }

    @Step
    public void click_log_in_button() {
        sign_up.log_in_button.waitUntilClickable();
        sign_up.log_in_button.click();
    }

    @Step
    public void click_continue_button() {
        sign_up.continue_button.waitUntilClickable();
        sign_up.continue_button.click();
    }
}
