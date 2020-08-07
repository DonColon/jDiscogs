package com.dardan.rrafshi.discogs.model.search;

import java.util.ArrayList;
import java.util.List;

import com.dardan.rrafshi.discogs.deserializer.SearchResultDeserializer;
import com.dardan.rrafshi.discogs.model.pagination.Pagination;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(using=SearchResultDeserializer.class)
public final class SearchResult
{
	private Pagination pagination;

	private final List<ReleaseResult> releaseResults;

	private final List<ReleaseResult> masterReleaseResults;

	private final List<ArtistResult> artistResults;

	private final List<LabelResult> labelResults;


	public SearchResult(final Pagination pagination)
	{
		this();
		this.pagination = pagination;
	}

	public SearchResult()
	{
		this.releaseResults = new ArrayList<>();
		this.masterReleaseResults = new ArrayList<>();
		this.artistResults = new ArrayList<>();
		this.labelResults = new ArrayList<>();
	}


	public Pagination getPagination()
	{
		return this.pagination;
	}

	public void addReleaseResult(final ReleaseResult releaseResult)
	{
		this.releaseResults.add(releaseResult);
	}

	public List<ReleaseResult> getReleaseResults()
	{
		return this.releaseResults;
	}

	public void addMasterReleaseResult(final ReleaseResult releaseResult)
	{
		this.masterReleaseResults.add(releaseResult);
	}

	public List<ReleaseResult> getMasterReleaseResults()
	{
		return this.masterReleaseResults;
	}

	public void addArtistResult(final ArtistResult artistResult)
	{
		this.artistResults.add(artistResult);
	}

	public List<ArtistResult> getArtistResults()
	{
		return this.artistResults;
	}

	public void addLabelResult(final LabelResult labelResult)
	{
		this.labelResults.add(labelResult);
	}

	public List<LabelResult> getLabelResults()
	{
		return this.labelResults;
	}
}
