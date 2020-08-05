package com.dardan.rrafshi.discogs.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class User
{
	private String username;

	@JsonProperty("resource_url")
	private String resourceUrl;


	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public void setResourceUrl(final String resourceUrl)
	{
		this.resourceUrl = resourceUrl;
	}
}
