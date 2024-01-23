package com.ddd_catalog.domain.application.category.retrieve.get;

import com.ddd_catalog.domain.category.CategoryGateway;
import com.ddd_catalog.domain.category.CategoryID;
import com.ddd_catalog.domain.exceptions.DomainException;
import com.ddd_catalog.domain.validation.Error;

public class DefaultGetCategoryUseCase extends GetCategoryUseCase {

    private final CategoryGateway gateway;

    public DefaultGetCategoryUseCase(CategoryGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public GetCategoryOutput execute(final GetCategoryQuery input) {
        final var categoryId = CategoryID.from(input.id());

        return gateway.findById(categoryId)
                .map(GetCategoryOutput::from)
                .orElseThrow(() -> DomainException.with(new Error("Category with ID %s was not found".formatted(
                        categoryId.getValue()))));
    }
}
