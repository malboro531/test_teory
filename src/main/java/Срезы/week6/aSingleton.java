package Срезы.week6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class aSingleton {

    public static class ConstantVariable {
        public static String browserName = "Chrome";
        public static String URL = "https://www.google.com";
    }

    public static class BaseClass {
        public static WebDriver driver = null;

        public static void initialize() {
            //Use Of Singleton Concept and Initialize webDriver
            if (driver == null) {
                if (ConstantVariable.browserName.equalsIgnoreCase("Chrome")) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                } else if (ConstantVariable.browserName.equalsIgnoreCase("Firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                } else if (ConstantVariable.browserName.equalsIgnoreCase("IE")) {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
            }

            //Perform Basic Operations
            assert driver != null;
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }

        public static void quit() {
            driver.quit();
            driver = null; // we destroy the driver object after quit operation
        }

        public static void close() {
            driver.close();
            driver = null;  // we destroy the driver object after quit operation
        }

        public static void openurl(String URL) {
            driver.get(URL);
        }
    }

    public static class TestClass {
        @BeforeClass
        public static void setup() {
            BaseClass.initialize();
        }

        @Test
        public void openUrl() throws InterruptedException {
            BaseClass.openurl(ConstantVariable.URL);
            Thread.sleep(3000);
        }

        @AfterClass
        public static void tearDown() {
            BaseClass.quit();
        }
    }
}