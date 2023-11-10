package Срезы.week6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Frame {

    //TODO Frame
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver googleDriver = new ChromeDriver();
        googleDriver.get("https://selenium08.blogspot.com/2019/11/selenium-iframe.html");

        googleDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // определяем количество вложенных окон на странице и выводим их колличество
        int iFrameSize = googleDriver.findElements(By.tagName("iframe")).size(); // запрашиваем количество окон
        System.out.println("Total no of iframes: " + iFrameSize);

        // переключаемся на первое окно, вводим сообщение, нажимаем кнопку
        googleDriver.switchTo().frame(0); // переключаемся на первое окно
        googleDriver.findElement(By.xpath("//input[@itemprop = 'query-input']"))
                .sendKeys("Selenium Jobs");
        googleDriver.findElement(By.xpath("//button[@class = 'wpb_button wpb_btn-inverse btn']"))
                .click();

        googleDriver.switchTo().defaultContent(); // переключаемся назад на основное окно

        googleDriver.findElement(By.xpath("//div[@class='hamburger-section container']/button"))
                .click();
    }
}
