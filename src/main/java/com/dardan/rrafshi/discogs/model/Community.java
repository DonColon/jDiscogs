package com.dardan.rrafshi.discogs.model;

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

	public void setHave(final int have)
	{
		this.have = have;
	}

	public int getWant()
	{
		return this.want;
	}

	public void setWant(final int want)
	{
		this.want = want;
	}

	public Rating getRating()
	{
		return this.rating;
	}

	public void setRating(final Rating rating)
	{
		this.rating = rating;
	}

	public User getSubmitter()
	{
		return this.submitter;
	}

	public void setSubmitter(final User submitter)
	{
		this.submitter = submitter;
	}

	public List<User> getContributors()
	{
		return this.contributors;
	}

	public void setContributors(final List<User> contributors)
	{
		this.contributors = contributors;
	}

	public String getStatus()
	{
		return this.status;
	}

	public void setStatus(final String status)
	{
		this.status = status;
	}

	public String getDataQuality()
	{
		return this.dataQuality;
	}

	public void setDataQuality(final String dataQuality)
	{
		this.dataQuality = dataQuality;
	}
}
