package com.dardan.rrafshi.discogs;

import java.io.IOException;
import java.util.UUID;

import com.dardan.rrafshi.discogs.model.AccessToken;
import com.dardan.rrafshi.discogs.model.Credentials;
import com.dardan.rrafshi.discogs.model.RequestToken;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public final class OAuthFlow
{
	private final OkHttpClient client;
	private final Credentials credentials;


	public OAuthFlow(final String key, final String secret)
	{
		this(Credentials.of(key, secret));
	}

	public OAuthFlow(final Credentials credentials)
	{
		this.client = new OkHttpClient();
		this.credentials = credentials;
	}


	public RequestToken getRequestToken()
		throws DiscogsException.RequestFailed
	{
		final HttpUrl url = HttpUrl.parse(Constants.API_URL)
				.newBuilder()
				.addPathSegments(Endpoints.REQUEST_TOKEN_GET)
				.build();

		final Headers headers = new Headers.Builder()
				.add(Constants.AUTHORIZATION, this.generateRequestTokenHeader())
				.add(Constants.CONTENT_TYPE, Constants.OAUTH_CONTENT_TYPE)
				.add(Constants.USER_AGENT, Constants.OAUTH_USER_AGENT)
				.build();

		try {
			final String urlEncoded = this.get(url, headers);
			return RequestToken.parse(urlEncoded);

		} catch(final DiscogsException.RequestFailed exception) {

			throw new DiscogsException.RequestFailed("Failed to get request token", exception);
		}
	}

	public AccessToken getAccessToken(final RequestToken token, final String verifierCode)
		throws DiscogsException.RequestFailed
	{
		final HttpUrl url = HttpUrl.parse(Constants.API_URL)
				.newBuilder()
				.addPathSegments(Endpoints.ACCESS_TOKEN_POST)
				.build();

		final Headers headers = new Headers.Builder()
				.add(Constants.AUTHORIZATION, this.generateAccessTokenHeader(token, verifierCode))
				.add(Constants.CONTENT_TYPE, Constants.OAUTH_CONTENT_TYPE)
				.add(Constants.USER_AGENT, Constants.OAUTH_USER_AGENT)
				.build();

		final RequestBody body = RequestBody.create("", null);

		try {
			final String urlEncoded = this.post(url, headers, body);
			return AccessToken.parse(urlEncoded);

		} catch(final DiscogsException.RequestFailed exception) {

			throw new DiscogsException.RequestFailed("Failed to get access token", exception);
		}
	}


	private String generateRequestTokenHeader()
	{
		final StringBuilder builder = new StringBuilder("OAuth ");

		builder.append(String.format(Constants.OAUTH_CONSUMER_KEY, this.credentials.getKey()));
		builder.append(String.format(Constants.OAUTH_NONCE, UUID.randomUUID()));
		builder.append(String.format(Constants.OAUTH_REQUEST_SIGNATURE, this.credentials.getSecret()));
		builder.append(Constants.OAUTH_SIGNATURE_METHOD);
		builder.append(String.format(Constants.OAUTH_TIMESTAMP, System.currentTimeMillis()));

		builder.deleteCharAt(builder.length() - 1);

		return builder.toString();
	}

	private String generateAccessTokenHeader(final RequestToken token, final String verifierCode)
	{
		final StringBuilder builder = new StringBuilder("OAuth ");

		builder.append(String.format(Constants.OAUTH_CONSUMER_KEY, this.credentials.getKey()));
		builder.append(String.format(Constants.OAUTH_NONCE, UUID.randomUUID()));
		builder.append(String.format(Constants.OAUTH_REQUEST_TOKEN, token.getValue()));
		builder.append(String.format(Constants.OAUTH_ACCESS_SIGNATURE, this.credentials.getSecret(), token.getSecret()));
		builder.append(Constants.OAUTH_SIGNATURE_METHOD);
		builder.append(String.format(Constants.OAUTH_TIMESTAMP, System.currentTimeMillis()));
		builder.append(String.format(Constants.OAUTH_VERIFIER, verifierCode));

		builder.deleteCharAt(builder.length() - 1);

		return builder.toString();
	}

	private String get(final HttpUrl url, final Headers headers)
		throws DiscogsException.RequestFailed
	{
		final Request request = new Request.Builder()
				.url(url)
				.headers(headers)
				.build();

		try(Response response = this.client.newCall(request).execute()) {
			final String content = response.body().string();

			final String message = response.message();
			final int code = response.code();

			if(code != HttpStatus.OK)
				throw new DiscogsException.RequestFailed("Request failed with status code '" + code + ": " + message);

			return content;

		} catch(final IOException exception) {
			throw new DiscogsException.RequestFailed("Failed to get the element from '" + url + "'", exception);
		}
	}

	private String post(final HttpUrl url, final Headers headers, final RequestBody body)
		throws DiscogsException.RequestFailed
	{
		final Request request = new Request.Builder()
				.url(url)
				.headers(headers)
				.post(body)
				.build();

		try(Response response = this.client.newCall(request).execute()) {
			final String content = response.body().string();

			final String message = response.message();
			final int code = response.code();

			if(code != HttpStatus.OK)
				throw new DiscogsException.RequestFailed("Request failed with status code '" + code + ": " + message);

			return content;

		} catch(final IOException exception) {
			throw new DiscogsException.RequestFailed("Failed to get the element from '" + url + "'", exception);
		}
	}
}
