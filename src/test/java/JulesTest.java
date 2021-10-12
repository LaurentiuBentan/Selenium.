import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JulesTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jules.app/sign-in");
        //1. verifici titlul paginii - sa fie "Jules"
        String title = driver.getTitle();
        Assert.assertEquals(title, "Jules", "Titlul nu este cel asteptat"); //al treilea parametru este mesajul afisat in cazul in care pica testul

        //2. verifici url sa contina "/sign-in"
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/sign-in"));
        Thread.sleep(1000);
        //3. click pe signup
        driver.findElement(By.xpath("//a[@data-test-id='sign-up-link']")).click();

        //4. verifici noul url sa contina "/sign-up"
        String url2 = driver.getCurrentUrl();
        Assert.assertTrue(url2.contains("/sign-up"));

        //5. click pe login
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id='go-to-login-btn']")).isEnabled());
        driver.findElement(By.xpath("//button[@data-test-id='go-to-login-btn']")).click();

        //6. click pe forgot password?
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();

        //7. verifici noul url sa contina "/forgot-password"
        String url3 = driver.getCurrentUrl();
        Assert.assertTrue(url3.contains("/forgot-password"));

        //8. click pe back to login
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@data-test-id='sign-in-link']")).click();

        //9. completeaza email input gresit. ex: abc.com
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter your email']"));
        email.sendKeys("Laurentiu");

        //10. verifica ca apare (isDisplayed) mesajul de eroare "Please enter a valid email adress!"
        WebElement email_validation = driver.findElement(By.xpath("//p[text()='Please enter a valid email address!']"));
        Assert.assertTrue(email_validation.isDisplayed());
        String enter_valid_adress = email_validation.getText();
        Assert.assertEquals(enter_valid_adress, "Please enter a valid email address!");

        //10B. verificam ca butonul este disable
        Assert.assertFalse(driver.findElement(By.xpath("//button[@data-test-id='login-button']")).isEnabled());

        //11. clear la email
        driver.navigate().refresh();
        Thread.sleep(1000);

        //12. completeaza corect cu un email valid ("abc@gmail.com")
        email = driver.findElement(By.xpath("//input[@placeholder='Enter your email']"));
        email.sendKeys("bentan_laurentiu@yahoo.com");

        //13. completeaza parola "abc123"
        driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("abc123");

        //14. da click pe Log In
        driver.findElement(By.xpath("//span[text()='Log in']")).click();

        //15. verifica ca apare mesajul de eroare "Invalid email/password combination"
        Thread.sleep(1000);
        WebElement invalid_cridentials_error = driver.findElement(By.xpath("//span[text()='Invalid email/password combination']"));
        Assert.assertTrue(invalid_cridentials_error.isDisplayed());
        String invalid_cridentials_message = invalid_cridentials_error.getText();
        Assert.assertEquals(invalid_cridentials_message, "Invalid email/password combination");



        Thread.sleep(3000);
        driver.close();
    }
}
