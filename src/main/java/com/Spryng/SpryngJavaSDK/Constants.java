package com.Spryng.SpryngJavaSDK;

/**
 * Extensible interface containing this library's constants
 */
public interface Constants
{
    /**
     * SDK Version.
     */
    String VERSION = "0.1";

    /**
     * HTTP Scheme to use.
     */
    String HTTP_SCHEME = "https";

    /**
     * The URL path separator.
     */
    String URL_PATH_SEPARATOR = "/";

    /**
     * Hostname for the API.
     */
    String API_HOST = "api.spryngsms.com";

    /**
     * URL endpoint for the API.
     */
    String API_PATH = URL_PATH_SEPARATOR + "api";

    /**
     * The URI used to send SMS messages.
     */
    String API_SEND_URI = URL_PATH_SEPARATOR + "send.php";

    /**
     * The URI used to check the credit balance.
     */
    String API_BALANCE_URI = URL_PATH_SEPARATOR + "check.php";

    /**
     * User agent with client information.
     */
    String USER_AGENT = "SpryngSDKJava/" + VERSION;
}