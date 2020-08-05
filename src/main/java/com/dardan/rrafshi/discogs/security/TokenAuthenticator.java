package com.dardan.rrafshi.discogs.security;

import java.io.IOException;

import com.dardan.rrafshi.discogs.Constants;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


public final class TokenAuthenticator implements Authenticator
{
	private final String apiKey;


	public TokenAuthenticator(final String apiKey)
	{
		this.apiKey = apiKey;
	}


	@Override
	public Request authenticate(final Route route, final Response response)
		throws IOException
	{
		final String value = String.format(Constants.AUTH_FORMAT, this.apiKey);

		return response.request()
				.newBuilder()
				.header(Constants.AUTHORIZATION, value)
				.build();
	}
}
