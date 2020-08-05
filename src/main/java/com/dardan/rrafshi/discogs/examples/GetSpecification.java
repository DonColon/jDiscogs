package com.dardan.rrafshi.discogs.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.Discogs;
import com.dardan.rrafshi.discogs.DiscogsException;
import com.dardan.rrafshi.discogs.model.Specification;
import com.dardan.rrafshi.discogs.model.Statistics;


public final class GetSpecification
{
	private static final Logger LOGGER = LoggerFactory.getLogger(GetSpecification.class);


	public static void main(final String[] args)
	{
		final String apiKey = Systems.getEnvironmentVariable(Constants.DISCOGS_API_KEY);

		try {
			final Discogs discogs = new Discogs(apiKey);
			final Specification specification = discogs.getSpecification();
			final Statistics statistics = specification.getStatistics();

			System.out.println(specification.getMessage() + " Version " + specification.getVersion());
			System.out.println("Documentation at " + specification.getDocumentationUrl());

			System.out.println("\nStatistics");
			System.out.println("--------------------------------------------------");
			System.out.println("Releases: " + statistics.getReleases());
			System.out.println("Artists: " + statistics.getArtists());
			System.out.println("Labels: " + statistics.getLabels());

		} catch(final DiscogsException.RequestFailed exception) {

			LOGGER.error("Retrieve failed", exception);
		}
	}
}
