package com.ddd_catalog.domain.application.category.delete;

import com.ddd_catalog.domain.category.CategoryGateway;

public class DefaultDeleteCategoryByIdUseCase extends DeleteCategoryByIdUseCase {
    private final CategoryGateway gateway;

    public DefaultDeleteCategoryByIdUseCase(CategoryGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(final DeleteCategoryByIdCommand input) {
        gateway.deleteById(input.id());
    }
}
