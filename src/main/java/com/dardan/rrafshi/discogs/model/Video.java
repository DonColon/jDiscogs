package com.dardan.rrafshi.discogs.model;

public final class Video
{
	private String uri;

	private String title;

	private String description;

	private int duration;

	private boolean embed;


	public String getUri()
	{
		return this.uri;
	}

	public void setUri(final String uri)
	{
		this.uri = uri;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public int getDuration()
	{
		return this.duration;
	}

	public void setDuration(final int duration)
	{
		this.duration = duration;
	}

	public boolean isEmbed()
	{
		return this.embed;
	}

	public void setEmbed(final boolean embed)
	{
		this.embed = embed;
	}
}
