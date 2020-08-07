package com.dardan.rrafshi.discogs.model.release;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Artist
{
	private long id;

	private String name;

	@JsonProperty("realname")
	private String realName;

	private String profile;


	private String uri;

	@JsonProperty("resource_url")
	private String resourceUrl;

	@JsonProperty("releases_url")
	private String releasesUrl;

	@JsonProperty("thumbnail_url")
	private String thumbnailUrl;


	private List<String> urls;

	@JsonProperty("namevariations")
	private List<String> nameVariations;

	private List<Artist> aliases;

	private List<Artist> groups;

	private List<Artist> members;

	private String join;

	private String role;

	private List<Image> images;

	private String tracks;


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

	public String getRealName()
	{
		return this.realName;
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

	public String getThumbnailUrl()
	{
		return this.thumbnailUrl;
	}

	public List<String> getUrls()
	{
		return this.urls;
	}

	public List<String> getNameVariations()
	{
		return this.nameVariations;
	}

	public List<Artist> getAliases()
	{
		return this.aliases;
	}

	public List<Artist> getGroups()
	{
		return this.groups;
	}

	public List<Artist> getMembers()
	{
		return this.members;
	}

	public String getJoin()
	{
		return this.join;
	}

	public String getRole()
	{
		return this.role;
	}

	public List<Image> getImages()
	{
		return this.images;
	}

	public String getTracks()
	{
		return this.tracks;
	}

	public String getDataQuality()
	{
		return this.dataQuality;
	}
}
