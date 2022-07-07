package config;

import org.aeonbits.owner.Config;

@Config.Sources(
        {"classpath:config/${launch}.properties"})
public interface CredentialsConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("browserSize")
    String browserSize();

    @Key("selenoidURL")
    String selenoidURL();

    @Key("browserName")
    String browserName();

    @Key("browserVersion")
    String browserVersion();
}