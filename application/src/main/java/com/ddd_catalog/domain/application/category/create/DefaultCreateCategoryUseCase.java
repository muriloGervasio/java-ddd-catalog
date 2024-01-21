package com.ddd_catalog.domain.application.category.create;

import com.ddd_catalog.domain.category.Category;
import com.ddd_catalog.domain.category.CategoryGateway;
import com.ddd_catalog.domain.validation.handler.Notification;
import io.vavr.API;
import io.vavr.control.Either;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {
    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Either<Notification, CreateCategoryOutput> execute(final CreateCategoryCommand input) {
        final String name = input.name();
        final String description = input.description();
        final boolean isActive = input.isActive();

        final var notification = Notification.create();

        final var category = Category.newCategory(name, description, isActive);
        category.validate(notification);

        return notification.hasError()
                ? API.Left(notification)
                : create(category);
    }

    private Either<Notification, CreateCategoryOutput> create(final Category aCategory) {
        return API.Try(() -> this.categoryGateway.create(aCategory)).toEither().bimap(
                Notification::create,
                CreateCategoryOutput::from
        );
    }
}
