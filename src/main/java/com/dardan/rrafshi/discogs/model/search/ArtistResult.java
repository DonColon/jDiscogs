package com.dardan.rrafshi.discogs.model.search;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class ArtistResult
{
	private long id;

	@JsonProperty("title")
	private String name;

	@JsonProperty("resource_url")
	private String resourceUrl;

	private String uri;

	@JsonProperty("thumb")
	private String thumbnail;

	@JsonProperty("cover_image")
	private String coverImage;


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

	public String getUri()
	{
		return this.uri;
	}

	public String getThumbnail()
	{
		return this.thumbnail;
	}

	public String getCoverImage()
	{
		return this.coverImage;
	}
}
