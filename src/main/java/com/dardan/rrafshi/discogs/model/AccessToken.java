package com.dardan.rrafshi.discogs.model;

import com.dardan.rrafshi.commons.Strings;


public final class AccessToken
{
	private final String value;
	private final String secret;


	private AccessToken(final String value, final String secret)
	{
		this.value = value;
		this.secret = secret;
	}


	public static AccessToken parse(final String urlEncoded)
	{
		final String[] parameters = Strings.split(urlEncoded, "&");

		final int tokenIndex = Strings.indexOf(parameters[0], "=") + 1;
		final String token = Strings.substring(parameters[0], tokenIndex);

		final int secretIndex = Strings.indexOf(parameters[1], "=") + 1;
		final String secret = Strings.substring(parameters[1], secretIndex);

		return AccessToken.of(token, secret);
	}

	public static AccessToken of(final String value, final String secret)
	{
		return new AccessToken(value, secret);
	}


	public String getValue()
	{
		return this.value;
	}

	public String getSecret()
	{
		return this.secret;
	}
}
