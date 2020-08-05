package com.dardan.rrafshi.discogs.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Image
{
	private String uri;

	@JsonProperty("resource_url")
	private String resourceUrl;

	private int width;

	private int height;

	private String type;


	public String getUri()
	{
		return this.uri;
	}

	public void setUri(final String uri)
	{
		this.uri = uri;
	}

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public void setResourceUrl(final String resourceUrl)
	{
		this.resourceUrl = resourceUrl;
	}

	public int getWidth()
	{
		return this.width;
	}

	public void setWidth(final int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return this.height;
	}

	public void setHeight(final int height)
	{
		this.height = height;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(final String type)
	{
		this.type = type;
	}
}
