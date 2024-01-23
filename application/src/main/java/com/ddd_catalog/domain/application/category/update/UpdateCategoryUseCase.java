package com.ddd_catalog.domain.application.category.update;

import com.ddd_catalog.domain.application.UseCase;
import com.ddd_catalog.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase extends UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {
}
