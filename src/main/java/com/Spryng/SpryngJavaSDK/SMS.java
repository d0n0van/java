package com.Spryng.SpryngJavaSDK;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public class SMS implements Constants
{
    public SpryngResponse send(Message message) throws SpryngException
    {
        URI uri;
        try
        {
            uri = new URI(HTTP_SCHEME, API_HOST, API_PATH, API_SEND_URI);
        }
        catch (URISyntaxException ex)
        {
            throw new SpryngException("Error occurred while trying to initiate URI for SMS request.");
        }

        return SpryngResponse.OK;
    }
}