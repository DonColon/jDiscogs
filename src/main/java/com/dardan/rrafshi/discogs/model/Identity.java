package com.dardan.rrafshi.discogs.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Identity
{
	private long id;

	private String username;

	@JsonProperty("resource_url")
	private String resourceUrl;

	@JsonProperty("consumer_name")
	private String applicationName;


	public long getID()
	{
		return this.id;
	}

	public String getUsername()
	{
		return this.username;
	}

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public String getApplicationName()
	{
		return this.applicationName;
	}
}
