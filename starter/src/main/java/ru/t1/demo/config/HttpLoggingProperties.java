package ru.t1.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "http.logging")
public class HttpLoggingProperties {

//    private enum LogLevel {OFF, FATAL, ERROR, WARN, INFO, DEBUG, TRACE, ALL}
    private enum LogLevel {ERROR, WARN, INFO}

    private Boolean isEnabled = true;
    private LogLevel logLevel = LogLevel.INFO;
    private Boolean isGetMappingEnabled = true;
    private Boolean isPostMappingEnabled = true;
    private Boolean isDeleteMappingEnabled = true;
    private Boolean isPutMappingEnabled = true;

    public Boolean isGetMappingEnabled() {
        return isGetMappingEnabled;
    }

    public Boolean isPostMappingEnabled() {
        return isPostMappingEnabled;
    }

    public Boolean isDeleteMappingEnabled() {
        return isDeleteMappingEnabled;
    }

    public Boolean isPutMappingEnabled() {
        return isPutMappingEnabled;
    }

    public void setGetMappingEnabled(Boolean isGetMappingEnabled) {
        this.isGetMappingEnabled = isGetMappingEnabled;
    }

    public void setPostMappingEnabled(Boolean isPostMappingEnabled) {
        this.isPostMappingEnabled = isPostMappingEnabled;
    }

    public void setDeleteMappingEnabled(Boolean isDeleteMappingEnabled) {
        this.isDeleteMappingEnabled = isDeleteMappingEnabled;
    }

    public void setPutMappingEnabled(Boolean isPutMappingEnabled) {
        this.isPutMappingEnabled = isPutMappingEnabled;
    }

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
