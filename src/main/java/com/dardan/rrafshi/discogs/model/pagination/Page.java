package com.dardan.rrafshi.discogs.model.pagination;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;


public final class Page<T>
{
	private Pagination pagination;

	private Filters filters;

	@JsonProperty("filter_facets")
	private List<FilterFacet> filterFacets;

	private List<T> content;


	public Pagination getPagination()
	{
		return this.pagination;
	}

	public Filters getFilters()
	{
		return this.filters;
	}

	public List<FilterFacet> getFilterFacets()
	{
		return this.filterFacets;
	}

	public List<T> getContent()
	{
		return this.content;
	}

	@JsonAnySetter
	private void setContent(final String name, final List<T> content)
	{
		this.content = content;
	}
}
