package Срезы.week6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver googleDriver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(googleDriver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) googleDriver;

        try {
            googleDriver.get("https://selenium08.blogspot.com/2019/11/selenium-iframe.html");
            Thread.sleep(5000);

            String window1 = googleDriver.getWindowHandle(); //берем идентификатор (дескриптор) того окна с которым работаем

            js.executeScript("window1.open('http://localhost:3000/')"); //JavascriptExecutor используется для
                                                                             //открытия нового окна
                                                                             //к уже существующему, т.к. в selenium
                                                                             //нет метода для открытия окна,
                                                                             //используем js.executeScript

            Set<String> currentWindows = googleDriver.getWindowHandles(); //берем идентификаторы открытых окон с которым
                                                                          //работаем

            String window2 = null; //сюда сохраним идентификатор (дескриптор) окна localhost:3000

            for (String window : currentWindows){
                if(!window.equals(window1)){
                    window2 = window;
                    break;
                }
            }

            googleDriver.switchTo().window(window2); //переключаемся на новое окно
            Thread.sleep(5000);
            googleDriver.switchTo().window(window1); //переключаемся на старое окно


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            finally {
            //googleDriver.quit();
        }
    }
}