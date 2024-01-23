package com.ddd_catalog.domain.application.category.retrieve.list;

import com.ddd_catalog.domain.category.Category;
import com.ddd_catalog.domain.category.CategoryGateway;
import com.ddd_catalog.domain.category.CategorySearchQuery;
import com.ddd_catalog.domain.pagination.Pagination;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListCategoryUseCaseTest {

    @Mock
    private CategoryGateway categoryGateway;

    @InjectMocks
    private DefaultListCategoryUseCase listCategoryUseCase;

    @BeforeEach
    public void clean() {
        Mockito.reset(this.categoryGateway);
    }


    @Test
    public void givenAValidQuery_whenCallListCategory_CallListCategory() {
        final var query = new CategorySearchQuery(
                "teste",
                "id",
                "ASC",
                1,
                10
        );

        final var expectedSizeOf = 2;

        final var categories = List.of(
                Category.newCategory(
                        "teste",
                        "teste",
                        true
                ),
                Category.newCategory(
                        "teste",
                        "teste",
                        true
                )
        );

        final var expedtedPagination = new Pagination<Category>(
                0,
                10,
                2,
                categories
        );
        final var expectedResult = expedtedPagination.map(ListCategoryOutput::from);

        Mockito.when(this.categoryGateway.findAll(query)).thenReturn(expedtedPagination);

        this.listCategoryUseCase.execute(query);

        Mockito.verify(this.categoryGateway, Mockito.times(1)).findAll(query);

        Assertions.assertNotNull(expectedResult);
        Assertions.assertEquals(expectedSizeOf, expectedResult);
    }

}
