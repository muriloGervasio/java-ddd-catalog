package com.ddd_catalog.domain.application.category.retrieve.list;

import com.ddd_catalog.domain.category.CategoryGateway;
import com.ddd_catalog.domain.category.CategorySearchQuery;
import com.ddd_catalog.domain.pagination.Pagination;

import java.util.Objects;

public class DefaultListCategoryUseCase extends ListCategoryUseCase {
    private CategoryGateway categoryGateway;

    public DefaultListCategoryUseCase(CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Pagination<ListCategoryOutput> execute(final CategorySearchQuery input) {
        return categoryGateway.findAll(input)
                .map(ListCategoryOutput::from);
    }
}
