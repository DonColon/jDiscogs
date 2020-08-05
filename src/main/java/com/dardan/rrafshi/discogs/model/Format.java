package com.dardan.rrafshi.discogs.model;

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

	public void setName(final String name)
	{
		this.name = name;
	}

	public int getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(final int quantity)
	{
		this.quantity = quantity;
	}

	public List<String> getDescriptions()
	{
		return this.descriptions;
	}

	public void setDescriptions(final List<String> descriptions)
	{
		this.descriptions = descriptions;
	}
}
