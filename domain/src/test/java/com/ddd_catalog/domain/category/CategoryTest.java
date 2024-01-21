package com.ddd_catalog.domain.category;

import com.ddd_catalog.domain.exceptions.DomainException;
import com.ddd_catalog.domain.validation.handler.ThrowsValidationHandler;
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
        Assertions.assertNull(category.getDeletedAt());
    }

    public void givenAnInvalidNullName_whenCallNewCategory_thenThrowException() {
        final String expectedName = null;
        final var expectedDescription = "A Categoria mais assistida";
        final var expectedIsActive = true;
        final var expectedErrorMessage = "Name is required";
        final var expectedErrorLength = 1;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var handler = new ThrowsValidationHandler();

        final var domainException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(handler));

        Assertions.assertEquals(expectedErrorMessage, domainException.getErrors().get(0).message());
        Assertions.assertEquals(expectedErrorLength, domainException.getErrors().size());
    }

    public void givenAnInvalidEmptyName_whenCallNewCategory_thenThrowException() {
        final String expectedName = "   ";
        final var expectedDescription = "A Categoria mais assistida";
        final var expectedIsActive = true;
        final var expectedErrorMessage = "Name is required";
        final var expectedErrorLength = 1;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var handler = new ThrowsValidationHandler();

        final var domainException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(handler));

        Assertions.assertEquals(expectedErrorMessage, domainException.getErrors().get(0).message());
        Assertions.assertEquals(expectedErrorLength, domainException.getErrors().size());
    }

    @Test
    public void givenAnInvalidNameLengthName_whenCallNewCategory_thenThrowException() {
        final String expectedName = "Fi ";
        final var expectedDescription = "A Categoria mais assistida";
        final var expectedIsActive = true;
        final var expectedErrorMessage = "Name length must be more than 3";
        final var expectedErrorLength = 1;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var handler = new ThrowsValidationHandler();

        final var domainException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(handler));

        Assertions.assertEquals(expectedErrorMessage, domainException.getErrors().get(0).message());
        Assertions.assertEquals(expectedErrorLength, domainException.getErrors().size());
    }

    @Test
    public void givenAnInvalidNameLength_whenCallNewCategory_thenThrowException() {
        final String expectedName = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum";
        final var expectedDescription = "A Categoria mais assistida";
        final var expectedIsActive = true;
        final var expectedErrorMessage = "Name length must be less than 20";
        final var expectedErrorLength = 1;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var handler = new ThrowsValidationHandler();

        final var domainException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(handler));

        Assertions.assertEquals(expectedErrorMessage, domainException.getErrors().get(0).message());
        Assertions.assertEquals(expectedErrorLength, domainException.getErrors().size());
    }

    @Test
    public void givenAnInvalidEmptyDescription_whenCallNewCategory_thenThrowException() {
        final String expectedName = "Mathes";
        final var expectedDescription = "  ";
        final var expectedIsActive = true;
        final var expectedErrorMessage = "Description is required";
        final var expectedErrorLength = 1;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var handler = new ThrowsValidationHandler();

        final var domainException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(handler));

        Assertions.assertEquals(expectedErrorMessage, domainException.getErrors().get(0).message());
        Assertions.assertEquals(expectedErrorLength, domainException.getErrors().size());
    }

    @Test
    public void givenAnValidFalseIsActive_whenCallNewCategory_thenThrowException() {
        final String expectedName = "Mathes";
        final var expectedDescription = " Melhor categoria";
        final var expectedIsActive = false;
        final var expectedErrorLength = 0;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var handler = new ThrowsValidationHandler();


        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNotNull(actualCategory.getDeletedAt());
    }

    @Test
    public void givenAValidActivateCategory_whenCallDeactivate_thenReturnADeactivatedCategory() {
        final String expectedName = "Mathes";
        final var expectedDescription = " Melhor categoria";
        final var expectedIsActive = true;

        final var aCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var handler = new ThrowsValidationHandler();

        Assertions.assertDoesNotThrow(() -> aCategory.validate(handler));

        final var updatedAt = aCategory.getUpdatedAt();

        Assertions.assertNull(aCategory.getDeletedAt());

        final Category actualCategory = aCategory.deactivate();

        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(aCategory.getName(), actualCategory.getName());
        Assertions.assertEquals(aCategory.getDescription(), actualCategory.getDescription());
        Assertions.assertFalse(actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNotNull(actualCategory.getDeletedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
    }

    @Test
    public void givenAValidInactiveCategory_whenCallDeactivate_thenReturnAActiveCategory() {
        final String expectedName = "Mathes";
        final var expectedDescription = " Melhor categoria";
        final var expectedIsActive = false;

        final var aCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var handler = new ThrowsValidationHandler();

        Assertions.assertDoesNotThrow(() -> aCategory.validate(handler));

        final var updatedAt = aCategory.getUpdatedAt();

        Assertions.assertNotNull(aCategory.getDeletedAt());

        final Category actualCategory = aCategory.activate();

        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(actualCategory.getId(), aCategory.getId());
        Assertions.assertEquals(aCategory.getName(), actualCategory.getName());
        Assertions.assertEquals(aCategory.getDescription(), actualCategory.getDescription());
        Assertions.assertTrue( actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
    }

    @Test
    public void givenAValidCategory_whenCallUpdate_thenReturnAUpdatedCategory() {
        final String expectedName = "Mathes";
        final var expectedDescription = " Melhor categoria";
        final var expectedIsActive = true;

        final var aCategory = Category.newCategory("Filme", "Uma Categoria", expectedIsActive);

        final var handler = new ThrowsValidationHandler();

        Assertions.assertDoesNotThrow(() -> aCategory.validate(handler));

        final var updatedAt = aCategory.getUpdatedAt();

        final Category actualCategory = aCategory.update(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(actualCategory.getId(), aCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertTrue(actualCategory.isActive());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
    }

    @Test
    public void givenAValidCategory_whenCallUpdateWithInactive_thenReturnAUpdatedCategoryInactive() {
        final String expectedName = "Mathes";
        final var expectedDescription = " Melhor categoria";
        final var expectedIsActive = false;

        final var aCategory = Category.newCategory("Filme", "Uma Categoria", true);

        final var handler = new ThrowsValidationHandler();

        Assertions.assertDoesNotThrow(() -> aCategory.validate(handler));

        final var updatedAt = aCategory.getUpdatedAt();

        final Category actualCategory = aCategory.update(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(actualCategory.getId(), aCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getDeletedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
    }

    @Test
    public void givenAValidCategory_whenCallUpdateWithInvalidParams_thenReturnAUpdatedCategoryUnupdated() {
        final String expectedName = null;
        final var expectedDescription = " Melhor categoria";
        final var expectedIsActive = true;

        final var aCategory = Category.newCategory("Filme", "Uma Categoria", true);

        final var handler = new ThrowsValidationHandler();

        Assertions.assertDoesNotThrow(() -> aCategory.validate(handler));

        final var updatedAt = aCategory.getUpdatedAt();

        final Category actualCategory = aCategory.update(expectedName, expectedDescription, expectedIsActive);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(actualCategory.getId(), aCategory.getId());
        Assertions.assertNull( actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertNull(actualCategory.getDeletedAt());
        Assertions.assertTrue(actualCategory.getUpdatedAt().isAfter(updatedAt));
    }
}
