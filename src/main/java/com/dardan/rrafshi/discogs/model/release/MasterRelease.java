package com.dardan.rrafshi.discogs.model.release;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class MasterRelease
{
	private long id;

	private String title;

	@JsonProperty("resource_url")
	private String resourceUrl;

	private String uri;

	@JsonProperty("main_release")
	private long mainReleaseID;

	@JsonProperty("main_release_url")
	private String mainReleaseUrl;

	@JsonProperty("most_recent_release")
	private long mostRecentReleaseID;

	@JsonProperty("most_recent_release_url")
	private String mostRecentReleaseUrl;

	@JsonProperty("versions_url")
	private String versionsUrl;


	private int year;

	private List<String> genres;

	private List<String> styles;

	private List<Track> tracklist;

	private List<Artist> artists;


	private List<Video> videos;

	private List<Image> images;


	@JsonProperty("num_for_sale")
	private int numberForSale;

	@JsonProperty("lowest_price")
	private double lowestPrice;


	@JsonProperty("data_quality")
	private String dataQuality;


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

	public long getMainReleaseID()
	{
		return this.mainReleaseID;
	}

	public String getMainReleaseUrl()
	{
		return this.mainReleaseUrl;
	}

	public long getMostRecentReleaseID()
	{
		return this.mostRecentReleaseID;
	}

	public String getMostRecentReleaseUrl()
	{
		return this.mostRecentReleaseUrl;
	}

	public String getVersionsUrl()
	{
		return this.versionsUrl;
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

	public List<Track> getTracklist()
	{
		return this.tracklist;
	}

	public List<Artist> getArtists()
	{
		return this.artists;
	}

	public List<Video> getVideos()
	{
		return this.videos;
	}

	public List<Image> getImages()
	{
		return this.images;
	}

	public int getNumberForSale()
	{
		return this.numberForSale;
	}

	public double getLowestPrice()
	{
		return this.lowestPrice;
	}

	public String getDataQuality()
	{
		return this.dataQuality;
	}
}
