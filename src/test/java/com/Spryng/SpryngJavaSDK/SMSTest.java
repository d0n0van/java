package com.Spryng.SpryngJavaSDK;

import org.junit.Test;

public class SMSTest extends SpryngTest
{
    public SMSTest() throws SpryngException
    {
    }

    @Test
    public void testAThing() throws SpryngException
    {
        Message message = new Message();

        message.setDestination(this.destination);
        message.setBody("Hi, your package has been delivered.");
        message.setRoute("business");
        message.setAllowLong(false);
        message.setReference("SMS_0123456789");

        assertTrue(message.isValid());
        this.spryng.SMS.send(message);
        assertEquals(true, true);
    }
}
