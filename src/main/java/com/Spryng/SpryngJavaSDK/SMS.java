package com.Spryng.SpryngJavaSDK;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class SMS implements Constants
{

    /**
     * Instance of the main class to receive auth informaion.
     */
    Spryng api;

    /**
     * SMS Class constructor
     *
     * @param api
     */
    public SMS(Spryng api)
    {
        this.api = api;
    }

    /**
     * Sends an SMS message.
     *
     * @param message
     * @return
     * @throws SpryngException
     */
    public SpryngResponse send(Message message) throws SpryngException
    {
        if (!message.isValid())
        {
            throw new SpryngException("The message you provided is invalid. Please refer to the API documentation");
        }

        List<BasicNameValuePair> queryParameters = new ArrayList<BasicNameValuePair>();

        // Add auth information to query string
        String secretPasswordKey = (this.api.isSecretIsAPIKey()) ? "secret" : "password";
        queryParameters.add(new BasicNameValuePair("username", this.api.getUsername()));
        queryParameters.add(new BasicNameValuePair(secretPasswordKey, this.api.getSecret()));
        queryParameters.add(new BasicNameValuePair("sender", this.api.getSender()));

        queryParameters.add(new BasicNameValuePair("destination", message.getDestination()));
        queryParameters.add(new BasicNameValuePair("body", message.getBody()));
        queryParameters.add(new BasicNameValuePair("route", message.getRoute()));

        if (message.getService() != null)
        {
            queryParameters.add(new BasicNameValuePair("service", message.getService()));
        }

        if (message.isAllowLong())
        {
            queryParameters.add(new BasicNameValuePair("allowlong", "1"));
        }
        else
        {
            queryParameters.add(new BasicNameValuePair("allowlong", "0"));
        }

        if (message.getReference() != null)
        {
            queryParameters.add(new BasicNameValuePair("reference", message.getReference()));
        }

        URI uri;
        try
        {
            uri = new URI(HTTP_SCHEME, null, API_HOST, -1,  API_PATH + API_SEND_URI,
                    URLEncodedUtils.format(queryParameters, URL_ENCODING), null);
        }
        catch (URISyntaxException ex)
        {
            throw new SpryngException("Error occurred while trying to initiate URI for SMS request.");
        }

        System.out.println(uri.toString());

        return SpryngResponse.OK;
    }
}