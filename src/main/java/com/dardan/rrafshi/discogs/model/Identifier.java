package com.dardan.rrafshi.discogs.model;

public final class Identifier
{
	private String type;

	private String value;

	private String description;


	public String getType()
	{
		return this.type;
	}

	public void setType(final String type)
	{
		this.type = type;
	}

	public String getValue()
	{
		return this.value;
	}

	public void setValue(final String value)
	{
		this.value = value;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}
}
