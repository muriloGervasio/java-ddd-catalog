package com.ddd_catalog.domain.application.category.retrieve.get;

import com.ddd_catalog.domain.category.Category;
import com.ddd_catalog.domain.category.CategoryID;

import java.time.Instant;

public record GetCategoryOutput(String id, String name, String description, boolean isActive, Instant createdAt,
                                Instant updatedAt, Instant deletedAt) {

    public static GetCategoryOutput from(final Category category) {
        return new GetCategoryOutput(
                category.getId().toString(),
                category.getName(),
                category.getDescription(),
                category.isActive(),
                category.getCreatedAt(),
                category.getUpdatedAt(),
                category.getDeletedAt()
        );
    }

}
