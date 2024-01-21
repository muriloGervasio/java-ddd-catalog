package com.ddd_catalog.domain.application.category.create;

import com.ddd_catalog.domain.application.UseCase;
import com.ddd_catalog.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {

}
