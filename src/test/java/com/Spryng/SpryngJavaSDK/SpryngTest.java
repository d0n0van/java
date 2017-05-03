package com.Spryng.SpryngJavaSDK;

import junit.framework.TestCase;
import org.junit.Test;

public class SpryngTest extends TestCase
{
    public final String username = "roemer";

    public final String secret = "roemer";

    public final boolean secretIsApiKey = false;

    public final String destination = "31681338412";

    public final String senderName = "Spryng B.V.";

    public Spryng spryng;

    public SpryngTest()
    {
        this.spryng = new Spryng(this.username, this.secret, this.senderName, this.secretIsApiKey);
    }

    @Test
    public void testConstructorGivesProperInstance()
    {
        assertEquals(this.spryng.getClass(), Spryng.class);
    }
}