package com.Spryng.SpryngJavaSDK;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class RequestHandler implements Constants
{
    protected CloseableHttpClient http;

    protected List<BasicNameValuePair> queryParameters;

    protected URI uri;

    protected int httpResponseCode;

    public RequestHandler()
    {
        this.http = HttpClients.createDefault();
    }

    public String send() throws SpryngException
    {
        HttpGet get = new HttpGet(this.getUri());

        CloseableHttpResponse httpResponse;
        String response;

        try
        {
            httpResponse = this.http.execute(get);

            this.setHttpResponseCode(httpResponse.getStatusLine().getStatusCode());
            if (this.getHttpResponseCode() == HttpStatus.SC_OK)
            {
                response = this.httpResponseToString(httpResponse);
            }
            else
            {
                throw new SpryngException("Got non-OK HTTP status for request. Code: " + this.getHttpResponseCode());
            }
        }
        catch (IOException ioEx)
        {
            throw new SpryngException("HTTP Request failed. Message: " + ioEx.getMessage());
        }

        return response;
    }

    public String httpResponseToString(HttpResponse httpResponse) throws SpryngException
    {
        String response = "";
        if (httpResponse.getEntity() != null)
        {
            try
            {
                response = EntityUtils.toString(httpResponse.getEntity(), URL_ENCODING);
            }
            catch (ParseException pEx)
            {
                throw new SpryngException("Could not properly parse HTTP response to a string. Additional Message: "
                    + pEx.getMessage());
            }
            catch (IOException ioEx)
            {
                throw new SpryngException("Could not parse the HTTP response to a string.");
            }
        }

        return response;
    }

    public List<BasicNameValuePair> getQueryParameters()
    {
        return queryParameters;
    }

    public void setQueryParameters(List<BasicNameValuePair> queryParameters)
    {
        this.queryParameters = queryParameters;
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    private void setHttpResponseCode(int httpResponseCode)
    {
        this.httpResponseCode = httpResponseCode;
    }

    public int getHttpResponseCode()
    {
        return httpResponseCode;
    }
}
