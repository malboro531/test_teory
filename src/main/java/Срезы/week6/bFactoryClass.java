package Срезы.week6;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class bFactoryClass {

    WebDriver getWebDriver(String browserName){
        switch (browserName){
            case "chrome":
                return new ChromeDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }
    @Test
    public void test1(){
        WebDriver driver = getWebDriver("chrome");
        driver.get("https://otus.ru");
        Assert.assertEquals(driver.getTitle(),"Онлайн‑курсы для профессионалов, " +
                                                    "дистанционное обучение современным профессиям");
    }

    @Test
    public void test2(){
        WebDriver driver = getWebDriver("edge");
        driver.get("https://otus.ru");
        Assert.assertEquals(driver.getTitle(),"Онлайн‑курсы для профессионалов, " +
                "дистанционное обучение современным профессиям");
    }
}
