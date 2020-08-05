package com.dardan.rrafshi.discogs.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Track
{
	private String title;

	private String duration;

	private String position;

	@JsonProperty("type_")
	private String type;


	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getDuration()
	{
		return this.duration;
	}

	public void setDuration(final String duration)
	{
		this.duration = duration;
	}

	public String getPosition()
	{
		return this.position;
	}

	public void setPosition(final String position)
	{
		this.position = position;
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
