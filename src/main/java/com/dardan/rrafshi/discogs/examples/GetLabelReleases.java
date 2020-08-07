package com.dardan.rrafshi.discogs.examples;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.Discogs;
import com.dardan.rrafshi.discogs.DiscogsException;
import com.dardan.rrafshi.discogs.model.pagination.Page;
import com.dardan.rrafshi.discogs.model.pagination.PageRequest;
import com.dardan.rrafshi.discogs.model.pagination.Pagination;
import com.dardan.rrafshi.discogs.model.release.SimpleRelease;


public final class GetLabelReleases
{
	private static final Logger LOGGER = LoggerFactory.getLogger(GetLabelReleases.class);


	public static void main(final String[] args)
	{
		final String apiKey = Systems.getEnvironmentVariable(Constants.DISCOGS_API_KEY);
		final long labelID = 895;

		try {
			final Discogs discogs = new Discogs(apiKey);
			final Page<SimpleRelease> page = discogs.getLabelReleases(labelID, PageRequest.getDefault());

			final Pagination pagination = page.getPagination();
			final List<SimpleRelease> content = page.getContent();

			System.out.println(pagination.getTotalPages());
			System.out.println(content);

		} catch(final DiscogsException.RequestFailed exception) {

			LOGGER.error("Retrieve failed", exception);
		}
	}
}
