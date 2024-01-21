package com.ddd_catalog.domain.application;

import com.ddd_catalog.domain.category.Category;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public abstract  class UseCase<IN, OUT> {
    public abstract OUT execute(IN input);
}