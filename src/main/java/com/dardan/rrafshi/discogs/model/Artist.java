package com.dardan.rrafshi.discogs.model;

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

	public void setID(final long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public void setResourceUrl(final String resourceUrl)
	{
		this.resourceUrl = resourceUrl;
	}

	public String getJoin()
	{
		return this.join;
	}

	public void setJoin(final String join)
	{
		this.join = join;
	}

	public String getRole()
	{
		return this.role;
	}

	public void setRole(final String role)
	{
		this.role = role;
	}

	public String getTracks()
	{
		return this.tracks;
	}

	public void setTracks(final String tracks)
	{
		this.tracks = tracks;
	}
}
