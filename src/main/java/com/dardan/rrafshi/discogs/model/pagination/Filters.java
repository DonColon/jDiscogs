package com.dardan.rrafshi.discogs.model.pagination;

import java.util.List;

import com.dardan.rrafshi.discogs.deserializer.AppliedFiltersDeserializer;
import com.dardan.rrafshi.discogs.deserializer.ValueHelpDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public final class Filters
{
	@JsonProperty("applied")
	@JsonDeserialize(using=AppliedFiltersDeserializer.class)
	private List<Filter> appliedFilters;

	@JsonProperty("available")
	@JsonDeserialize(using=ValueHelpDeserializer.class)
	private List<ValueHelp> valueHelps;


	public List<Filter> getAppliedFilters()
	{
		return this.appliedFilters;
	}

	public List<ValueHelp> getValueHelps()
	{
		return this.valueHelps;
	}
}
