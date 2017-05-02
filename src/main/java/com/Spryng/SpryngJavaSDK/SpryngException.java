package com.Spryng.SpryngJavaSDK;

public class SpryngException extends Exception
{

    protected String field;

    public SpryngException(String message)
    {
        super(message);
    }
}
