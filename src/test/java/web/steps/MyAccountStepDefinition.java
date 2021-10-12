package web.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MyAccountStepDefinition {
    @Steps
    MyAccountSteps steps;

    @When("my account: i get in my account")
    public void open_my_account(){
        steps.my_account.my_account_button1.waitUntilVisible();
        steps.my_account.my_account_button1.click();
        steps.my_account.my_account_button2.waitUntilVisible();
        steps.my_account.my_account_button2.click();
    }

    @When("my account: i provide first name (.*)$")
    public void first_name(String first_name){
        steps.complete_first_name(first_name);
    }

    @When("my account: i provide last name (.*)$")
    public void last_name(String last_name){
        steps.complete_last_name(last_name);
    }

    @When("my account: i provide phone number (.*)$")
    public void phone_number(String phone_number){
        steps.complete_phone(phone_number);
    }

    @Then("my account: i verify all invalid messages")
    public void verify_invalid_message(){
        steps.verify_invalid_first_name_message();
        steps.verify_invalid_last_name_message();
        steps.verify_invalid_phone_number_message();}

    @When("my account: i try with valid information")
    public void valid_credentials(){
        steps.complete_first_name("Laurentiu");
        steps.my_account.save_input.click();
        steps.complete_last_name("Bentan");
        steps.my_account.save_input.click();
        steps.complete_phone("0729467703");
        steps.my_account.save_input.click();
    }

    @When("my account: i close my account page")
    public void close_my_account(){
        steps.exit_my_account();
    }

    @Then("my account: i open again my account page and verify if the credentials are updated")
    public void verify_correct_credentials(){
        steps.open_my_account();
        steps.verify_first_name("Laurentiu");
        steps.verify_last_name("Bentan");
        steps.verify_phone_number("0729467703");
    }
    @Then("my account: i verify that the invalid messages are not displayed")
    public void verify_invalid_messages_not_displayed(){
        steps.verify_invalid_first_name_message_not_displayed();
        steps.verify_invalid_last_name_message_not_displayed();
        steps.verify_invalid_phone_number_message_not_displayed();
    }





}
