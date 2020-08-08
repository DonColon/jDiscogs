package com.dardan.rrafshi.discogs.examples;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.Discogs;
import com.dardan.rrafshi.discogs.DiscogsException;
import com.dardan.rrafshi.discogs.model.pagination.FilterFacet;
import com.dardan.rrafshi.discogs.model.pagination.Filters;
import com.dardan.rrafshi.discogs.model.pagination.Page;
import com.dardan.rrafshi.discogs.model.pagination.PageRequest;
import com.dardan.rrafshi.discogs.model.pagination.Pagination;
import com.dardan.rrafshi.discogs.model.release.Version;


public final class GetMasterReleaseVersions
{
	private static final Logger LOGGER = LoggerFactory.getLogger(GetMasterReleaseVersions.class);


	public static void main(final String[] args)
	{
		final String apiKey = Systems.getEnvironmentVariable(Constants.DISCOGS_API_KEY);
		final long masterID = 96559;

		try {
			final Discogs discogs = new Discogs(apiKey);
			final Page<Version> page = discogs.getMasterReleaseVersions(masterID, PageRequest.getDefault());

			final Pagination pagination = page.getPagination();

			final Filters filters = page.getFilters();
			final List<FilterFacet> filterFacets = page.getFilterFacets();

			final List<Version> content = page.getContent();

			System.out.println(page.isFirstPage());
			System.out.println(pagination.getTotalPages());
			System.out.println(filters.getValueHelps());
			System.out.println(filters.getAppliedFilters());
			System.out.println(filterFacets);
			System.out.println(content);

		} catch(final DiscogsException.RequestFailed exception) {

			LOGGER.error("Retrieve failed", exception);
		}
	}
}
