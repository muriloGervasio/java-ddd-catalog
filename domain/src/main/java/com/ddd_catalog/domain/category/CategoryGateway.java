package com.ddd_catalog.domain.category;

import com.ddd_catalog.domain.pagination.Pagination;

import java.util.Optional;

public interface CategoryGateway {
    Category create(Category category);
    Optional<Category> findById(CategoryID categoryId);
    Category deleteById(CategoryID categoryId);
    Category update(Category category);
    Pagination<Category> findAll(CategorySearchQuery aQuery);
}
