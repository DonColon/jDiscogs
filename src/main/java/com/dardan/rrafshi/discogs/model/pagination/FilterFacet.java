package com.dardan.rrafshi.discogs.model.pagination;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class FilterFacet
{
	private String id;

	private String title;

	private List<FacetValue> values;

	@JsonProperty("allows_multiple_values")
	private boolean multiSelect;


	public String getID()
	{
		return this.id;
	}

	public String getTitle()
	{
		return this.title;
	}

	public List<FacetValue> getValues()
	{
		return this.values;
	}

	public boolean isMultiSelect()
	{
		return this.multiSelect;
	}
}
