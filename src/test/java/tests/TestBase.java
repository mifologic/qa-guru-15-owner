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

    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @BeforeEach
    void setUp() {

        Configuration.baseUrl = config.baseUrl();
        Configuration.browserSize = config.browserSize();
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

    @AfterEach
    void addAttachments() {
        closeWebDriver();
    }
}
