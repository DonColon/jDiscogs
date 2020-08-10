# jDiscogs
jDiscogs is a java wrapper/client for the [Discogs API v2](https://www.discogs.com/developers). It allows java developers to retrieve information about releases, artists and labels from the Discogs database. It handles all authentication methods for easy access to the API. You only have to provide the consumer information of your application (key + secret) or the API key of your account, which you get from the [developer settings](https://www.discogs.com/settings/developers).

## Requirements
Before you can use the library, ensure you have met the following requirements:

- You have Java Version 8 or later installed
- You have Maven Version 3.5.4 or later installed

## Installation
In order to use this library you have to specify my maven repository in your pom.xml.
```xml
<repositories>
    ...
    <repository>
        <id>github</id>
        <name>GitHub DonColon Apache Maven Packages</name>
        <url>https://maven.pkg.github.com/doncolon/maven</url>
    </repository>
    ...
</repositories>
```

Then add the following Maven dependency to your project's pom.xml:
```xml
<dependencies>
    ...
    <dependency>
        <groupId>com.dardan.rrafshi</groupId>
	    <artifactId>jDiscogs</artifactId>
	    <version>1.0.0</version>
    </dependency>
    ...
</dependencies>
```

After that open your console in the project's directory and enter the following command:
```bash
mvn clean install
```

Maven should install all required dependencies and you can start using the library.

## Usage
Instantiate a `Discogs` client object using the constructor that best fits your application's needs. Each constructor is for a different authentication method. With the client object you can call the API endpoints and retrieve the information as a java bean.

### Token Authorization
This method is the simpliest way to start with. You only have to pass the API key of your account to the client.
```java
final String apiKey = "<your_api_key>";
final long releaseID = 249504;

final Discogs discogs = new Discogs(apiKey);
final Release release = discogs.getRelease(releaseID);

System.out.println(release.getTitle());
System.out.println(release.getYear());
System.out.println(release.getGenres());
```

### Credential Authorization
This method uses the consumer credentials of your registered discogs application. So the access is only for the application.
```java
final String consumerKey = "<your_consumer_key>";
final String consumerSecret = "<your_consumer_secret>";
final long releaseID = 249504;

final Discogs discogs = new Discogs(consumerKey, consumerSecret);
final Release release = discogs.getRelease(releaseID);

System.out.println(release.getTitle());
System.out.println(release.getYear());
System.out.println(release.getGenres());
```

### OAuth Authorization
You have to use this method in order to perform operations on behalf of a user. First you have to retrieve a request token. After that you need the permission of the user to get the access token. Therefore you have to redirect the user to the authentication url of Discogs. After the user gives the permission, he obtains a verifier code. Your application needs this verifier code and the request token in order to get the access token.  

First you need to instantiate an `OAuthFlow` object. The constructor needs the consumer information (key + secret) to work. With the object you can retrieve the request and access token.
```java
final String consumerKey = "<your_consumer_key>";
final String consumerSecret = "<your_consumer_secret>";

final OAuthFlow flow = new OAuthFlow(consumerKey, consumerSecret);
final RequestToken requestToken = flow.getRequestToken();

// Redirect the user to this url to get the verifier code
final String authenticationUrl = requestToken.getAuthenticationUrl();

// Exchange the request token and the verifier code the user has entered for the access token
final AccessToken accessToken = flow.getAccessToken(requestToken, verifierCode);

// Instantiate the Discogs object with the credentials and the access token
// Retrieve the identity of the user to check if the authentication worked
final Discogs discogs = new Discogs(consumerKey, consumerSecret, accessToken);
final Identity identity = discogs.getIdentity();

System.out.println(identity.getApplicationName())
System.out.println(identity.getUsername());
```

## Examples
In the package [com.dardan.rrafshi.discogs.examples](https://github.com/DonColon/jDiscogs/tree/master/src/main/java/com/dardan/rrafshi/discogs/examples) are some examples you can play with. In order to start the applications you need to do one of the following things:

1. Store your authentication information in the environment variables `DISCOGS_API_KEY`, `DISCOGS_CONSUMER_KEY` and `DISCOGS_CONSUMER_SECRET`.
2. You can also just replace the `Systems.getEnvironmentVariable` statement with your authentication information.

## Contact
If you want to contact me you can reach me at <dardan.rrafshi@gmail.com>

## License
This project is licensed under the [Apache License 2.0](https://github.com/DonColon/jDiscogs/blob/master/LICENSE)