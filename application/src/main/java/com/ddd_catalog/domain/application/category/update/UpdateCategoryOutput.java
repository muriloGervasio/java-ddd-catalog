package com.ddd_catalog.domain.application.category.update;

import com.ddd_catalog.domain.category.Category;
import com.ddd_catalog.domain.category.CategoryID;

public record UpdateCategoryOutput(
        CategoryID id
) {
    public static UpdateCategoryOutput from(Category category) {
        return new UpdateCategoryOutput(category.getId());
    }
}
