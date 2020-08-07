package com.dardan.rrafshi.discogs.model.release;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Label
{
	private long id;

	private String name;

	@JsonProperty("contact_info")
	private String contactInfo;

	private String profile;


	private String uri;

	@JsonProperty("resource_url")
	private String resourceUrl;

	@JsonProperty("releases_url")
	private String releasesUrl;


	private List<String> urls;

	@JsonProperty("catno")
	private String categoryNumber;

	@JsonProperty("entity_type")
	private String entityType;

	@JsonProperty("entity_type_name")
	private String entityTypeName;

	private Label parentLabel;

	private List<Label> subLabels;

	private List<Image> images;


	@JsonProperty("data_quality")
	private String dataQuality;


	public long getID()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public String getContactInfo()
	{
		return this.contactInfo;
	}

	public String getProfile()
	{
		return this.profile;
	}

	public String getUri()
	{
		return this.uri;
	}

	public String getResourceUrl()
	{
		return this.resourceUrl;
	}

	public String getReleasesUrl()
	{
		return this.releasesUrl;
	}

	public List<String> getUrls()
	{
		return this.urls;
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

	public Label getParentLabel()
	{
		return this.parentLabel;
	}

	public List<Label> getSubLabels()
	{
		return this.subLabels;
	}

	public List<Image> getImages()
	{
		return this.images;
	}

	public String getDataQuality()
	{
		return this.dataQuality;
	}
}
