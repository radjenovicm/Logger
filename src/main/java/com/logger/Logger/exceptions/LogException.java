package com.logger.Logger.exceptions;

public class LogException {
    public static class IncorrectLogTypeException extends BaseException {

        public IncorrectLogTypeException() {
            super("Incorrect log type!");
        }
    }

    public static class LogPayloadTooLargeException extends BaseException {

        public LogPayloadTooLargeException() {
            super("Message should be less than 1024!");
        }
    }
}
