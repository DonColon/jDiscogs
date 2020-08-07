package com.dardan.rrafshi.discogs.deserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dardan.rrafshi.discogs.model.pagination.Filter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


public final class AppliedFiltersDeserializer extends JsonDeserializer<List<Filter>>
{
	@Override
	public List<Filter> deserialize(final JsonParser parser, final DeserializationContext context)
		throws IOException, JsonProcessingException
	{
		final ObjectCodec codec = parser.getCodec();
		final JsonNode root = codec.readTree(parser);

		final List<Filter> appliedFilters = new ArrayList<>();

		root.fields().forEachRemaining(field -> {
			final String key = field.getKey();
			final List<String> values = new ArrayList<>();

			final JsonNode node = field.getValue();
			node.elements().forEachRemaining(value -> values.add(value.asText()));

			final Filter filter = Filter.of(key, values);
			appliedFilters.add(filter);
		});

		return appliedFilters;
	}
}
