package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderCardSelenium {
    private ChromeDriver driver;
    private static ChromeOptions options;

    @BeforeAll
    public static void setUpAll() {
//        if (System.getProperty("os.name") == "Windows 10") {
//            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        }
//        if (System.getProperty("os.name") == "Linux") {
//            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriverLinux.exe");
//        }
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--headless");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTestOrderCardSelenium() {
        WebElement form = driver.findElement(By.cssSelector("[method=post]"));
        form.findElement(By.cssSelector("[name=name]")).sendKeys("Андрей");
        form.findElement(By.cssSelector("[name=phone]")).sendKeys("+79998887755");
        form.findElement(By.cssSelector("[class=checkbox__box]")).click();
        form.findElement(By.cssSelector("[class=button__content]")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }
}