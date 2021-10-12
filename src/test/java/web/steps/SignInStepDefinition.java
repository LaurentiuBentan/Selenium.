package web.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SignInStepDefinition {
    //definim o suita de pasi micuti intr-un singur pas mai mare care reprezinta un singur concept

    @Steps
    SignInSteps steps;

    @Given("sign in: I am a user on sign in page")
    public void open_sign_in_page(){
        steps.open_sign_in_page();
    }

    @When("sign in: I provide email (.*)$")
    public void invalid_email(String email_din_tabel){
        steps.complete_email_input(email_din_tabel);
        steps.complete_pass_input("123456789");
    }

    @Then("sign in: I verify invalid email error message")
    public void verify_email_error_message(){
        steps.verify_invalid_email_error_displayed();
    }

    @When("sign in: I log in with my valid credentials")
    public void valid_credential(){
        steps.complete_email_input("itfactory.ro@gmail.com");
        steps.complete_pass_input("Start123!");
        steps.click_log_in_button();
    }

}

//GIVEN, WHEN, and, but, THEN = sintaxa gherkin; este sintaxa universal folosita in metodologia bdd(behavior driven development)
//rolul bdd: de a facilita comunicarea dintre business, development si testare
//specificatii => taskuri => criterii de acceptare => scenarii de automatizat in teste(pozitiv+negativ)
//Given = seteaza contextul testului(in general e primul si singurul pas de tip given)
//When = descrie actiunile ce le face un user
//Then = facem verificarea finala in functie de pasii anteriori (scopul testului, ce ne asteptam sa vedem la final)
// ex:
// given: i am a user on home page
// when: i provide correct credential
// and: i click log in
// then: i land on my account page