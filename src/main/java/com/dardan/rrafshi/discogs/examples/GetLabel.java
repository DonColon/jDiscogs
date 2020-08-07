package com.dardan.rrafshi.discogs.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dardan.rrafshi.commons.Systems;
import com.dardan.rrafshi.discogs.Constants;
import com.dardan.rrafshi.discogs.Discogs;
import com.dardan.rrafshi.discogs.DiscogsException;
import com.dardan.rrafshi.discogs.model.release.Label;


public final class GetLabel
{
	private static final Logger LOGGER = LoggerFactory.getLogger(GetArtist.class);


	public static void main(final String[] args)
	{
		final String apiKey = Systems.getEnvironmentVariable(Constants.DISCOGS_API_KEY);
		final long labelID = 895;

		try {
			final Discogs discogs = new Discogs(apiKey);
			final Label label = discogs.getLabel(labelID);

			System.out.println(label.getID() + " - " + label.getName());

		} catch(final DiscogsException.RequestFailed exception) {

			LOGGER.error("Retrieve failed", exception);
		}
	}
}
