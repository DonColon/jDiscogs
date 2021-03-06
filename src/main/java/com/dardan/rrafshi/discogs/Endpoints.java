package com.dardan.rrafshi.discogs;

public final class Endpoints
{
	public static final String RELEASE_GET = "releases/%d";
	public static final String MASTER_RELEASE_GET = "masters/%d";
	public static final String MASTER_RELEASE_VERSIONS_GET = "masters/%d/versions";

	public static final String ARTIST_GET = "artists/%d";
	public static final String ARTIST_RELEASES_GET = "artists/%d/releases";
	public static final String LABEL_GET = "labels/%d";
	public static final String LABEL_RELEASES_GET = "labels/%d/releases";

	public static final String DATABASE_SEARCH_GET = "database/search";

	public static final String REQUEST_TOKEN_GET = "oauth/request_token";
	public static final String ACCESS_TOKEN_POST = "oauth/access_token";
	public static final String AUTHORIZE_GET = "oauth/authorize";
	public static final String IDENTITY_GET = "oauth/identity";


	private Endpoints() {}
}
