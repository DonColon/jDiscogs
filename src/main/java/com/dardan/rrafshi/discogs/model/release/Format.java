package com.dardan.rrafshi.discogs.model.release;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Format
{
	private String name;

	@JsonProperty("qty")
	private int quantity;

	private List<String> descriptions;


	public String getName()
	{
		return this.name;
	}

	public int getQuantity()
	{
		return this.quantity;
	}

	public List<String> getDescriptions()
	{
		return this.descriptions;
	}
}
