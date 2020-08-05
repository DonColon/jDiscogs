package com.dardan.rrafshi.discogs.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Label
{
	private long id;

	private String name;

	@JsonProperty("resource_url")
	private String resourceUrl;

	@JsonProperty("catno")
	private String categoryNumber;

	@JsonProperty("entity_type")
	private String entityType;

	@JsonProperty("entity_type_name")
	private String entityTypeName;


	public long getID()
	{
		return this.id;
	}

	public void setID(final long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public void setResourceUrl(final String resourceUrl)
	{
		this.resourceUrl = resourceUrl;
	}

	public String getCategoryNumber()
	{
		return this.categoryNumber;
	}

	public void setCategoryNumber(final String categoryNumber)
	{
		this.categoryNumber = categoryNumber;
	}

	public String getEntityType()
	{
		return this.entityType;
	}

	public void setEntityType(final String entityType)
	{
		this.entityType = entityType;
	}

	public String getEntityTypeName()
	{
		return this.entityTypeName;
	}

	public void setEntityTypeName(final String entityTypeName)
	{
		this.entityTypeName = entityTypeName;
	}
}
