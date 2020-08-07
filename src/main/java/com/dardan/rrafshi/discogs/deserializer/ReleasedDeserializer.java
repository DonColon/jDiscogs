package com.dardan.rrafshi.discogs.deserializer;

import java.io.IOException;
import java.time.YearMonth;

import com.dardan.rrafshi.commons.Strings;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


public final class ReleasedDeserializer extends JsonDeserializer<YearMonth>
{
	@Override
	public YearMonth deserialize(final JsonParser parser, final DeserializationContext context)
		throws IOException, JsonProcessingException
	{
		final ObjectCodec codec = parser.getCodec();
		final JsonNode root = codec.readTree(parser);

		final String released = root.asText();
		final int index = released.lastIndexOf("-");

		return YearMonth.parse(Strings.substring(released, 0, index));
	}
}
