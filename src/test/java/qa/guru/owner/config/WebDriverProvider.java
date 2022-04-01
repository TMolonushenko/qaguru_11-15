package qa.guru.owner.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    // private WebDriverConfig config = new WebDriverConfig();
    private final WebDriverConfig config;

    public WebDriverProvider() {
        this.config = new WebDriverConfig();
    }

    @Override
    public WebDriver get() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = createWebDriver();
        driver.get(config.getBaseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        if (Objects.nonNull(config.getBrowser())) {
            switch (config.getBrowser()) {
                case CHROME: {
                    return new ChromeDriver();
                }
                case FIREFOX: {
                    return new FirefoxDriver();
                }
                default: {
                    throw new RuntimeException("Типа браузера не поддерживается");
                }
            }
        }
        throw new RuntimeException("Тип браузера не может быть null");
    }

}
