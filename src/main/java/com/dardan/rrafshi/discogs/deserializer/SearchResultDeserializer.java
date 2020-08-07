package com.dardan.rrafshi.discogs.deserializer;

import java.io.IOException;

import com.dardan.rrafshi.commons.Strings;
import com.dardan.rrafshi.discogs.model.pagination.Pagination;
import com.dardan.rrafshi.discogs.model.search.ArtistResult;
import com.dardan.rrafshi.discogs.model.search.LabelResult;
import com.dardan.rrafshi.discogs.model.search.ReleaseResult;
import com.dardan.rrafshi.discogs.model.search.SearchResult;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


public final class SearchResultDeserializer extends JsonDeserializer<SearchResult>
{
	@Override
	public SearchResult deserialize(final JsonParser parser, final DeserializationContext context)
		throws IOException, JsonProcessingException
	{
		final ObjectCodec codec = parser.getCodec();
		final JsonNode root = codec.readTree(parser);

		final JsonNode page = root.get("pagination");
		final JsonNode results = root.get("results");

		final Pagination pagination = codec.treeToValue(page, Pagination.class);
		final SearchResult searchResult = new SearchResult(pagination);

		for(final JsonNode element : results) {
			final String type = element.get("type").asText();

			if(Strings.equals("release", type)) {
				final ReleaseResult result = codec.treeToValue(element, ReleaseResult.class);
				searchResult.addReleaseResult(result);
				continue;
			}

			if(Strings.equals("master", type)) {
				final ReleaseResult result = codec.treeToValue(element, ReleaseResult.class);
				searchResult.addMasterReleaseResult(result);
				continue;
			}

			if(Strings.equals("artist", type)) {
				final ArtistResult result = codec.treeToValue(element, ArtistResult.class);
				searchResult.addArtistResult(result);
				continue;
			}

			if(Strings.equals("label", type)) {
				final LabelResult result = codec.treeToValue(element, LabelResult.class);
				searchResult.addLabelResult(result);
				continue;
			}
		}

		return searchResult;
	}
}
