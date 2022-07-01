package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/apiConfig.properties")
public interface ApiConfig extends Config {
    String baseUrl();
    String userEmail();
    String userPassword();
    String token();
}
