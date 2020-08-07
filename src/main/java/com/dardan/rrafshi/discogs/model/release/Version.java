package com.dardan.rrafshi.discogs.model.release;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Version
{
	private long id;

	private String title;

	@JsonProperty("resource_url")
	private String resourceUrl;


	private String country;

	private String released;


	@JsonProperty("thumb")
	private String thumbnail;

	private String label;

	private String format;

	private List<String> majorFormats;

	@JsonProperty("catno")
	private String categoryNumber;


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

	public String getCountry()
	{
		return this.country;
	}

	public String getReleased()
	{
		return this.released;
	}

	public String getThumbnail()
	{
		return this.thumbnail;
	}

	public String getLabel()
	{
		return this.label;
	}

	public String getFormat()
	{
		return this.format;
	}

	public List<String> getMajorFormats()
	{
		return this.majorFormats;
	}

	public String getCategoryNumber()
	{
		return this.categoryNumber;
	}

	public String getStatus()
	{
		return this.status;
	}
}
