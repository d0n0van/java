package com.Spryng.SpryngJavaSDK;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Credits implements Constants, APIResponses
{
    protected Spryng api;

    protected RequestHandler http;

    public Credits(Spryng api)
    {
        this.api = api;
        this.http = new RequestHandler();
    }

    public float check() throws SpryngException
    {
        List<BasicNameValuePair> queryParameters = new ArrayList<BasicNameValuePair>();
        // Add auth information to query string
        String secretPasswordKey = (this.api.isSecretIsAPIKey()) ? "secret" : "password";
        queryParameters.add(new BasicNameValuePair("username", this.api.getUsername()));
        queryParameters.add(new BasicNameValuePair(secretPasswordKey, this.api.getSecret()));
        queryParameters.add(new BasicNameValuePair("sender", this.api.getSender()));

        URI uri;
        try
        {
            uri = new URI(HTTP_SCHEME, null, API_HOST, -1, API_PATH + API_BALANCE_URI,
                    URLEncodedUtils.format(queryParameters, URL_ENCODING), null);
        }
        catch (URISyntaxException ex)
        {
            throw new SpryngException("Error occurred while trying to initiate URI for credit balance request.");
        }

        this.http.setUri(uri);
        this.http.setQueryParameters(queryParameters);

        return (float) Float.valueOf(this.http.send());
    }
}