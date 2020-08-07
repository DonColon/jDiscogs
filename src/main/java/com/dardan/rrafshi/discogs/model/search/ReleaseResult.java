package com.dardan.rrafshi.discogs.model.search;

import java.util.List;

import com.dardan.rrafshi.discogs.model.platform.Community;
import com.fasterxml.jackson.annotation.JsonProperty;


public final class ReleaseResult
{
	private long id;

	private String title;

	@JsonProperty("resource_url")
	private String resourceUrl;

	private String uri;

	@JsonProperty("master_id")
	private long masterID;

	@JsonProperty("master_url")
	private String masterUrl;


	private String country;

	private int year;

	@JsonProperty("genre")
	private List<String> genres;

	@JsonProperty("style")
	private List<String> styles;

	@JsonProperty("thumb")
	private String thumbnail;

	@JsonProperty("cover_image")
	private String coverImage;

	@JsonProperty("label")
	private List<String> labels;


	@JsonProperty("format")
	private List<String> formats;

	@JsonProperty("barcode")
	private List<String> barcodes;

	@JsonProperty("format_quantity")
	private int formatQuantity;

	@JsonProperty("catno")
	private String categoryNumber;


	private Community community;


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

	public String getUri()
	{
		return this.uri;
	}

	public long getMasterID()
	{
		return this.masterID;
	}

	public String getMasterUrl()
	{
		return this.masterUrl;
	}

	public String getCountry()
	{
		return this.country;
	}


	public int getYear()
	{
		return this.year;
	}

	public List<String> getGenres()
	{
		return this.genres;
	}

	public List<String> getStyles()
	{
		return this.styles;
	}

	public String getThumbnail()
	{
		return this.thumbnail;
	}

	public String getCoverImage()
	{
		return this.coverImage;
	}

	public List<String> getLabels()
	{
		return this.labels;
	}

	public List<String> getFormats()
	{
		return this.formats;
	}

	public List<String> getBarcodes()
	{
		return this.barcodes;
	}

	public int getFormatQuantity()
	{
		return this.formatQuantity;
	}

	public String getCategoryNumber()
	{
		return this.categoryNumber;
	}

	public Community getCommunity()
	{
		return this.community;
	}
}
