package com.dardan.rrafshi.discogs.model;

public final class Statistics
{
	private long releases;

	private long artists;

	private long labels;


	public long getReleases()
	{
		return this.releases;
	}

	public void setReleases(final long releases)
	{
		this.releases = releases;
	}

	public long getArtists()
	{
		return this.artists;
	}

	public void setArtists(final long artists)
	{
		this.artists = artists;
	}

	public long getLabels()
	{
		return this.labels;
	}

	public void setLabels(final long labels)
	{
		this.labels = labels;
	}
}
