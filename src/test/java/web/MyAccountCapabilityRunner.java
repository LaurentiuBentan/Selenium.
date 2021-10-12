package web;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

// avem nevoie de clasa asta ca sa porneasca testele pentru fiecare folder in parte din features
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/my_account_capability/")
public class MyAccountCapabilityRunner {
}
