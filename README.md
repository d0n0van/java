# Spryng Java SDK

__This project is still under development. Feel free to submit a PR with your contribution!__

Official Java Software Development Kit for the Spryng SMS platform. If you haven't yet, create an account [on our website](https://spryng.nl/).

### Getting started

To use this SDK, you need a verified Spryng account, and sufficient credits to sent SMS messages. An account can be created on [our website](https://spryng.nl/). You can then initalize the SDK and send a message like so:

```
import com.Spryng.SpryngJavaSDK;
import com.Spryng.SpryngResponse;
import com.Spryng.SpryngException;

class SpryngTest
{
	public static void main(String[] args)
	{
		// Initiate the SDK
		Spryng spryng = new Spryng("Your_Username", "Your_Password",
			"Your Company Name");
			
		// Sent a SMS message
		try 
		{
			SpryngResponse response = spryng.SMS.Send("31612345678", "Hey there!",
			"REF_123", "business");
		}
		catch (SpryngException ex)
		{
			System.out.println("Could not sent SMS message. Error message: " + 
				ex.getMessage());
		}
		
		// Check the response from the API
		if (response == SpryngResponse.OK)
		{
			System.out.println("Message sent successfully!");
		}
		else
		{
			System.out.println("Something went wrong while sending the message...");
		}
	}
}
```