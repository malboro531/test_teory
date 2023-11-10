package Срезы.week6;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CapabilitiesSWD {

    public static void main(String[] args) {

        //TODO класс Options
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");       //Открывает окно в развернутом (на весь экран) виде
        options.addArguments("incognito");             //Открывает окно в режиме инкогнито
        options.addArguments("headless");              //Открывает окно в headless mod (без загрузки визуальной части)
        options.addArguments("disable-extensions");    //Отключает существующие расширения в браузере Chrome
        options.addArguments("disable-popup-blocking");//Отключает всплывающие окна, отображаемые в браузере
        options.addArguments("make-default-browser");  //Делает например, Chrome браузером по умолчанию
        options.addArguments("version");               //Печатает версию браузера Chrome
        options.addArguments("disable-infobars");      //Предотвращает отображение Chrome уведомления
                                                       // "Chrome is being controlled by automated software"
        options.setCapability(" ","");
        options.getCapability("");
        options.setAndroidDeviceSerialNumber("");

        WebDriver driver1 = new ChromeDriver(options);
        try {
            driver1.get("https://google.com");
        } finally {
            driver1.quit();
        }
    }

    //Блокировщик рекламы:
    public void addBlock() {
        ChromeOptions options1 = new ChromeOptions();
        options1.addArguments("load-extension=/path/to/extension");
        ChromeDriver driver = new ChromeDriver(options1);
    }

    //TODO класс DesiredCapabilities
    @BeforeClass
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "77.0");
        capabilities.setCapability("platform", "win10");            // Если этот предел не указан,
                                                                                      // он просто получит любой доступный
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        capabilities.setCapability("network", true);                // Чтобы включить сетевые журналы
        capabilities.setCapability("visual", true);                 // Чтобы включить пошаговый снимок
                                                                                      // экрана
        capabilities.setCapability("video", true);                  // Чтобы включить запись видео
        capabilities.setCapability("console", true);                // Для записи журналов консоли

        capabilities.setCapability("selenium_version", "4.0.0-alpha-3. Какие виды мобильных приложений бывают.txt");
        capabilities.setCapability("timezone", "UTC+05:30");
        capabilities.setCapability("geoLocation", "IN");
        capabilities.setCapability("chrome.driver", "78.0");

        capabilities.setBrowserName("");

        WebDriver driver2 = new ChromeDriver();
        try {
            driver2 = new RemoteWebDriver(new URL("https://google.com"), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}