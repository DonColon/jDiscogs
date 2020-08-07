package com.dardan.rrafshi.discogs.model.platform;

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

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}
}
