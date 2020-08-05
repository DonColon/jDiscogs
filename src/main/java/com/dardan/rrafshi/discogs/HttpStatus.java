package com.dardan.rrafshi.discogs;

public final class HttpStatus
{
	public static final int OK = 200;
	public static final int CONTINUE = 201;
	public static final int NO_CONTENT = 204;

	public static final int UNAUTHORIZED = 401;
	public static final int FORBIDDEN = 403;
	public static final int NOT_FOUND = 404;
	public static final int METHOD_NOT_ALLOWED = 405;
	public static final int UNPROCESSABLE_ENTITY = 422;

	public static final int INTERNAL_SERVER_ERROR = 500;


	private HttpStatus() {}
}
