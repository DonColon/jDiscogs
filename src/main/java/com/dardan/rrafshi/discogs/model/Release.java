package com.dardan.rrafshi.discogs.model;

import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.util.List;

import com.dardan.rrafshi.discogs.deserializer.ReleasedDeserializer;
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

	public void setID(final long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public void setResourceUrl(final String resourceUrl)
	{
		this.resourceUrl = resourceUrl;
	}

	public String getUri()
	{
		return this.uri;
	}

	public void setUri(final String uri)
	{
		this.uri = uri;
	}

	public long getMasterID()
	{
		return this.masterID;
	}

	public void setMasterID(final long masterID) {

		this.masterID = masterID;
	}

	public String getMasterUrl()
	{
		return this.masterUrl;
	}

	public void setMasterUrl(final String masterUrl)
	{
		this.masterUrl = masterUrl;
	}

	public String getCountry()
	{
		return this.country;
	}

	public void setCountry(final String country)
	{
		this.country = country;
	}

	public int getYear()
	{
		return this.year;
	}

	public void setYear(final int year)
	{
		this.year = year;
	}

	public YearMonth getReleased()
	{
		return this.released;
	}

	public void setReleased(final YearMonth released)
	{
		this.released = released;
	}

	public String getReleasedFormatted()
	{
		return this.releasedFormatted;
	}

	public void setReleasedFormatted(final String releasedFormatted)
	{
		this.releasedFormatted = releasedFormatted;
	}

	public List<String> getGenres()
	{
		return this.genres;
	}

	public void setGenres(final List<String> genres)
	{
		this.genres = genres;
	}

	public List<String> getStyles()
	{
		return this.styles;
	}

	public void setStyles(final List<String> styles)
	{
		this.styles = styles;
	}

	public List<Track> getTracklist()
	{
		return this.tracklist;
	}

	public void setTracklist(final List<Track> tracklist)
	{
		this.tracklist = tracklist;
	}

	public List<Artist> getArtists()
	{
		return this.artists;
	}

	public void setArtists(final List<Artist> artists)
	{
		this.artists = artists;
	}

	public String getArtistsSort()
	{
		return this.artistsSort;
	}

	public void setArtistsSort(final String artistsSort)
	{
		this.artistsSort = artistsSort;
	}

	public List<Artist> getExtraArtists()
	{
		return this.extraArtists;
	}

	public void setExtraArtists(final List<Artist> extraArtists) {

		this.extraArtists = extraArtists;
	}

	public String getThumbnail()
	{
		return this.thumbnail;
	}

	public void setThumbnail(final String thumbnail)
	{
		this.thumbnail = thumbnail;
	}

	public List<Video> getVideos()
	{
		return this.videos;
	}

	public void setVideos(final List<Video> videos)
	{
		this.videos = videos;
	}

	public List<Image> getImages()
	{
		return this.images;
	}

	public void setImages(final List<Image> images)
	{
		this.images = images;
	}

	public List<Label> getLabels()
	{
		return this.labels;
	}

	public void setLabels(final List<Label> labels)
	{
		this.labels = labels;
	}

	public List<Label> getCompanies()
	{
		return this.companies;
	}

	public void setCompanies(final List<Label> companies)
	{
		this.companies = companies;
	}

	public List<Format> getFormats()
	{
		return this.formats;
	}

	public void setFormats(final List<Format> formats)
	{
		this.formats = formats;
	}

	public List<Identifier> getIdentifiers()
	{
		return this.identifiers;
	}

	public void setIdentifiers(final List<Identifier> identifiers)
	{
		this.identifiers = identifiers;
	}

	public int getFormatQuantity()
	{
		return this.formatQuantity;
	}

	public void setFormatQuantity(final int formatQuantity)
	{
		this.formatQuantity = formatQuantity;
	}

	public int getNumberForSale()
	{
		return this.numberForSale;
	}

	public void setNumberForSale(final int numberForSale)
	{
		this.numberForSale = numberForSale;
	}

	public double getLowestPrice()
	{
		return this.lowestPrice;
	}

	public void setLowestPrice(final double lowestPrice)
	{
		this.lowestPrice = lowestPrice;
	}

	public int getEstimatedWeight()
	{
		return this.estimatedWeight;
	}

	public void setEstimatedWeight(final int estimatedWeight)
	{
		this.estimatedWeight = estimatedWeight;
	}

	public String getNotes()
	{
		return this.notes;
	}

	public void setNotes(final String notes)
	{
		this.notes = notes;
	}

	public String getStatus()
	{
		return this.status;
	}

	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getDataQuality()
	{
		return this.dataQuality;
	}

	public void setDataQuality(final String dataQuality)
	{
		this.dataQuality = dataQuality;
	}

	public Community getCommunity()
	{
		return this.community;
	}

	public void setCommunity(final Community community)
	{
		this.community = community;
	}

	public ZonedDateTime getDateAdded()
	{
		return this.dateAdded;
	}

	public void setDateAdded(final ZonedDateTime dateAdded)
	{
		this.dateAdded = dateAdded;
	}

	public ZonedDateTime getDateChanged()
	{
		return this.dateChanged;
	}

	public void setDateChanged(final ZonedDateTime dateChanged)
	{
		this.dateChanged = dateChanged;
	}
}
