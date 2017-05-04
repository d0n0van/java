# Spryng Java SDK

Official Java Software Development Kit for the Spryng SMS platform. If you haven't yet, create an account [on our website](https://spryng.nl/).

### Getting started

To use this SDK, you need a verified Spryng account, and sufficient credits to sent SMS messages. An account can be created on [our website](https://spryng.nl/). The library can easily be initialized like so:

```
Spryng spryng = new Spryng("Your_Username", "Your_Password_Or_API_Key",
	"Your Company Name");
```

### Sending a SMS Message

Sending a SMS message is easy. Initiate a `Message` instance and supply it to the method `Spryng.SMS.send()`:

```
// Messages can be initialised empty, or via it's constructor
Message message = new Message();

message.setDestination("31612345667");
message.setBody("This is the message that will be sent.");
message.setRoute("business");
message.setAllowLong(false);
message.setReference("SMS_0123456789");

SpryngResponse response;
try
{
	response = spryng.SMS.send(message);
}
catch (SpryngException ex)
{
	System.out.println("Something went wrong while sending your text message... "
		+ ex.getMessage());
}

if (response = SpryngResponse.OK)
{
	System.out.println("Message was sent successfully!!");
}
	
```

As can be derived from the above example, the `send()` method can throw a `SpryngException` and returns a `SpryngResponse`. For all possible responses, check the explanation below, or our [API reference](http://www.spryng.nl/en/developers/http-api/).

### Checking your credit balance

It's also possible to fetch the your current amount of credits using this library. This can be done like so:

```
float credits = spryng.credits.check();
System.out.println("You have " + credits + " credits at the moment".);
```
This method will return the float value `-1.0` if the credentials you supplied were invalid.


### Responses

When sending a SMS message, you will receive an instance of the `SpryngResponse` enum. The values this can have correspond to our [API reference](http://www.spryng.nl/en/developers/http-api/). The enum is as follows:

```
public enum SpryngResponse
{
    OK,
    MISSING_PARAMETER,
    USERNAME_TOO_LONG,
    USERNAME_TOO_SHORT,
    PASSWORD_TOO_LONG,
    PASSWORD_TOO_SHORT,
    DESTINATION_TOO_LONG,
    DESTINATION_TOO_SHORT,
    SENDER_TOO_LONG,
    SENDER_TOO_SHORT,
    CONTENT_TOO_LONG,
    CONTENT_TOO_SHORT,
    SECURITY_ERROR,
    UNKNOWN_ROUTE,
    ROUTE_ACCESS_VIOLATION,
    INSUFFICIENT_CREDITS,
    TECHNICAL_ERROR,
    SDK_ERROR
}
```

**`SpryngException`**

If anything goes wrong while executing the HTTP request to sent a message or retrieve your credit balance, a `SpryngException` will be thrown. Using `.getMessage()` you can get a description of the error.