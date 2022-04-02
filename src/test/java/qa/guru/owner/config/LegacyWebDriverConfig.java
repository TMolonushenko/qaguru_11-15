package qa.guru.owner.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class LegacyWebDriverConfig {

    public String getBaseUrl() {
        String baseUrl = System.getProperty("baseUrl");//читаем значение
        if (Objects.isNull(baseUrl)) {//обрабатываем дефолтное
            baseUrl = "https://github.com";
        }
        return baseUrl;// конвертируем результат
    }

    public boolean isRemote() {
        String isRemote = System.getProperty("isRemote"); // читаем значение
        if (Objects.isNull(isRemote)) { // обрабатываем дефолтное
            return false;
        }
        return Boolean.parseBoolean(isRemote); // конывертируем результат
    }

    public Browser getBrowser() {
        String browser = System.getProperty("browser");
        if (Objects.isNull(browser)) {
           return Browser.CHROME;
        }
        return Browser.valueOf(browser);
    }

    public URL getRemoteErl() { //для удаленного браузера, например, selenide
        String remoteUrl = System.getProperty("remoteUrl");
        if (Objects.isNull(remoteUrl)) {
            return null;
        }
        try { // конвертируем результат
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
           return null;
        }

    }
}
