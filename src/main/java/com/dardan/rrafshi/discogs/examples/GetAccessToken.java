package com.dardan.rrafshi.discogs.examples;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.Discogs;
import com.dardan.rrafshi.discogs.DiscogsException;
import com.dardan.rrafshi.discogs.OAuthFlow;
import com.dardan.rrafshi.discogs.model.AccessToken;
import com.dardan.rrafshi.discogs.model.Credentials;
import com.dardan.rrafshi.discogs.model.Identity;
import com.dardan.rrafshi.discogs.model.RequestToken;


public final class GetAccessToken
{
	private static final Logger LOGGER = LoggerFactory.getLogger(GetAccessToken.class);


	public static void main(final String[] args)
	{
		final String consumerKey = Systems.getEnvironmentVariable(Constants.DISCOGS_CONSUMER_KEY);
		final String consumerSecret = Systems.getEnvironmentVariable(Constants.DISCOGS_CONSUMER_SECRET);

		final Credentials credentials = Credentials.of(consumerKey, consumerSecret);

		try {
			final OAuthFlow flow = new OAuthFlow(credentials);
			final RequestToken requestToken = flow.getRequestToken();

			System.out.println("Please visit this website: " + requestToken.getAuthenticationUrl());
			System.out.println("------------------------------------------------------------");
			System.out.println("Please Enter your verification code from the website:");

			final Scanner scanner = new Scanner(System.in);

			final String verifierCode = scanner.nextLine();
			final AccessToken accessToken = flow.getAccessToken(requestToken, verifierCode);

			scanner.close();

			final Discogs discogs = new Discogs(credentials, accessToken);
			final Identity identity = discogs.getIdentity();

			System.out.println("");
			System.out.println("The application '" + identity.getApplicationName() + "' makes requests for user '" + identity.getUsername() + "'");

		} catch(final DiscogsException.RequestFailed exception) {

			LOGGER.error("Retrieve failed", exception);
		}
	}
}
