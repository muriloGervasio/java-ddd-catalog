package com.ddd_catalog.domain.application.category.retrieve.list;

import com.ddd_catalog.domain.category.Category;

public record ListCategoryOutput(
        String id,
        String name,
        String description,
        boolean isActive
) {
    public static ListCategoryOutput from(final Category category) {
        return new ListCategoryOutput(
                category.getId().toString(),
                category.getName(),
                category.getDescription(),
                category.isActive()
        );
    }
}
