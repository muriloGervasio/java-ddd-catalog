package com.ddd_catalog.domain.validation;

import com.ddd_catalog.domain.exceptions.DomainException;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(Error anError) {
        throw DomainException.with(List.of(anError));
    }

    @Override
    public ValidationHandler append(ValidationHandler validationHandler) {
        throw DomainException.with(validationHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception e) {
            throw DomainException.with(List.of((new Error(e.getMessage()))));
        }
        return this;
    }

    @Override
    public List<Error> getErrors() {
        return null;
    }
}
