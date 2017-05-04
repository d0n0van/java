package com.Spryng.SpryngJavaSDK;

public interface APIResponses
{
    public int RESPONSE_OK = 1;

    public int RESPONSE_MISSING_PARAMETER = 100;

    public int RESPONSE_USERNAME_TOO_LONG = 101;

    public int RESPONSE_USERNAME_TOO_SHORT = 102;

    public int RESPONSE_PASSWORD_TOO_SHORT = 103;

    public int RESPONSE_PASSWORD_TOO_LONG = 104;

    public int RESPONSE_DESTINATION_TOO_SHORT = 105;

    public int RESPONSE_DESTINATION_TOO_LONG = 106;

    public int RESPONSE_SENDER_TOO_LONG = 107;

    public int RESPONSE_SENDER_TOO_SHORT = 108;

    public int RESPONSE_CONTENT_TOO_LONG = 109;

    public int RESPONSE_CONTENT_TOO_SHORT = 110;

    public int RESPONSE_SECURITY_ERROR = 200;

    public int RESPONSE_UNKNOWN_ROUTE = 201;

    public int RESPONSE_ROUTE_ACCESS_VIOLATION = 202;

    public int RESPONSE_INSUFFICIENT_CREDITS = 203;

    public int RESPONSE_TECHNICAL_ERROR = 800;
}
