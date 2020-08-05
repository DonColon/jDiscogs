package com.dardan.rrafshi.discogs.security;

import java.io.IOException;

import com.dardan.rrafshi.discogs.Constants;

import okhttp3.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


public final class CredentialsAuthenticator implements Authenticator
{
	private final String key;
	private final String secret;


	public CredentialsAuthenticator(final String key, final String secret)
	{
		this.key = key;
		this.secret = secret;
	}


	@Override
	public Request authenticate(final Route route, final Response response)
		throws IOException
	{
		final HttpUrl url = response.request().url()
				.newBuilder()
				.addQueryParameter(Constants.KEY, this.key)
				.addQueryParameter(Constants.SECRET, this.secret)
				.build();

		return response.request()
				.newBuilder()
				.url(url)
				.build();
	}
}
