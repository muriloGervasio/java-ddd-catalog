package com.ddd_catalog.domain.application.update;

import com.ddd_catalog.domain.category.CategoryID;

public record UpdateCategoryCommand(
        CategoryID id,
        String name,
        String description,
        boolean isActive
) {
    public static UpdateCategoryCommand with(CategoryID id, String name, String description, boolean isActive) {
        return new UpdateCategoryCommand(id, name, description, isActive);
    }

}
