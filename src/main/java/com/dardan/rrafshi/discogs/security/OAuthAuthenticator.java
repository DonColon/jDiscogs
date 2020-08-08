package com.dardan.rrafshi.discogs.security;

import java.io.IOException;
import java.util.UUID;

import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.model.AccessToken;
import com.dardan.rrafshi.discogs.model.Credentials;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


public final class OAuthAuthenticator implements Authenticator
{
	private final Credentials credentials;
	private final AccessToken token;


	public OAuthAuthenticator(final Credentials credentials, final AccessToken token)
	{
		this.credentials = credentials;
		this.token = token;
	}


	@Override
	public Request authenticate(final Route route, final Response response)
		throws IOException
	{
		final String value = this.generateAccessTokenHeader();

		return response.request()
				.newBuilder()
				.header(Constants.AUTHORIZATION, value)
				.build();
	}


	private String generateAccessTokenHeader()
	{
		final StringBuilder builder = new StringBuilder("OAuth ");

		builder.append(String.format(Constants.OAUTH_CONSUMER_KEY, this.credentials.getKey()));
		builder.append(String.format(Constants.OAUTH_NONCE, UUID.randomUUID()));
		builder.append(String.format(Constants.OAUTH_REQUEST_TOKEN, this.token.getValue()));
		builder.append(String.format(Constants.OAUTH_ACCESS_SIGNATURE, this.credentials.getSecret(), this.token.getSecret()));
		builder.append(Constants.OAUTH_SIGNATURE_METHOD);
		builder.append(String.format(Constants.OAUTH_TIMESTAMP, System.currentTimeMillis()));

		builder.deleteCharAt(builder.length() - 1);

		return builder.toString();
	}
}
