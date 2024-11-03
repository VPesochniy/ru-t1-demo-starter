package ru.t1.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "http.logging")
public class HttpLoggingProperties {


    private Boolean isEnabled = true;
    private LogLevel logLevel = LogLevel.INFO;

//    тут можно еще кучу всякого добавить, например каждый метод отдельно
//    private Boolean isGetMappingEnabled = true;
//    private Boolean isPostMappingEnabled = true;
//    private Boolean isDeleteMappingEnabled = true;
//    private Boolean isPutMappingEnabled = true;

    public Boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
