package com.dardan.rrafshi.discogs.model.release;

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

	public String getName()
	{
		return this.name;
	}

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public String getCategoryNumber()
	{
		return this.categoryNumber;
	}

	public String getEntityType()
	{
		return this.entityType;
	}

	public String getEntityTypeName()
	{
		return this.entityTypeName;
	}
}
