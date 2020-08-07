package com.dardan.rrafshi.discogs.model.release;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Artist
{
	private long id;

	private String name;

	@JsonProperty("resource_url")
	private String resourceUrl;

	private String join;

	private String role;

	private String tracks;


	public long getID()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public String getJoin()
	{
		return this.join;
	}

	public String getRole()
	{
		return this.role;
	}

	public String getTracks()
	{
		return this.tracks;
	}
}
