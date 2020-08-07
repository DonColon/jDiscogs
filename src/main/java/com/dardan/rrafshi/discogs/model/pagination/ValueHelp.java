package com.dardan.rrafshi.discogs.model.pagination;

import java.util.Map;


public final class ValueHelp
{
	private final String key;
	private final Map<String, Integer> values;


	public ValueHelp(final String key, final Map<String, Integer> values)
	{
		this.key = key;
		this.values = values;
	}


	public String getKey()
	{
		return this.key;
	}

	public Map<String, Integer> getValues()
	{
		return this.values;
	}
}
