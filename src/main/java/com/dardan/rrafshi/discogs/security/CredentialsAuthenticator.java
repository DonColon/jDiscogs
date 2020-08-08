package com.dardan.rrafshi.discogs.security;

import java.io.IOException;

import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.model.Credentials;

import okhttp3.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


public final class CredentialsAuthenticator implements Authenticator
{
	private final Credentials credentials;


	public CredentialsAuthenticator(final Credentials credentials)
	{
		this.credentials = credentials;
	}


	@Override
	public Request authenticate(final Route route, final Response response)
		throws IOException
	{
		final HttpUrl url = response.request().url()
				.newBuilder()
				.addQueryParameter(Constants.KEY, this.credentials.getKey())
				.addQueryParameter(Constants.SECRET, this.credentials.getSecret())
				.build();

		return response.request()
				.newBuilder()
				.url(url)
				.build();
	}
}
