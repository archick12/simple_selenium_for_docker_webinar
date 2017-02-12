package guru99.tutorials;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class AppTestRemoteDriver {

    protected WebDriver driver;

    @Test
    public void simpleTest() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:32769/wd/hub"),
                    DesiredCapabilities.firefox());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        String eTitle = "Meet Guru99";
        String aTitle = "";

        // запустить firefox и перейти по адресу
        driver.get("http://www.guru99.com/");
        // разворачивает окно браузера
        driver.manage().window().maximize();
        // получить значение у тайтла страницы
        aTitle = driver.getTitle();

        // выполняем проверку
        assertEquals(aTitle, eTitle);

        // закрываем окно браузера
        driver.close();
    }
}

