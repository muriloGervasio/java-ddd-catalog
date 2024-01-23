package com.ddd_catalog.domain.application.category.delete;

import com.ddd_catalog.domain.category.CategoryID;

public record DeleteCategoryByIdCommand(
        CategoryID id
) {
    public static DeleteCategoryByIdCommand with(CategoryID id) {
        return new DeleteCategoryByIdCommand(id);
    }
}
