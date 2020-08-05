package com.dardan.rrafshi.discogs.model;

public final class Rating
{
	private int count;

	private double average;


	public int getCount()
	{
		return this.count;
	}

	public void setCount(final int count)
	{
		this.count = count;
	}

	public double getAverage()
	{
		return this.average;
	}

	public void setAverage(final double average)
	{
		this.average = average;
	}
}
