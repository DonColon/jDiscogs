package com.dardan.rrafshi.discogs.model.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class PageUrls
{
	private String first;

	private String last;

	@JsonProperty("prev")
	private String previous;

	private String next;


	public String getFirst()
	{
		return this.first;
	}

	public String getLast()
	{
		return this.last;
	}

	public String getPrevious()
	{
		return this.previous;
	}

	public String getNext()
	{
		return this.next;
	}
}
