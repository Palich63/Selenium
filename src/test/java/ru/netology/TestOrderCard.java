package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestOrderCard {
    private WebDriverRunner driver;
//    private static ChromeOptions options;

    @BeforeAll
    static void setUpAll() {
////        if (System.getProperty("os.name") == "Linux") {
////            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
////        }
////        if (System.getProperty("os.name") == "Windows 10") {
////             System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriverLinux.exe");
//
////        }
////        WebDriverManager.chromedriver().clearResolutionCache().setup();
//
////        WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
////        driver.get("http://www.google.com");
//
////        from webDriver.manager.chrome import ChromeDriverManager
////
////        webdriver.Chrome(ChromeDriverManager().install())
//                WebDriverManager.chromedriver().clearResolutionCache().setup();
//        WebDriverRunner.getWebDriver();
        WebDriverManager.chromedriver().setup();
//        options = new ChromeOptions();
//        options.addArguments("--headless");
//        WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
//        driver.get("http://www.google.com");
    }


    @BeforeEach
    void setUp() {
        driver = new WebDriverRunner();
        Configuration.headless = true;
//        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {

        driver = null;
    }

    @Test
    void shouldTestOrderCard() {
//        System.out.println(System.getProperty("os.name"));

        open("http://localhost:9999");
        SelenideElement form = $("[method='post']");
        form.$("[name='name']").setValue("Андреев");
        form.$("[type='tel']").setValue("+79998887755");
        form.$("[data-test-id='agreement']").click();
        form.$("[type='button']").click();
        $("[data-test-id='order-success']").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
