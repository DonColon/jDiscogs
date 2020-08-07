package com.dardan.rrafshi.discogs.model.platform;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public final class Community
{
	private int have;

	private int want;

	private Rating rating;

	private User submitter;

	private List<User> contributors;

	private String status;

	@JsonProperty("data_quality")
	private String dataQuality;


	public int getHave()
	{
		return this.have;
	}

	public int getWant()
	{
		return this.want;
	}

	public Rating getRating()
	{
		return this.rating;
	}

	public User getSubmitter()
	{
		return this.submitter;
	}

	public List<User> getContributors()
	{
		return this.contributors;
	}

	public String getStatus()
	{
		return this.status;
	}

	public String getDataQuality()
	{
		return this.dataQuality;
	}
}
