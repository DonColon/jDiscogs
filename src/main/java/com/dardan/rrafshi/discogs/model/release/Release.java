package com.dardan.rrafshi.discogs.model.release;

import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.List;

import com.dardan.rrafshi.discogs.deserializer.ReleasedDeserializer;
import com.dardan.rrafshi.discogs.model.platform.Community;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public final class Release
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

	@JsonDeserialize(using=ReleasedDeserializer.class)
	private YearMonth released;

	@JsonProperty("released_formatted")
	private String releasedFormatted;


	private List<String> genres;

	private List<String> styles;

	private List<Track> tracklist;


	private List<Artist> artists;

	@JsonProperty("artists_sort")
	private String artistsSort;

	@JsonProperty("extraartists")
	private List<Artist> extraArtists;


	@JsonProperty("thumb")
	private String thumbnail;

	private List<Video> videos;

	private List<Image> images;


	private List<Label> labels;

	private List<Label> companies;


	private List<Format> formats;

	private List<Identifier> identifiers;

	@JsonProperty("format_quantity")
	private int formatQuantity;

	@JsonProperty("num_for_sale")
	private int numberForSale;

	@JsonProperty("lowest_price")
	private double lowestPrice;

	@JsonProperty("estimated_weight")
	private int estimatedWeight;

	private String notes;


	private String status;

	@JsonProperty("data_quality")
	private String dataQuality;

	private Community community;

	@JsonProperty("date_added")
	private ZonedDateTime dateAdded;

	@JsonProperty("date_changed")
	private ZonedDateTime dateChanged;


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

	public YearMonth getReleased()
	{
		return this.released;
	}

	public String getReleasedFormatted()
	{
		return this.releasedFormatted;
	}

	public List<String> getGenres()
	{
		return this.genres;
	}

	public List<String> getStyles()
	{
		return this.styles;
	}

	public List<Track> getTracklist()
	{
		return this.tracklist;
	}

	public List<Artist> getArtists()
	{
		return this.artists;
	}

	public String getArtistsSort()
	{
		return this.artistsSort;
	}

	public List<Artist> getExtraArtists()
	{
		return this.extraArtists;
	}

	public String getThumbnail()
	{
		return this.thumbnail;
	}

	public List<Video> getVideos()
	{
		return this.videos;
	}

	public List<Image> getImages()
	{
		return this.images;
	}

	public List<Label> getLabels()
	{
		return this.labels;
	}

	public List<Label> getCompanies()
	{
		return this.companies;
	}

	public List<Format> getFormats()
	{
		return this.formats;
	}

	public List<Identifier> getIdentifiers()
	{
		return this.identifiers;
	}

	public int getFormatQuantity()
	{
		return this.formatQuantity;
	}

	public int getNumberForSale()
	{
		return this.numberForSale;
	}

	public double getLowestPrice()
	{
		return this.lowestPrice;
	}

	public int getEstimatedWeight()
	{
		return this.estimatedWeight;
	}

	public String getNotes()
	{
		return this.notes;
	}

	public String getStatus()
	{
		return this.status;
	}

	public String getDataQuality()
	{
		return this.dataQuality;
	}

	public Community getCommunity()
	{
		return this.community;
	}

	public ZonedDateTime getDateAdded()
	{
		return this.dateAdded;
	}

	public ZonedDateTime getDateChanged()
	{
		return this.dateChanged;
	}
}
