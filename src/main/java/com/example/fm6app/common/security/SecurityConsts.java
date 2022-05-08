package com.example.fm6app.common.security;

import org.springframework.http.HttpStatus;

public class SecurityConsts {
    public static final long EXPIRATION_TIME = 86400000; // JWT 5 Days
    public static final HttpStatus OK = HttpStatus.OK;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token cannot be verified";
    public static final String AUTHORITIES = "authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to log to access this page";
    public static final String ACCESS_DENIED_MESSAGE = "You do not have permission to acess this page";
    public static final String OPTION_HTTP_METHOD = "OPTION";
    public static final String[] PUBLIC_URLS = {"/users/login/**"};
    public static final String COMPANY_LLC = "Fondation Mohammed VI pour la Promotion des Oeuvres Sociales des Préposés religieux";
    public static final String COMPANY_LLC_ADMINISTRATON = "Fondation Mohammed VI pour la Promotion des Oeuvres Sociales des Préposés religieux administration";
    public static final String timeZone = "Morocco/Casablanca";
}
