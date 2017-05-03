package com.Spryng.SpryngJavaSDK;

import org.junit.Test;

public class MessageTest extends SpryngTest
{
    public MessageTest() throws SpryngException
    {
    }

    @Test
    public void testMessageValidationFailsWhenDestinationIsNotSet()
    {
        Message message = new Message();

        message.setBody("Hi, your package has been delivered.");
        message.setRoute("business");
        message.setAllowLong(false);
        message.setReference("SMS_0123456789");

        assertFalse(message.isValid());
    }

    @Test
    public void testMessageValidationFailsWhenRouteIsNotSet()
    {
        Message message = new Message();

        message.setBody("Hi, your package has been delivered.");
        message.setDestination(this.destination);
        message.setAllowLong(false);
        message.setReference("SMS_0123456789");

        assertFalse(message.isValid());
    }

    @Test
    public void testMessageValidationFailsWhenDestinationIsNotValid()
    {
        Message message = new Message();

        // Initialize otherwise valid message
        message.setBody("Hi, your package has been delivered.");
        message.setAllowLong(false);
        message.setReference("SMS_0123456789");

        // Destination starts with a '+'
        message.setDestination("+31612345678");
        assertFalse(message.isValid());

        // Destination starts with one or more 0's
        message.setDestination("0031612345678");
        assertFalse(message.isValid());

        // Destination does not have country code prefix
        message.setDestination("0612345678");
        assertFalse(message.isValid());

        // Destination contains string in the beginning
        message.setDestination("a" + this.destination);
        assertFalse(message.isValid());

        // Destination contains string in the end
        message.setDestination(this.destination + "a");
        assertFalse(message.isValid());
    }

    @Test
    public void testBodyIsTooLongForNoAllowLong()
    {
        Message message = new Message();
        message.setDestination(this.destination);
        message.setAllowLong(false);
        message.setReference("SMS_0123456789");

        String body = "";
        for (int i = 0; i < 161; i++)
        {
            body += "a";
        }

        message.setBody(body);

        assertFalse(message.isValid());
    }

    @Test
    public void testBodyIsTooLongWithAllowLongEnabled()
    {
        Message message = new Message();
        message.setDestination(this.destination);
        message.setAllowLong(false);
        message.setReference("SMS_0123456789");

        String body = "";
        for (int i = 0; i < 700; i++)
        {
            body += "a";
        }

        message.setBody(body);

        assertFalse(message.isValid());
    }

    @Test
    public void testReferenceIsTooLong()
    {
        Message message = new Message();
        message.setDestination(this.destination);
        message.setBody("Hi, your package has been delivered.");
        message.setAllowLong(false);

        String reference = "";
        for (int i = 0; i < 260; i++)
        {
            reference += "a";
        }
        message.setReference(reference);

        assertFalse(message.isValid());
    }
}
