package com.ddd_catalog.domain.validation;

public abstract class Validator {
    private final ValidationHandler handler;

    public Validator(final ValidationHandler validationHandler) {
        this.handler = validationHandler;
    }

    protected ValidationHandler getHandler() {
        return handler;
    }

    public abstract void validate();
}
