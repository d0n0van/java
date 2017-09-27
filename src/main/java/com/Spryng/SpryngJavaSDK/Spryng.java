package com.Spryng.SpryngJavaSDK;

public class Spryng implements Constants
{
    protected String username;

    protected String secret;

    protected String sender;

    protected boolean secretIsAPIKey = false;

    public SMS SMS;

    public Credits credits;

    public Spryng(String username, String secret, String sender, boolean secretIsAPIKey) throws SpryngException
    {
        this.setUsername(username);
        this.setSecret(secret);
        this.setSender(sender);
        this.setSecretIsAPIKey(secretIsAPIKey);

        this.SMS = new SMS(this);
        this.credits = new Credits(this);
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

    public void setSender(String sender) throws SpryngException
    {   	
    		if (sender == null)
    			throw new SpryngException("The Sender ID is required");
    
    		if (sender.matches("^[0-9]+$"))
    			{
    				if (sender.length() > SENDER_NUMERIC_MAX_LENGTH) 
    					throw new SpryngException("The numeric Sender ID you provided is too long. The maximum length is: " + SENDER_NUMERIC_MAX_LENGTH);
    			}
        		else if (sender.length() > SENDER_ALPHANUMERIC_MAX_LENGTH)
                throw new SpryngException("The alphanumeric Sender ID you provided is too long. The maximum length is: " + SENDER_ALPHANUMERIC_MAX_LENGTH);
            
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
