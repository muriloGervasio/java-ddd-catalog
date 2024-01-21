package com.ddd_catalog.domain.validation;

import java.util.List;

public interface ValidationHandler {
    ValidationHandler append(Error anError);

    ValidationHandler append(ValidationHandler validationHandler);

    ValidationHandler validate(Validation aValidation);

    default boolean hasError() {
        return getErrors() != null && !(getErrors().isEmpty());
    }

    public interface Validation {
        void validate();
    }

    List<Error> getErrors();
}
