package com.dardan.rrafshi.discogs.model.release;

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

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public int getWidth()
	{
		return this.width;
	}

	public int getHeight()
	{
		return this.height;
	}

	public String getType()
	{
		return this.type;
	}
}
