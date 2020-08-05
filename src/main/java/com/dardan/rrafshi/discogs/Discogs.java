package com.dardan.rrafshi.discogs;

import java.io.IOException;

import com.dardan.rrafshi.discogs.model.Currency;
import com.dardan.rrafshi.discogs.model.Release;
import com.dardan.rrafshi.discogs.model.Specification;
import com.dardan.rrafshi.discogs.security.CredentialsAuthenticator;
import com.dardan.rrafshi.discogs.security.TokenAuthenticator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import okhttp3.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public final class Discogs
{
	private final ObjectMapper mapper;
	private final OkHttpClient client;


	public Discogs(final String apiKey)
	{
		this(new TokenAuthenticator(apiKey));
	}

	public Discogs(final String key, final String secret)
	{
		this(new CredentialsAuthenticator(key, secret));
	}

	private Discogs(final Authenticator authenticator)
	{
		this.mapper = new ObjectMapper();
		this.mapper.registerModule(new JavaTimeModule());
		this.mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		this.client = new OkHttpClient.Builder()
				.authenticator(authenticator)
				.build();
	}


	public Specification getSpecification()
		throws DiscogsException.RequestFailed
	{
		final HttpUrl url = HttpUrl.parse(Constants.API_URL);

		try {
			return this.get(url, Specification.class);

		} catch(DiscogsException.RequestFailed | DiscogsException.MappingFailed exception) {

			throw new DiscogsException.RequestFailed("Failed to get specification of the API", exception);
		}
	}

	public Release getRelease(final long releaseID, final Currency currency)
		throws DiscogsException.RequestFailed
	{
		final HttpUrl url = HttpUrl.parse(Constants.API_URL)
				.newBuilder()
				.addPathSegments(String.format(Endpoints.RELEASE_GET, releaseID))
				.addQueryParameter(Constants.CURR_ABBR, currency.name())
				.build();

		try {
			return this.get(url, Release.class);

		} catch(DiscogsException.RequestFailed | DiscogsException.MappingFailed exception) {

			throw new DiscogsException.RequestFailed("Failed to get release with ID '" + releaseID + "'", exception);
		}
	}

	public Release getRelease(final long releaseID)
		throws DiscogsException.RequestFailed
	{
		final HttpUrl url = HttpUrl.parse(Constants.API_URL)
				.newBuilder()
				.addPathSegments(String.format(Endpoints.RELEASE_GET, releaseID))
				.build();

		try {
			return this.get(url, Release.class);

		} catch(DiscogsException.RequestFailed | DiscogsException.MappingFailed exception) {

			throw new DiscogsException.RequestFailed("Failed to get release with ID '" + releaseID + "'", exception);
		}
	}


	private <R> R get(final HttpUrl url, final Class<R> valueType)
		throws DiscogsException.RequestFailed, DiscogsException.MappingFailed
	{
		final Request request = new Request.Builder()
				.url(url)
				.build();

		try(Response response = this.client.newCall(request).execute()) {
			final String content = response.body().string();
			return this.mapper.readValue(content, valueType);

		} catch(final JsonMappingException exception) {
			throw new DiscogsException.MappingFailed("Failed to map response to object of type '" + valueType + "'", exception);

		} catch(final IOException exception) {
			throw new DiscogsException.RequestFailed("Failed to get the element from '" + url + "'", exception);
		}
	}
}
