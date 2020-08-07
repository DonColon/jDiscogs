package com.dardan.rrafshi.discogs.model.release;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class SimpleRelease
{
	private long id;

	private String title;

	@JsonProperty("resource_url")
	private String resourceUrl;


	private int year;

	private String artist;

	private String role;

	@JsonProperty("thumb")
	private String thumbnail;


	@JsonProperty("catno")
	private String categoryNumber;

	private String label;

	private String format;

	private String type;


	private String status;


	public long getID()
	{
		return this.id;
	}

	public String getTitle()
	{
		return this.title;
	}

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public int getYear()
	{
		return this.year;
	}

	public String getArtist()
	{
		return this.artist;
	}

	public String getRole()
	{
		return this.role;
	}

	public String getThumbnail()
	{
		return this.thumbnail;
	}

	public String getCategoryNumber()
	{
		return this.categoryNumber;
	}

	public String getLabel()
	{
		return this.label;
	}

	public String getFormat()
	{
		return this.format;
	}

	public String getType()
	{
		return this.type;
	}

	public String getStatus()
	{
		return this.status;
	}
}
