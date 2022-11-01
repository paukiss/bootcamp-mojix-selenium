package basicSeleniumTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSeleniumTest {

    WebDriver driver;
    @BeforeEach
    public void setup(){
        System.out.println("setup");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void cleanup(){
        System.out.println("cleanup");
    }

    @Test
    public void verifySomeThing() throws InterruptedException {

        System.out.println("test");
        driver.get("http://todo.ly/");
        Thread.sleep(5000);
        // para almacenar historicos del navegador
        //driver.navigate().to("URL");
    }
}
