package com.ddd_catalog.domain.application.category.delete;

import com.ddd_catalog.domain.category.Category;
import com.ddd_catalog.domain.category.CategoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteCategoryUseCaseTest {
    @InjectMocks
    private DefaultDeleteCategoryByIdUseCase deleteCategoryUseCase;

    @Mock
    private CategoryGateway gateway;

    @BeforeEach
    public void clean() {
        reset(this.gateway);
    }


    @Test
    public void givenAValidId_WhenCallsDeleteCategory_ShouldBeOk() {
        final var aCategory = Category.newCategory("teste", "teste 2", true);
        final var categoryId = aCategory.getId();
        final var  command = DeleteCategoryByIdCommand.with(categoryId);

        doNothing().when(this.gateway).deleteById(eq(categoryId));

        Assertions.assertDoesNotThrow(() -> this.deleteCategoryUseCase.execute(command));
        verify(this.gateway, times(1)).deleteById(eq(categoryId));
    }

    @Test
    public void givenAInValidId_WhenCallsDeleteCategory_ShouldBeOk() {
        final var aCategory = Category.newCategory("teste", "teste 2", true);
        final var categoryId = aCategory.getId();


        final var  command = DeleteCategoryByIdCommand.with(categoryId);
        doNothing().when(this.gateway).deleteById(eq(categoryId));

        Assertions.assertDoesNotThrow(() -> this.deleteCategoryUseCase.execute(command));
        verify(this.gateway, times(1)).deleteById(eq(categoryId));
    }

    @Test
    public void givenAInValidId_WhenCallsDeleteCategory_ShouldReturnException() {
        final var aCategory = Category.newCategory("teste", "teste 2", true);
        final var categoryId = aCategory.getId();


        final var  command = DeleteCategoryByIdCommand.with(categoryId);
        doThrow(new IllegalStateException()).when(this.gateway).deleteById(eq(categoryId));

        Assertions.assertDoesNotThrow(() -> this.deleteCategoryUseCase.execute(command));
        verify(this.gateway, times(1)).deleteById(eq(categoryId));
    }
}
