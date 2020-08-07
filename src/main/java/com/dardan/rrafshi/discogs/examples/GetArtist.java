package com.dardan.rrafshi.discogs.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.Discogs;
import com.dardan.rrafshi.discogs.DiscogsException;
import com.dardan.rrafshi.discogs.model.release.Artist;


public final class GetArtist
{
	private static final Logger LOGGER = LoggerFactory.getLogger(GetArtist.class);


	public static void main(final String[] args)
	{
		final String apiKey = Systems.getEnvironmentVariable(Constants.DISCOGS_API_KEY);
		final long artistID = 72872;

		try {
			final Discogs discogs = new Discogs(apiKey);
			final Artist artist = discogs.getArtist(artistID);

			System.out.println(artist.getID() + " - " + artist.getName());

		} catch(final DiscogsException.RequestFailed exception) {

			LOGGER.error("Retrieve failed", exception);
		}
	}
}
