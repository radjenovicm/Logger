package com.logger.Logger.exceptions;

public class ValidationException {
    public static class InvalidCredentialsException extends BaseException {

        public InvalidCredentialsException() {
            super("Email/Username or password incorrect!");
        }
    }

    public static class InvalidEmailException extends BaseException {

        public InvalidEmailException() {
            super("Invalid email address format!");
        }
    }

    public static class UsernameLessThan3Chars extends BaseException {

        public UsernameLessThan3Chars() {
            super("Username less than 3 characters!");
        }
    }

    public static class InvalidPasswordException extends BaseException {

        public InvalidPasswordException() {
            super("Password must be at least 8 characters, one letter and one number!");
        }
    }

    public static class UsernameExistsException extends BaseException {

        public UsernameExistsException() {
            super("Username already exists!");
        }
    }

    public static class EmailExistsException extends BaseException {

        public EmailExistsException() {
            super("Email already exists!");
        }
    }

    public static class InvalidDateException extends BaseException {

        public InvalidDateException() {
            super("Invalid date!");
        }
    }
}
