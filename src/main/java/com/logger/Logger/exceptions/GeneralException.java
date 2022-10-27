package com.logger.Logger.exceptions;

public class GeneralException {
    public static class InvalidTokenException extends BaseException {

        public InvalidTokenException() {
            super("Token not valid!");
        }
    }

    public static class UserNotAdminException extends BaseException {

        public UserNotAdminException() {
            super("Correct token, but not admin!");
        }
    }

    public static class UserNotFoundException extends BaseException {

        public UserNotFoundException() {
            super("User not found!");
        }
    }
}
