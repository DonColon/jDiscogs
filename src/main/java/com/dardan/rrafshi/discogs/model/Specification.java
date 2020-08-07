package com.dardan.rrafshi.discogs.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Specification
{
	@JsonProperty("hello")
	private String message;

	@JsonProperty("api_version")
	private String version;

	@JsonProperty("documentation_url")
	private String documentationUrl;

	private Statistics statistics;


	public String getMessage()
	{
		return this.message;
	}

	public String getVersion()
	{
		return this.version;
	}

	public String getDocumentationUrl()
	{
		return this.documentationUrl;
	}

	public Statistics getStatistics()
	{
		return this.statistics;
	}
}
