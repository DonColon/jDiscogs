package com.dardan.rrafshi.discogs;

public final class Constants
{
	public static final String BASE_URL = "https://discogs.com/";
	public static final String API_URL = "https://api.discogs.com/";
	public static final String DISCOGS_API_KEY = "DISCOGS_API_KEY";
	public static final String DISCOGS_CONSUMER_KEY = "DISCOGS_CONSUMER_KEY";
	public static final String DISCOGS_CONSUMER_SECRET = "DISCOGS_CONSUMER_SECRET";

	public static final String CONTENT_TYPE = "Content-Type";
	public static final String USER_AGENT = "User-Agent";
	public static final String AUTHORIZATION = "Authorization";
	public static final String AUTH_FORMAT = "Discogs token=%s";

	public static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key=\"%s\",";
	public static final String OAUTH_NONCE = "oauth_nonce=\"%s\",";
	public static final String OAUTH_REQUEST_SIGNATURE = "oauth_signature=\"%s&\",";
	public static final String OAUTH_ACCESS_SIGNATURE = "oauth_signature=\"%s&%s\",";
	public static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method=\"PLAINTEXT\",";
	public static final String OAUTH_VERIFIER = "oauth_verifier=\"%s\",";
	public static final String OAUTH_REQUEST_TOKEN = "oauth_token=\"%s\",";
	public static final String OAUTH_TIMESTAMP = "oauth_timestamp=\"%s\",";
	public static final String OAUTH_CONTENT_TYPE = "application/x-www-form-urlencoded";
	public static final String OAUTH_USER_AGENT = "okhttp/4.8.0";

	public static final String KEY = "key";
	public static final String SECRET = "secret";
	public static final String OAUTH_TOKEN = "oauth_token";
	public static final String PAGE = "page";
	public static final String PER_PAGE = "per_page";
	public static final String SORT = "sort";
	public static final String SORT_ORDER = "sort_order";

	public static final String CURR_ABBR = "curr_abbr";
	public static final String QUERY = "q";


	private Constants() {}
}
