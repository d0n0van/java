package com.Spryng.SpryngJavaSDK;

import org.junit.Test;

public class CreditBalanceTest extends SpryngTest
{
    public CreditBalanceTest() throws SpryngException
    {

    }

    @Test
    public void testInvalidCredentialsReturnNegativeOne() throws SpryngException
    {
        this.spryng.setUsername("admin");
        this.spryng.setSecret("");

        assertEquals(this.spryng.credits.check(), (float) -1.0);

        this.spryng.setUsername(this.username);
        this.spryng.setSecret(this.secret);
    }

    @Test
    public void testCreditCheckReturnsValidFloat() throws SpryngException
    {
        float credits = this.spryng.credits.check();
        assertNotNull(credits);
    }
}
