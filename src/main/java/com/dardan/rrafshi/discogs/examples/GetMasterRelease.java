package com.dardan.rrafshi.discogs.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.Discogs;
import com.dardan.rrafshi.discogs.DiscogsException;
import com.dardan.rrafshi.discogs.model.release.MasterRelease;


public final class GetMasterRelease
{
	private static final Logger LOGGER = LoggerFactory.getLogger(GetMasterRelease.class);


	public static void main(final String[] args)
	{
		final String apiKey = Systems.getEnvironmentVariable(Constants.DISCOGS_API_KEY);
		final long masterID = 96559;

		try {
			final Discogs discogs = new Discogs(apiKey);
			final MasterRelease release = discogs.getMasterRelease(masterID);

			System.out.println(release.getTitle());
			System.out.println(release.getYear());
			System.out.println(release.getGenres());

		} catch(final DiscogsException.RequestFailed exception) {

			LOGGER.error("Retrieve failed", exception);
		}
	}
}
