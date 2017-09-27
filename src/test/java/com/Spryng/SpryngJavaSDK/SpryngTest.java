package com.Spryng.SpryngJavaSDK;

import junit.framework.TestCase;
import org.junit.Test;

public class SpryngTest extends TestCase
{
    public final String username = "";

    public final String secret = "";

    public final boolean secretIsApiKey = false;

    public final String destination = "";

    public final String senderName = "Spryng BV";

    public Spryng spryng;

    public SpryngTest() throws SpryngException
    {
        this.spryng = new Spryng(this.username, this.secret, this.senderName, this.secretIsApiKey);
    }

    @Test
    public void testConstructorGivesProperInstance()
    {
        assertEquals(this.spryng.getClass(), Spryng.class);
    }
    
    @Test
    public void testSenderValidation()
    {
       	try {
    				this.spryng.setSender(null);
    				fail("Null sender should throw an exception");
    		} catch (SpryngException e) {
    				assertTrue(e.getMessage().contains("The Sender ID is required"));
    		}
    	
    	
    		try {
				this.spryng.setSender("ABCDEFGH123");
		} catch (SpryngException e) {
				fail("11 character alphanumeric sender should not throw an exception");
		}
    		
       	try {
    				this.spryng.setSender("ABCDEFGH12345");
    				fail("13 character alphanumeric sender should throw an exception");
    		} catch (SpryngException e) {
    				assertTrue(e.getMessage().contains("The alphanumeric Sender ID you provided is too long"));
    		}
       	
		try {
			this.spryng.setSender("12345678901234");
		} catch (SpryngException e) {
			fail("14 character numeric sender should not throw an exception");
		}
		
      	try {
			this.spryng.setSender("123456789012345");
			fail("15 character numeric sender should throw an exception");
      	} catch (SpryngException e) {
			assertTrue(e.getMessage().contains("The numeric Sender ID you provided is too long"));
      	}
    }
}