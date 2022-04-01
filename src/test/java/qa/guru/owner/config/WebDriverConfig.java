package qa.guru.owner.config;

import java.net.URL;

public class WebDriverConfig {

    public String getBaseUrl() {
        return "https://github.com/";
    }

    public boolean isRemote() {
        return false;
    }

    public Browser getBrowser() {
        return Browser.FIREFOX;
    }

    public URL getRemoteErl() { //для удаленного браузера, например, selenide
        return null;

    }
}
