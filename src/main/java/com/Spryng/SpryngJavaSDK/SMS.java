package com.Spryng.SpryngJavaSDK;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public class SMS implements Constants
{
    public SpryngResponse send(Message message)
    {
        URI uri;
        try
        {
            uri = new URI(HTTP_SCHEME, API_HOST, API_PATH, API_SEND_URI);
        }
        catch (URISyntaxException ex)
        {
            return SpryngResponse.SDK_ERROR;
        }

        return SpryngResponse.OK;
    }
}
