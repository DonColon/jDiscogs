package com.dardan.rrafshi.discogs.deserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dardan.rrafshi.discogs.model.pagination.ValueHelp;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


public final class ValueHelpDeserializer extends JsonDeserializer<List<ValueHelp>>
{
	@Override
	public List<ValueHelp> deserialize(final JsonParser parser, final DeserializationContext context)
		throws IOException, JsonProcessingException
	{
		final ObjectCodec codec = parser.getCodec();
		final JsonNode root = codec.readTree(parser);

		final List<ValueHelp> valueHelps = new ArrayList<>();

		root.fields().forEachRemaining(field -> {
			final String key = field.getKey();
			final Map<String, Integer> values = new HashMap<>();

			final JsonNode node = field.getValue();
			node.fields().forEachRemaining(value -> values.put(value.getKey(), value.getValue().asInt()));

			final ValueHelp valueHelp = new ValueHelp(key, values);
			valueHelps.add(valueHelp);
		});

		return valueHelps;
	}
}
