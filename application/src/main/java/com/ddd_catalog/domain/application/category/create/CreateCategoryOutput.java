package com.ddd_catalog.domain.application.category.create;

import com.ddd_catalog.domain.category.Category;
import com.ddd_catalog.domain.category.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
) {

    public static CreateCategoryOutput from(Category category) {
        return new CreateCategoryOutput(category.getId());
    }
}
