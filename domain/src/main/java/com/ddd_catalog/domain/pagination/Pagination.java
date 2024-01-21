package com.ddd_catalog.domain.pagination;

public record Pagination<T>(
        int currentPage,
        int perPage,
        long total,
        Iterable<T> items
) {
}
