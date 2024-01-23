package com.ddd_catalog.domain.application.category.retrieve.get;

import com.ddd_catalog.domain.category.Category;
import com.ddd_catalog.domain.category.CategoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetCategoryByIdTest {
    @InjectMocks
    private DefaultGetCategoryUseCase getCategoryByIdUseCase;

    @Mock
    private CategoryGateway gateway;

    @BeforeEach
    public void clean() {
        reset(this.gateway);
    }

    @Test
    public void GivenAValidCategoryId_whenCallGetCategoryById_CallGetCategoryById() {
        final var category = Category.newCategory("teste", "teste 2", true);
        final var categoryId = category.getId();

        final var query = GetCategoryQuery.with(categoryId.toString());

        when(this.gateway.findById(any())).thenReturn(Optional.of(category.clone()));

        final var actualCategory = this.getCategoryByIdUseCase.execute(query);

        verify(this.gateway, times(1)).findById(any());

        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(categoryId.toString(), actualCategory.id());
        Assertions.assertEquals(category.getName(), actualCategory.name());
        Assertions.assertEquals(category.getDescription(), actualCategory.description());

    }

}
