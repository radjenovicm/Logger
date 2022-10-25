package com.logger.Logger.model;
//3. Корисник може да упише лог
// message
// logType (ERROR,WARNING,INFO)
// createdDate


import java.time.LocalDate;
import java.util.UUID;

public class Log {

    private UUID id;
    private String token;
    private String message;
    private Enum logType;
    private LocalDate createdDate;

    public Log(){

    }

    public Log(UUID id, String token, String message, Enum logType, LocalDate createdDate) {
        this.id = id;
        this.token = token;
        this.message = message;
        this.logType = logType;
        this.createdDate = createdDate;
    }

    public Log(String token, String message, Enum logType, LocalDate createdDate) {
        this.token = token;
        this.message = message;
        this.logType = logType;
        this.createdDate = createdDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Enum getLogType() {
        return logType;
    }

    public void setLogType(Enum logType) {
        this.logType = logType;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", message='" + message + '\'' +
                ", logType=" + logType +
                ", createdDate=" + createdDate +
                '}';
    }
}
