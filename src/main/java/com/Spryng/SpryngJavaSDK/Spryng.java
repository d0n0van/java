package com.Spryng.SpryngJavaSDK;

public class Spryng implements Constants
{
    protected String username;

    protected String secret;

    protected String sender;

    protected boolean secretIsAPIKey = false;

    public SMS SMS;

    public Spryng(String username, String secret, String sender, boolean secretIsAPIKey)
    {
        this.setUsername(username);
        this.setSecret(secret);
        this.setSender(sender);
        this.setSecretIsAPIKey(secretIsAPIKey);

        this.SMS = new SMS();
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getSecret()
    {
        return secret;
    }

    public void setSecret(String secret)
    {
        this.secret = secret;
    }

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public boolean isSecretIsAPIKey()
    {
        return secretIsAPIKey;
    }

    public void setSecretIsAPIKey(boolean secretIsAPIKey)
    {
        this.secretIsAPIKey = secretIsAPIKey;
    }
}
