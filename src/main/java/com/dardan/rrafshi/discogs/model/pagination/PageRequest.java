package com.dardan.rrafshi.discogs.model.pagination;

public final class PageRequest
{
	public static final int DEFAULT_PAGE = 1;
	public static final int DEFAULT_PAGE_SIZE = 50;


	private final int page;
	private final int size;
	private final Sort sort;


	private PageRequest(final int page, final int size, final Sort sort)
	{
		this.page = page;
		this.size = size;
		this.sort = sort;
	}

	private PageRequest(final int page, final int size, final Direction direction, final String... properties)
	{
		this(page, size, Sort.by(direction, properties));
	}

	private PageRequest(final int page, final int size)
	{
		this(page, size, Sort.unsorted());
	}

	private PageRequest()
	{
		this(DEFAULT_PAGE, DEFAULT_PAGE_SIZE);
	}


	public static PageRequest of(final int page, final int size, final Sort sort)
	{
		return new PageRequest(page, size, sort);
	}

	public static PageRequest of(final int page, final int size, final Direction direction, final String... properties)
	{
		return new PageRequest(page, size, direction, properties);
	}

	public static PageRequest of(final int page, final int size)
	{
		return new PageRequest(page, size);
	}

	public static PageRequest getDefault()
	{
		return new PageRequest();
	}


	public int getPage()
	{
		return this.page;
	}

	public int getSize()
	{
		return this.size;
	}

	public Sort getSort()
	{
		return this.sort;
	}
}
