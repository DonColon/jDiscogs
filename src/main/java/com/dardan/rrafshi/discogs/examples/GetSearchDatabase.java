package com.dardan.rrafshi.discogs.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.Discogs;
import com.dardan.rrafshi.discogs.DiscogsException;
import com.dardan.rrafshi.discogs.model.pagination.PageRequest;
import com.dardan.rrafshi.discogs.model.pagination.Pagination;
import com.dardan.rrafshi.discogs.model.search.SearchResult;


public final class GetSearchDatabase
{
	private static final Logger LOGGER = LoggerFactory.getLogger(GetMasterReleaseVersions.class);


	public static void main(final String[] args)
	{
		final String apiKey = Systems.getEnvironmentVariable(Constants.DISCOGS_API_KEY);
		final String searchText = "nirvana";

		try {
			final Discogs discogs = new Discogs(apiKey);
			final SearchResult result = discogs.search(searchText, PageRequest.getDefault());

			final Pagination pagination = result.getPagination();

			System.out.println(pagination.getTotalPages());
			System.out.println(result.getReleaseResults());
			System.out.println(result.getMasterReleaseResults());
			System.out.println(result.getArtistResults());
			System.out.println(result.getLabelResults());

		} catch(final DiscogsException.RequestFailed exception) {

			LOGGER.error("Retrieve failed", exception);
		}
	}
}
