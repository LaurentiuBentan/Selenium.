package web.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import web.pages.SignInPage;

public class SignInSteps {
    //ne initializam un obiect de tip sign-in page
    SignInPage sign_in;

    //descriem cei mai mici pasi ce poate sa ii faca un utilizator pe pagina cu acelasi nume
    @Step
    public void open_sign_in_page(){
        sign_in.open();//deschidem pagina de sign-in
    }

    @Step
    public void complete_email_input(String email){
        sign_in.email_input.waitUntilVisible();
        sign_in.email_input.clear();
        sign_in.email_input.sendKeys(email);
    }

    @Step
    public void complete_pass_input(String pass){
        sign_in.pass_input.waitUntilVisible();
        sign_in.pass_input.clear();
        sign_in.pass_input.sendKeys(pass);
    }

    @Step
    public void click_log_in_button(){
        sign_in.log_in_button.waitUntilClickable();
        sign_in.log_in_button.click();
    }

    @Step
    public void verify_invalid_email_error_displayed(){
        Assert.assertEquals(sign_in.invalid_email_error.getText(),"Please enter a valid email address!");
    }

    @Step
    public void verify_invalid_credentials_error_displayed(){
        Assert.assertEquals(sign_in.invalid_credentials_error.getText(),"Invalid email/password combination");
    }

    @Step
    public void click_sign_up_link(){
        sign_in.sign_up_link.waitUntilClickable();
        sign_in.sign_up_link.click();
    }

    @Step
    public void click_forgot_password_link(){
        sign_in.forgot_password_link.waitUntilClickable();
        sign_in.forgot_password_link.click();
    }



}
