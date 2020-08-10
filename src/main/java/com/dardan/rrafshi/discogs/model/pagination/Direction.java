package com.dardan.rrafshi.discogs.model.pagination;

public enum Direction
{
	ASC("asc"),
	DESC("desc"),
	;

	private String value;

	Direction(final String value)
	{
		this.value = value;
	}

	public static Direction of(final String value)
	{
		for(final Direction direction : Direction.values())
			if(direction.value.equals(value))
				return direction;

		return null;
	}

	public String getValue()
	{
		return this.value;
	}
}
