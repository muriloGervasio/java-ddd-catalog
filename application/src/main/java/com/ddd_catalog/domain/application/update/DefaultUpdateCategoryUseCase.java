package com.ddd_catalog.domain.application.update;

import com.ddd_catalog.domain.category.Category;
import com.ddd_catalog.domain.category.CategoryGateway;
import com.ddd_catalog.domain.exceptions.DomainException;
import com.ddd_catalog.domain.validation.Error;
import com.ddd_catalog.domain.validation.handler.Notification;
import io.vavr.API;
import io.vavr.control.Either;

import java.util.function.Supplier;

public class DefaultUpdateCategoryUseCase extends UpdateCategoryUseCase {
    private final CategoryGateway categoryGateway;

    public DefaultUpdateCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Either<Notification, UpdateCategoryOutput> execute(UpdateCategoryCommand input) {
        final var name = input.name();
        final var description = input.description();
        final var isActive = input.isActive();
        final var id = input.id();

        final var toUpdate = this.categoryGateway.findById(id).orElseThrow(
                notFound()
        );

        final var notification = Notification.create();

        toUpdate.update(name, description, isActive);
        toUpdate.validate(notification);

        return notification.hasError()
                ? Either.left(notification)
                : update(toUpdate);
    }

    private Either<Notification, UpdateCategoryOutput> update(Category toUpdate) {
        return API.Try(() -> this.categoryGateway.update(toUpdate)).toEither().bimap(
                Notification::create,
                UpdateCategoryOutput::from
        );
    }

    private static Supplier<DomainException> notFound() {
        return () -> DomainException.with(new Error("category.not.found"));
    }
}
