package com.dardan.rrafshi.discogs.model.pagination;

import java.util.Arrays;
import java.util.List;


public final class Filter
{
	private final String key;
	private final List<String> values;


	private Filter(final String key, final List<String> values)
	{
		this.key = key;
		this.values = values;
	}

	private Filter(final String key, final String... values)
	{
		this(key, Arrays.asList(values));
	}


	public static Filter of(final String key, final List<String> values)
	{
		return new Filter(key, values);
	}

	public static Filter of(final String key, final String... values)
	{
		return new Filter(key, values);
	}


	public String getKey()
	{
		return this.key;
	}

	public List<String> getValues()
	{
		return this.values;
	}
}
