package com.dardan.rrafshi.discogs.model.pagination;

public enum Direction
{
	ASC("asc"),
	DESC("desc"),
	;

	private String value;

	private Direction(final String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return this.value;
	}
}
