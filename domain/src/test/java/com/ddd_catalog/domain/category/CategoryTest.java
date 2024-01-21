package com.ddd_catalog.domain.category;

import com.ddd_catalog.domain.category.Category;
import com.ddd_catalog.domain.exceptions.DomainException;
import com.ddd_catalog.domain.validation.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    @Test
    public void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
        final var expectedName = "Filmes";
        final var expectedDescription = "A Categoria mais assistida";
        final var expectedIsActive = true;

        Category category = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertNotNull(category);
        Assertions.assertNotNull(category.getId());
        Assertions.assertEquals(expectedName, category.getName());
        Assertions.assertEquals(expectedDescription, category.getDescription());
        Assertions.assertEquals(expectedIsActive, category.isActive());
        Assertions.assertNotNull(category.getCreatedAt());
        Assertions.assertNotNull(category.getUpdatedAt());
        Assertions.assertNotNull(category.getDeletedAt());
    }

    public void givenAnInvalidNullName_whenCallNewCategory_thenThrowException() {
        final String expectedName = null;
        final var expectedDescription = "A Categoria mais assistida";
        final var expectedIsActive = true;
        final var expectedErrorMessage = "Name is required";
        final var expectedErrorLength = 1;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var handler = new ThrowsValidationHandler();

        final var domainException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(handler));

        Assertions.assertEquals(expectedErrorMessage, domainException.getErrors().get(0).message());
        Assertions.assertEquals(expectedErrorLength, domainException.getErrors().size());
    }
}
