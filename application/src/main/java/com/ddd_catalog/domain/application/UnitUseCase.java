package com.ddd_catalog.domain.application;

public abstract class UnitUseCase <IN> {
    public abstract void execute(IN input);
}
