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
        checkName();
        checkDescription();

    }

    private void checkName() {
        if (category.getName() == null) {
            getHandler().append(new Error("Name is required"));
            return;
        }
        if (category.getName().trim().isEmpty()) {
            getHandler().append(new Error("Name is required"));
            return;
        }

        if (category.getName().trim().length() <= 3) {
            getHandler().append(new Error("Name length must be more than 3"));
            return;
        }

        if (category.getName().trim().length() > 20) {
            getHandler().append(new Error("Name length must be less than 20"));
            return;
        }
    }

    private void checkDescription() {
        if (category.getDescription().trim().isEmpty()) {
            getHandler().append(new Error("Description is required"));
            return;
        }
    }
}
