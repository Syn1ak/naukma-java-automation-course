import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class SeleniumTest {
    public static WebDriver driver;
    public static String url = "https://my.ukma.edu.ua/auth/login";
    public static String name = "your_name";
    public static String password = "your_password";

    @BeforeAll
    public static void openSAZPage() {
        File f = new File("src/test/resources/chromedriver.exe");
        System.out.println(f.getName());
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
    }

    @Test
    public void checkLoginFormTitle() {
        WebElement element = driver.findElement(By.xpath("//h3[contains(text(), 'Сервіс запису на вибіркові дисципліни')]"));
        Assertions.assertEquals(element.getText(), "Сервіс запису на вибіркові дисципліни");
    }

    @Test
    public void checkLoginControlId() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"loginform-username\"]"));
        System.out.println(element.getAttribute("id"));
        Assertions.assertEquals(element.getAttribute("id"), "loginform-username");
    }

    @Test
    public void checkValidation() {
        WebElement loginFiled = driver.findElement(By.id("loginform-username"));
        loginFiled.sendKeys("   ");
        WebElement body = driver.findElement(By.tagName("body"));
        body.click();
        WebElement errorMsg = driver.findElement(By.xpath("//p[contains(text(), 'Необхідно заповнити \"Логін\".')]"));
        Assertions.assertEquals(errorMsg.getText(), "Необхідно заповнити \"Логін\".");
    }

    @AfterAll
    public static void quitDriver() {
        driver.quit();
    }
}
