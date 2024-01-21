package com.ddd_catalog.domain.category;

public record CategorySearchQuery(
        String term,
        String sort,
        String direction,
        int page,
        int perPage
) {
}
