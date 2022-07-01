package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {
    @Key("selenoidURL")
    String selenoidURL();
    @Key("baseUrl")
    String baseUrl();
    @Key("browserSize")
    String browserSize();
    @Key("browserName")
    String browserName();
    @Key("browserVersion")
    String browserVersion();
}