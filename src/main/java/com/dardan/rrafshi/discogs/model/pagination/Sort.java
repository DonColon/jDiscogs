package com.dardan.rrafshi.discogs.model.pagination;

import java.util.Arrays;
import java.util.List;


public final class Sort
{
	private static final Direction DEFAULT_DIRECTION = Direction.ASC;
	private static final Sort UNSORTED = new Sort(new String[0]);


	private final Direction direction;
	private final List<String> properties;


	private Sort(final Direction direction, final List<String> properties)
	{
		this.direction = direction;
		this.properties = properties;
	}

	private Sort(final List<String> properties)
	{
		this(DEFAULT_DIRECTION, properties);
	}

	private Sort(final Direction direction, final String... properties)
	{
		this(direction, Arrays.asList(properties));
	}

	private Sort(final String... properties)
	{
		this(Arrays.asList(properties));
	}


	public static Sort by(final Direction direction, final List<String> properties)
	{
		return new Sort(direction, properties);
	}

	public static Sort by(final Direction direction, final String... properties)
	{
		return new Sort(direction, properties);
	}

	public static Sort by(final List<String> properties)
	{
		return new Sort(properties);
	}

	public static Sort by(final String... properties)
	{
		return new Sort(properties);
	}

	public static Sort unsorted()
	{
		return UNSORTED;
	}


	public Direction getDirection()
	{
		return this.direction;
	}

	public List<String> getProperties()
	{
		return this.properties;
	}

	public boolean isUnsorted()
	{
		return this.properties.isEmpty();
	}
}
