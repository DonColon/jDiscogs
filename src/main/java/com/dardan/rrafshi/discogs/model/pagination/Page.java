package com.dardan.rrafshi.discogs.model.pagination;

import java.util.List;

import com.dardan.rrafshi.discogs.Constants;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import okhttp3.HttpUrl;


public final class Page<T>
{
	private Pagination pagination;

	private Filters filters;

	@JsonProperty("filter_facets")
	private List<FilterFacet> filterFacets;

	private List<T> content;


	public PageRequest nextPage()
	{
		final HttpUrl url = HttpUrl.parse(this.pagination.getNext());

		final Direction direction = Direction.of(url.queryParameter(Constants.SORT_ORDER));
		final List<String> properties = url.queryParameterValues(Constants.SORT);

		final Sort sort = (direction == null) ? Sort.by(properties) : Sort.by(direction, properties);

		return PageRequest.of(this.pagination.getCurrentPage() + 1, this.pagination.getItemsPerPage(), sort);
	}

	public PageRequest previousPage()
	{
		final HttpUrl url = HttpUrl.parse(this.pagination.getPrevious());

		final Direction direction = Direction.of(url.queryParameter(Constants.SORT_ORDER));
		final List<String> properties = url.queryParameterValues(Constants.SORT);

		final Sort sort = (direction == null) ? Sort.by(properties) : Sort.by(direction, properties);

		return PageRequest.of(this.pagination.getCurrentPage() - 1, this.pagination.getItemsPerPage(), sort);
	}

	public boolean hasNextPage()
	{
		return this.pagination.getCurrentPage() < this.pagination.getTotalPages();
	}

	public boolean hasPreviousPage()
	{
		return this.pagination.getCurrentPage() > PageRequest.DEFAULT_PAGE;
	}

	public boolean isFirstPage()
	{
		return this.pagination.getCurrentPage() == PageRequest.DEFAULT_PAGE;
	}

	public boolean isLastPage()
	{
		return this.pagination.getCurrentPage() == this.pagination.getTotalPages();
	}


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
