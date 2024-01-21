package com.ddd_catalog.domain.category;

import com.ddd_catalog.domain.validation.Error;
import com.ddd_catalog.domain.validation.ValidationHandler;
import com.ddd_catalog.domain.validation.Validator;

public class CategoryValidator extends Validator {
    private final Category category;


    public CategoryValidator(Category category, ValidationHandler validationHandler) {
        super(validationHandler);
        this.category = category;
    }


    @Override
    public void validate() {
        if(category.getName() == null || category.getName().isEmpty()) {
            getHandler().append(new Error("Name is required"));
        }
    }
}
