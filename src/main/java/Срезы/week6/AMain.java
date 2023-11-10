 package Срезы.week6;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Срезы.week6.aSingleton.BaseClass.driver;

public class AMain {

    public static void main(String[] args) {

        //TODO Где прописать путь к драйверам?
        System.setProperty("webdriver.chrom.builder", "C:\\Users\\scott_3fefl6l\\" +
                "OneDrive\\Рабочий стол\\untitled2\\chromedriver.exe");
        //или используя библиотеку bonigarcia.wdm.WebDriverManager
        //WebDriverManager.chromedriver().setup();

        //TODO Реализация инициализации webdriver.
        WebDriver googleDriver = new ChromeDriver();
        googleDriver.get("http://localhost:3000/");

        //TODO Реализация инициализации singleton в классе Singleton
        aSingleton singleton;

        //TODO Реализация инициализации абстрактной фабрики в классе FactoryClass
        bFactoryClass factoryClass;

        //TODO Browser capabilities в классе CapabilitiesSWD
        CapabilitiesSWD capabilities;

        //TODO Headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");            //Открывает окно в headless mod (без загрузки визуально
                                                     // повышает производительность, скорость выполнения, экономит ресурсы

        //TODO Методы класса WebDriver
        googleDriver.get(options.getBrowserName());
        googleDriver.manage();          // Возвращает интерфейс опции
        googleDriver.close();
        googleDriver.quit();
        googleDriver.getTitle();         //Получает заголовок текущей страницы
        googleDriver.findElement(By.xpath("//input[@aria-label='Мне повезёт!']")); //.findElements()
        googleDriver.getCurrentUrl();    //Получает строку, представляющую текущий URL-адрес, на который смотрит браузер
        googleDriver.getPageSource();    //Получает исходный код последней загруженной страницы
        googleDriver.getWindowHandles(); // берем идентификатор окна, с которым работаем
        googleDriver.navigate();         //позволяет драйверу получить доступ к истории браузера и перейти по заданному URL
        googleDriver.switchTo();

        //TODO Методы класса WebElement
        WebElement webElement = googleDriver.findElement(By.xpath("//input[@aria-label='М']"));
        webElement.sendKeys();
        webElement.click();
        webElement.findElement(By.name(" "));
        webElement.clear();       //Для отчистки поля ввода, куда мы что-то ввели
        webElement.getCssValue(" ");
        webElement.getLocation(); //Где на странице находится верхний левый угол отображаемого элемента
        webElement.getSize();
        webElement.getTagName();
        webElement.getText();

        //TODO Методы класса By (Локаторы)
        googleDriver.findElement(By.xpath("")); //name(), className(), tagName(), xpath(),
                                                             // cssSelector(), linkText(), partialLinkText()

        // Примеры локаторов:
        By CARDS_OFFERS = By.xpath("//div[contains(@class,'OfferCard_wrap')]");
        By CONTINUE_SELECTING_DEPOSIT_BTN = By.xpath("//div[contains(@class,'CalculatorForDeposit_inputs')]/button");
        By CURRENCY_FIELD = By.xpath("//*[@name='currency']");
        By DURATION_FIELD = By.xpath("//select[@name='duration']");

        webElement.findElement(By.partialLinkText(""));

        //TODO Actions
        Actions actions = new Actions(googleDriver);

        actions
                .click()
                .sendKeys()
                .clickAndHold()
                .contextClick() // нажатие пкм
                .doubleClick()
                .dragAndDrop(webElement, webElement)
                .getActiveKeyboard();

        actions.moveToElement(webElement)   // навести курсор на какой-то элемент
                .keyDown("")                // нажать на кнопку
                .keyUp("")                  // отпустить кнопку
                .release()                  // отпустить кнопку после команды clickAndHold()
                .build()                    // применить действия обязательная команда
                .perform();                 // применить действия обязательная команда

        //TODO Alert (модальные окна)
        WebDriverWait wait = new WebDriverWait(googleDriver, Duration.ofSeconds(10));

        //Alert alert = googleDriver.switchTo().alert(); классический способ переключения на alert
        //как правило не используется

        Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // переключаемся на alert

        alert.sendKeys("");  // ввести текст в окно
        alert.getText();               // взять текст из окна
        alert.accept();                //нажатие на кнопку "ок"
        alert.dismiss();               // нажать кнопку "отмена"

        //TODO IFrame в классе Frame
        Frame iFrame;

        //TODO JSExecutor
        JavascriptExecutor js = (JavascriptExecutor) googleDriver; // инициализируем JavascriptExecutor

        //To Click on a Button
        js.executeScript("document.getElementById('enter element id').click();");
        //or
        Object okButton = "ok";
        js.executeScript("arguments[0].click();", okButton);

        //To Type Text in a Text Box without using sendKeys() method
        js.executeScript("document.getElementById('id').value='someValue';");
        js.executeScript("document.getElementById('Email').value='SeleniumTesting.com';");

        //To Handle Checkbox by passing the value as true or false
        js.executeScript("document.getElementById('enter element id').checked=false;");

        //To refresh browser window using Javascript
        js.executeScript("history.go(0)");

        //To get the Title of our webpage
        String titleText = js.executeScript("return document.title;").toString();

        //To get the domain name
        String domainName = js.executeScript("return document.domain;").toString();

        //To get the URL of a webpage
        String url = js.executeScript("return document.URL;").toString();

        //TODO WindowHandle в классе WindowHandle
        WindowHandle windowHandle;

        //TODO ожидания в selenium
        //неявное ожидание
        googleDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


       //явное ожидание
       WebElement element = (new WebDriverWait(googleDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(             //в методе until указываем чего мы ждем,
                                                                                //желательно использовать для работы
                                                                                //с конкретным элементом, например когда
                                                                                //нужно дождаться исчезновения элемента
                        By.xpath("//input[text()='Мне повезёт!']"))));
       element.click();

        //TODO разница между ожиданиями
        //неявное ожидание: указывается один раз, потом работает для всего метода, замедляет время выполнения теста,
                          //в основном применяется для методов findElement/s

        //явное ожидание: срабатывает только там где указано, ожидает выполнения условия.

        //TODO Expected Conditions и виды explicitly wait
        //Используется в явных ожиданиях
        //WebElement element1 = (new WebDriverWait(googleDriver, Duration.ofSeconds(10))
                //.until(ExpectedConditions
                        //.attributeContains(webElement,"","")       //атрибут содержит что-то конкретное
                        //.attributeToBe(webElement,"","")           //атрибут является чем-то
                        //.attributeToBeNotEmpty()                   //атрибут является не пустым

                        //.elementToBeClickable()                    //элемент кликабельный
                        //.elementToBeSelected()                     //элемент (выбран) выделен

                        //.invisibilityOf()                          //методы ожидающие видимость элемента

                        //.visibilityOf()                            //методы ожидающие HE видимость элемента

                        //.not(ExpectedConditions.invisibilityOf())  //для действия противоположенного тому, что
                                                                     //указано в скобках

                        //.numberOfElementsToBe()                    //ожидание количества элементов.

                        //.stalenessOf()                             //ожидание исчезновения элементов

                        //.textToBe()                                //ожидание текста

        //TODO Виды implicitly wait
        Duration pageLoadTimeout = googleDriver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10))     //ожидания появления элемента на странице или по времени
                .getPageLoadTimeout();                      //ожидание полной загрузки страницы

        //TODO FluentWait
        //Экземпляр FluentWait определяет максимальное время ожидания условия, а также частоту, с которой выполняется
        //проверка условия. Пользователи могут настроить ожидание, чтобы игнорировать определенные типы исключений во
        //время ожидания, например, NoSuchElementException при поиске элемента на странице.

        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> waitW = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(driver -> {
            return driver.findElement(By.id("foo"));
        });
    }
}