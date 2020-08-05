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

	public void setMessage(final String message)
	{
		this.message = message;
	}

	public String getVersion()
	{
		return this.version;
	}

	public void setVersion(final String version)
	{
		this.version = version;
	}

	public String getDocumentationUrl()
	{
		return this.documentationUrl;
	}

	public void setDocumentationUrl(final String documentationUrl)
	{
		this.documentationUrl = documentationUrl;
	}

	public Statistics getStatistics()
	{
		return this.statistics;
	}

	public void setStatistics(final Statistics statistics)
	{
		this.statistics = statistics;
	}
}
