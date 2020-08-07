package com.dardan.rrafshi.discogs.model.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Pagination
{
	@JsonProperty("per_page")
	private int itemsPerPage;

	@JsonProperty("items")
	private int numberOfItems;

	@JsonProperty("page")
	private int currentPage;

	@JsonProperty("pages")
	private int totalPages;


	public int getItemsPerPage()
	{
		return this.itemsPerPage;
	}

	public int getNumberOfItems()
	{
		return this.numberOfItems;
	}

	public int getCurrentPage()
	{
		return this.currentPage;
	}

	public int getTotalPages()
	{
		return this.totalPages;
	}
}
