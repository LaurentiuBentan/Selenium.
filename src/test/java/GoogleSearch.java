import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        //setam locatia catre chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Desktop\\Selenium\\chromedriver.exe");

        //cream un obiect de tip chrome driver
        WebDriver driver = new ChromeDriver();

        //deschidem url
        driver.get("https://google.ro");

        //maximizam fereastra
        driver.manage().window().maximize();

        //refresh page
        driver.navigate().refresh();//tot in navigate gasim si back si forward

        //stergem cookieu-rile
        driver.manage().deleteAllCookies();

        //gasim un element folosindu.ne de xpath prin metoda text si dam click pe el
        //acesta este un selector/locator
        driver.findElement(By.xpath("//div[text()='Sunt de acord']")).click();

        //gasim un element folosind name
        //il salvam intr-o variabila de tip web element si trimitem valori de la tastatura in input
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("massini");
        Thread.sleep(3000);

        //stergem valoarea din input
        searchInput.clear();
        Thread.sleep(3000);
        searchInput.sendKeys("masini");

        //dam enter de la tastatura
        searchInput.sendKeys(Keys.ENTER);

        //punem o pauza
        Thread.sleep(3000);

        //inchidem chrome
        driver.quit();
    }
}
