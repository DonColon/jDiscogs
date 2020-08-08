package com.dardan.rrafshi.discogs.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.DiscogsException;
import com.dardan.rrafshi.discogs.OAuthFlow;
import com.dardan.rrafshi.discogs.model.RequestToken;


public final class GetRequestToken
{
	private static final Logger LOGGER = LoggerFactory.getLogger(GetRequestToken.class);


	public static void main(final String[] args)
	{
		final String consumerKey = Systems.getEnvironmentVariable(Constants.DISCOGS_CONSUMER_KEY);
		final String consumerSecret = Systems.getEnvironmentVariable(Constants.DISCOGS_CONSUMER_SECRET);

		try {
			final OAuthFlow flow = new OAuthFlow(consumerKey, consumerSecret);
			final RequestToken token = flow.getRequestToken();

			System.out.println(token.getValue());
			System.out.println(token.getSecret());
			System.out.println(token.getAuthenticationUrl());

		} catch(final DiscogsException.RequestFailed exception) {

			LOGGER.error("Retrieve failed", exception);
		}
	}
}
