package com.dardan.rrafshi.discogs.model.pagination;

public final class FacetValue
{
	private String title;

	private String value;

	private int count;


	public String getTitle()
	{
		return this.title;
	}

	public String getValue()
	{
		return this.value;
	}

	public int getCount()
	{
		return this.count;
	}
}
