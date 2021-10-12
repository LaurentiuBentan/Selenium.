package web.steps;

import net.thucydides.core.annotations.Step;
import web.pages.ForgotPasswordPage;

//tema, fara open
public class ForgotPasswordSteps {

    ForgotPasswordPage forgot_pass;

    @Step
    public void complete_email_input(String email){
        forgot_pass.email_input.waitUntilVisible();
        forgot_pass.email_input.clear();
        forgot_pass.email_input.sendKeys(email);
    }

    @Step
    public void click_send_email_button() {
        forgot_pass.send_email_button.waitUntilClickable();
        forgot_pass.send_email_button.click();
    }

    @Step
    public void click_back_to_login_button() {
        forgot_pass.back_to_login_button.waitUntilClickable();
        forgot_pass.back_to_login_button.click();
    }

    @Step
    public void click_sign_up_button() {
        forgot_pass.sign_up_button.waitUntilClickable();
        forgot_pass.sign_up_button.click();
    }
}
