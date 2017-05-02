package com.Spryng.SpryngJavaSDK;

/**
 * Represents a SMS message.
 */
public class Message
{
    /**
     * The destination phone number.
     */
    protected String destination;

    /**
     * The body of the SMS message.
     */
    protected String body;

    /**
     * The service parameter, used for filtering.
     */
    protected String service;

    /**
     * Parameter to specify the route to be used.
     */
    protected String route;

    /**
     * Indicates whether it's OK to send multiple messages.
     */
    protected boolean allowLong = false;

    /**
     * The Reference parameter, used to identify a message when receiving a delivery report.
     */
    protected String reference;

    /**
     * Instantiates a new Message.
     *
     * @param destination the destination
     * @param body        the body
     * @param service     the service
     * @param route       the route
     * @param allowLong   the allow long
     * @param reference   the reference
     */
    public Message(String destination, String body, String service, String route, boolean allowLong, String reference)
    {
        this.destination = destination;
        this.body = body;
        this.service = service;
        this.route = route;
        this.allowLong = allowLong;
        this.reference = reference;
    }

    /**
     * Checks if the supplied data is valid.
     *
     * @return the boolean
     */
    public boolean isValid()
    {
        if (this.destination == null || !this.destination.matches("/^[1-9]{1}[0-9]{3,14}$/"))
        {
            return false;
        }

        if (this.body == null || (this.allowLong && this.body.length() > 612) || (!this.allowLong && this.body.length()
            > 160))
        {
            return false;
        }

        if (this.reference != null)
        {
            if (this.reference.length() < 1 || this.reference.length() > 256)
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Gets destination.
     *
     * @return the destination
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * Sets destination.
     *
     * @param destination the destination
     */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public String getBody()
    {
        return body;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(String body)
    {
        this.body = body;
    }

    /**
     * Gets service.
     *
     * @return the service
     */
    public String getService()
    {
        return service;
    }

    /**
     * Sets service.
     *
     * @param service the service
     */
    public void setService(String service)
    {
        this.service = service;
    }

    /**
     * Gets route.
     *
     * @return the route
     */
    public String getRoute()
    {
        return route;
    }

    /**
     * Sets route.
     *
     * @param route the route
     */
    public void setRoute(String route)
    {
        this.route = route;
    }

    /**
     * Is allow long boolean.
     *
     * @return the boolean
     */
    public boolean isAllowLong()
    {
        return allowLong;
    }

    /**
     * Sets allow long.
     *
     * @param allowLong the allow long
     */
    public void setAllowLong(boolean allowLong)
    {
        this.allowLong = allowLong;
    }

    /**
     * Gets reference.
     *
     * @return the reference
     */
    public String getReference()
    {
        return reference;
    }

    /**
     * Sets reference.
     *
     * @param reference the reference
     */
    public void setReference(String reference)
    {
        this.reference = reference;
    }
}
