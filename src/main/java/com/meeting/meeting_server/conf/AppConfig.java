package com.meeting.meeting_server.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zcw
 */
@Component
@ConfigurationProperties(prefix = "sys")
@Data
public class AppConfig {
    private static String baseDir;

    private static String prefix;

    private static String url;

    private static String iss;

    private static String aud;

    private static String secret_key;

    public static String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        AppConfig.iss = iss;
    }

    public static String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        AppConfig.aud = aud;
    }

    public static String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        AppConfig.secret_key = secret_key;
    }

    public static String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        AppConfig.url = url;
    }

    public static String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        AppConfig.prefix = prefix;
    }

    public static String getBaseDir(){
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        AppConfig.baseDir = baseDir;
    }
}
