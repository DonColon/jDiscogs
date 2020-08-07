package com.dardan.rrafshi.discogs.model.release;

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

	public String getTitle()
	{
		return this.title;
	}

	public String getDescription()
	{
		return this.description;
	}

	public int getDuration()
	{
		return this.duration;
	}

	public boolean isEmbed()
	{
		return this.embed;
	}
}
