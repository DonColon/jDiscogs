package com.dardan.rrafshi.discogs;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.dardan.rrafshi.discogs.model.Specification;
import com.dardan.rrafshi.discogs.model.pagination.Direction;
import com.dardan.rrafshi.discogs.model.pagination.Filter;
import com.dardan.rrafshi.discogs.model.pagination.Page;
import com.dardan.rrafshi.discogs.model.pagination.PageRequest;
import com.dardan.rrafshi.discogs.model.pagination.Sort;
import com.dardan.rrafshi.discogs.model.platform.Currency;
import com.dardan.rrafshi.discogs.model.release.Artist;
import com.dardan.rrafshi.discogs.model.release.Label;
import com.dardan.rrafshi.discogs.model.release.MasterRelease;
import com.dardan.rrafshi.discogs.model.release.Release;
import com.dardan.rrafshi.discogs.model.release.Version;
import com.dardan.rrafshi.discogs.security.CredentialsAuthenticator;
import com.dardan.rrafshi.discogs.security.TokenAuthenticator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import okhttp3.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public final class Discogs
{
	private final ObjectMapper mapper;
	private final TypeFactory factory;
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

		this.factory = this.mapper.getTypeFactory();

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

	public MasterRelease getMasterRelease(final long masterID)
		throws DiscogsException.RequestFailed
	{
		final HttpUrl url = HttpUrl.parse(Constants.API_URL)
				.newBuilder()
				.addPathSegments(String.format(Endpoints.MASTER_RELEASE_GET, masterID))
				.build();

		try {
			return this.get(url, MasterRelease.class);

		} catch(DiscogsException.RequestFailed | DiscogsException.MappingFailed exception) {

			throw new DiscogsException.RequestFailed("Failed to get master release with ID '" + masterID + "'", exception);
		}
	}

	public Page<Version> getMasterReleaseVersions(final long masterID, final PageRequest request, final List<Filter> filters)
		throws DiscogsException.RequestFailed
	{
		final HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_URL)
				.newBuilder()
				.addPathSegments(String.format(Endpoints.MASTER_RELEASE_VERSIONS_GET, masterID))
				.addQueryParameter(Constants.PAGE, String.valueOf(request.getPage()))
				.addQueryParameter(Constants.PER_PAGE, String.valueOf(request.getSize()));

		if(!filters.isEmpty())
			for(final Filter filter : filters)
				for(final String value : filter.getValues())
					urlBuilder.addQueryParameter(filter.getKey(), value);

		final Sort sort = request.getSort();

		if(!sort.isUnsorted()) {
			final Direction direction = sort.getDirection();
			urlBuilder.addQueryParameter(Constants.SORT_ORDER, direction.getValue());

			for(final String property : sort.getProperties())
				urlBuilder.addQueryParameter(Constants.SORT, property);
		}

		final HttpUrl url = urlBuilder.build();
		final JavaType valueType = this.factory.constructParametricType(Page.class, Version.class);

		try {
			return this.get(url, valueType);

		} catch(DiscogsException.RequestFailed | DiscogsException.MappingFailed exception) {

			throw new DiscogsException.RequestFailed("Failed to get master release with ID '" + masterID + "'", exception);
		}
	}

	public Page<Version> getMasterReleaseVersions(final long masterID, final PageRequest request)
		throws DiscogsException.RequestFailed
	{
		return this.getMasterReleaseVersions(masterID, request, Collections.emptyList());
	}

	public Artist getArtist(final long artistID)
		throws DiscogsException.RequestFailed
	{
		final HttpUrl url = HttpUrl.parse(Constants.API_URL)
				.newBuilder()
				.addPathSegments(String.format(Endpoints.ARTIST_GET, artistID))
				.build();

		try {
			return this.get(url, Artist.class);

		} catch(DiscogsException.RequestFailed | DiscogsException.MappingFailed exception) {

			throw new DiscogsException.RequestFailed("Failed to get artist with ID '" + artistID + "'", exception);
		}
	}

	public Label getLabel(final long labelID)
		throws DiscogsException.RequestFailed
	{
		final HttpUrl url = HttpUrl.parse(Constants.API_URL)
				.newBuilder()
				.addPathSegments(String.format(Endpoints.LABEL_GET, labelID))
				.build();

		try {
			return this.get(url, Label.class);

		} catch(DiscogsException.RequestFailed | DiscogsException.MappingFailed exception) {

			throw new DiscogsException.RequestFailed("Failed to get label with ID '" + labelID + "'", exception);
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

			final String message = response.message();
			final int code = response.code();

			if(code != HttpStatus.OK)
				throw new DiscogsException.RequestFailed("Request failed with status code '" + code + ": " + message);

			return this.mapper.readValue(content, valueType);

		} catch(final JsonMappingException exception) {
			throw new DiscogsException.MappingFailed("Failed to map response to object of type '" + valueType + "'", exception);

		} catch(final IOException exception) {
			throw new DiscogsException.RequestFailed("Failed to get the element from '" + url + "'", exception);
		}
	}

	private <R> R get(final HttpUrl url, final JavaType valueType)
		throws DiscogsException.RequestFailed, DiscogsException.MappingFailed
	{
		final Request request = new Request.Builder()
				.url(url)
				.build();

		try(Response response = this.client.newCall(request).execute()) {
			final String content = response.body().string();

			final String message = response.message();
			final int code = response.code();

			if(code != HttpStatus.OK)
				throw new DiscogsException.RequestFailed("Request failed with status code '" + code + ": " + message);

			return this.mapper.readValue(content, valueType);

		} catch(final JsonMappingException exception) {
			throw new DiscogsException.MappingFailed("Failed to map response to object of type '" + valueType + "'", exception);

		} catch(final IOException exception) {
			throw new DiscogsException.RequestFailed("Failed to get the element from '" + url + "'", exception);
		}
	}
}
