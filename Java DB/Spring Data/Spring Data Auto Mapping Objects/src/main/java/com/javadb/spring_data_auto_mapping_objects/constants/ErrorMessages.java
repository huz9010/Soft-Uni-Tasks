package com.javadb.spring_data_auto_mapping_objects.constants;

public class ErrorMessages {

    public static final String EMAIL_EXISTS = "There is already a user registered with this email";
    public static final String INVALID_PASSWORD = "Enter password with minimum 6 characters at least 1 uppercase, 1 lowercase letter and 1 digit";
    public static final String INVALID_EMAIL = "Incorrect email.";
    public static final String INCORRECT_USER_OR_PASS = "Incorrect username / password";
    public static final String NO_LOGGED_IN_USER = "Cannot log out. No user was logged in.";
    public static final String NOT_LOGGED_IN_AS_ADMIN = "Please login as administrator to add, edit or delete games!";
    public static final String INVALID_TITLE = "Title has to begin with an uppercase letter and must have length between 3 and 100 symbols.";
    public static final String INVALID_PRICE = "Price must be a positive number.";
    public static final String INVALID_SIZE = "Size must be a positive number.";
    public static final String INVALID_TRAILER = "Trailer ID must contain exactly 11 characters.";
    public static final String INVALID_IMAGE_URL = "URL must start with http:\\\\\\ ot https:\\\\\\.";
    public static final String GAME_NOT_FOUND = "Game not found!";
}
