package com.ddd_catalog.domain.exceptions;

import com.ddd_catalog.domain.validation.Error;
import com.ddd_catalog.domain.validation.ThrowsValidationHandler;

import java.util.List;

public class DomainException extends NoStackTraceException {
    private final List<Error> errors;

    private DomainException(
            final String message,
            final List<Error> errors
    ) {
        super(message);
        this.errors = errors;
    }

    public static DomainException with(final List<Error> errors) {
        return new DomainException("",errors);
    }

    public static  DomainException with(final Error error) {
        return new DomainException(error.message(), List.of(error));
    }

    public List<Error> getErrors() {
        return errors;
    }
}
