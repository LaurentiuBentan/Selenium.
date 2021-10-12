import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FormyTest {
    public static void main(String[] args) throws InterruptedException {
        //setam locatia catre chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\Selenium\\chromedriver.exe");

        //cream un obiect de tip chrome driver
        WebDriver driver = new ChromeDriver();

        //deschidem url
        driver.get("https://formy-project.herokuapp.com/form");

        driver.manage().window().maximize();

        //selector dupa id
        driver.findElement(By.id("first-name")).sendKeys("Laurentiu");

        //selector dupa xpath in functie de valoarea atributului placeholder
        driver.findElement(By.xpath("//input[@placeholder='Enter last name']")).sendKeys("Bentan");

        //selector dupa xpath in functie de valoarea atributului id
        //salvam elementul web intr-o variabila
        WebElement job_title = driver.findElement(By.xpath("//input[@id='job-title']"));
        job_title.sendKeys("Glovo driver");
        job_title.clear();
        job_title.sendKeys("software tester");

        //salvam elementele intr-o lista de web elements
        List<WebElement> education_list = driver.findElements(By.xpath("//input[@type='radio']"));
        education_list.get(1).click();

        //orice selector incepe cu// este de tip xpath
        //selectam primul element cand avem mai multe rezultate de acelasi tip
        //in xpath primul element are indexul 1 spre deosebire de o lista sau un array din java care incep de la 0
        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

        //xpath: dupa textul negru
        driver.findElement(By.xpath("//option[text()='Select an option']")).click();

        //xpath: dupa text negru partial
        driver.findElement(By.xpath("//option[contains(text(),'10')]")).click();

        //xpath: * reprezinta orice element
        driver.findElement(By.xpath("//*[@data-provide='datepicker']")).sendKeys("05/13/2021");


        //problema: uneori web driver se misca mai repede decat pagina web
        //initializam un obiect de tip webdriver wait
        //webdriver wait are un constructor cu 2 parametrii: web driver, si cate secunde sa astepte dupa element
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //xpath: dupa textul negru, salvam elementul in variabila submit
        WebElement submit = driver.findElement(By.xpath("//a[text()='Submit']"));
        //asteptam pana cand putem da click pe element
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        Thread.sleep(1000);
        submit.click();
        Thread.sleep(1000);

        //verificam url-ul noii pagini
        String url = driver.getCurrentUrl();
        //verificam ca /thanks este un substring al stringului url
        //asert true verifica daca conditia dintre paranteze este evaluata ca fiind adevarata
        Assert.assertTrue(url.contains("/thanks"));
        //verificam titlul paginii
        //luam titlul paginii si il salvam intr-o variabila de tip string
        String title = driver.getTitle();
        //asset equal: verifica daca cei 2 parametrii dintre paranteze sunt egali
        Assert.assertEquals(title, "Formy");

        WebElement h1 = driver.findElement(By.xpath("//h1[text()='Thanks for submitting your form']"));
        //verificam ca elementul este vizibil
        Assert.assertTrue(h1.isDisplayed());

        //luam textul din elementul h1
        String mesaj_succes = h1.getText();

        //verificam textul luat
        Assert.assertEquals(mesaj_succes, "Thanks for submitting your form");
        Thread.sleep(3000);
        driver.close();
    }
}
