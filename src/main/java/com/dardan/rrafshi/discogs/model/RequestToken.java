package com.dardan.rrafshi.discogs.model;

import com.dardan.rrafshi.commons.Strings;
import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.Endpoints;

import okhttp3.HttpUrl;


public final class RequestToken
{
	private final String value;
	private final String secret;
	private final String authenticationUrl;


	private RequestToken(final String value, final String secret, final String authenticationUrl)
	{
		this.value = value;
		this.secret = secret;
		this.authenticationUrl = authenticationUrl;
	}


	public static RequestToken parse(final String urlEncoded)
	{
		final String[] parameters = Strings.split(urlEncoded, "&");

		final int tokenIndex = Strings.indexOf(parameters[0], "=") + 1;
		final String token = Strings.substring(parameters[0], tokenIndex);

		final int secretIndex = Strings.indexOf(parameters[1], "=") + 1;
		final String secret = Strings.substring(parameters[1], secretIndex);

		return RequestToken.of(token, secret);
	}

	public static RequestToken of(final String value, final String secret)
	{
		final HttpUrl url = HttpUrl.parse(Constants.BASE_URL)
				.newBuilder()
				.addPathSegments(Endpoints.AUTHORIZE_GET)
				.addQueryParameter(Constants.OAUTH_TOKEN, value)
				.build();

		return new RequestToken(value, secret, url.toString());
	}


	public String getValue()
	{
		return this.value;
	}

	public String getSecret()
	{
		return this.secret;
	}

	public String getAuthenticationUrl()
	{
		return this.authenticationUrl;
	}
}
