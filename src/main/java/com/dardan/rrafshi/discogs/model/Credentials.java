package com.dardan.rrafshi.discogs.model;

public final class Credentials
{
	private final String key;
	private final String secret;


	private Credentials(final String key, final String secret)
	{
		this.key = key;
		this.secret = secret;
	}


	public static Credentials of(final String key, final String secret)
	{
		return new Credentials(key, secret);
	}


	public String getKey()
	{
		return this.key;
	}

	public String getSecret()
	{
		return this.secret;
	}
}
