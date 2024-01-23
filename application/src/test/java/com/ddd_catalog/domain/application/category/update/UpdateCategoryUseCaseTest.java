package com.ddd_catalog.domain.application.category.update;

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

import java.util.Objects;
import java.util.Optional;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateCategoryUseCaseTest {
    @InjectMocks
    private DefaultUpdateCategoryUseCase useCase;

    @Mock
    private CategoryGateway gateway;

    @BeforeEach
    public void clean() {
        Mockito.reset(this.gateway);
    }

    @Test
    public void givenAValidCommand_whenExecute_thenShouldUpdateCategory() {
        final var category = Category.newCategory("teste", "teste 2", true);

        final var expectedName = "Category Name";
        final var expectedDescription = "Category Description";
        final var expectedIsActive = true;


        final var command = UpdateCategoryCommand.with(category.getId(),
                expectedName,
                expectedDescription,
                expectedIsActive);

        when(this.gateway.findById(eq(category.getId()))).thenReturn(Optional.of(category));
        when(this.gateway.update(any())).thenAnswer(returnsFirstArg());

        final var output = this.useCase.execute(command).get();

        Assertions.assertNotNull(output);
        Assertions.assertNotNull(output.id());

        verify(this.gateway, times(1)).update(argThat(aCategory -> {
            return Objects.equals(aCategory.getName(), expectedName)
                    && Objects.equals(aCategory.getDescription(), expectedDescription)
                    && Objects.equals(aCategory.isActive(), expectedIsActive)
                    && Objects.equals(aCategory.getId(), category.getId())
                    && Objects.nonNull(aCategory.getCreatedAt())
                    && Objects.nonNull(aCategory.getUpdatedAt());
        }));

    }
}
