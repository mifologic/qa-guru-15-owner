package tests;

import com.codeborne.selenide.Configuration;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    CredentialsConfig config;
    final String launchType = System.getProperty("type");

    @BeforeEach
    void setUp() {

        if (launchType.equals("web")) {
            System.setProperty("launch", "web");
            config = ConfigFactory.create(CredentialsConfig.class);
            Configuration.remote = config.selenoidURL();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", config.browserName());
            capabilities.setCapability("browserVersion", config.browserVersion());
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
        System.setProperty("launch", "local");
        config = ConfigFactory.create(CredentialsConfig.class);
        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = config.browserSize();
    }

    @AfterEach
    void addAttachments() {
        closeWebDriver();
    }
}
