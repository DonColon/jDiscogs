package com.dardan.rrafshi.discogs.model.release;

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

	public String getDuration()
	{
		return this.duration;
	}

	public String getPosition()
	{
		return this.position;
	}

	public String getType()
	{
		return this.type;
	}
}
