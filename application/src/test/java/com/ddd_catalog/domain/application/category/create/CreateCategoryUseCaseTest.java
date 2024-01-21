package com.ddd_catalog.domain.application.category.create;

import com.ddd_catalog.domain.category.Category;
import com.ddd_catalog.domain.category.CategoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

public class CreateCategoryUseCaseTest {
    @Test
    public void givenAValidCommand_whenExecute_thenShouldCreateCategory() {
        final var expectedName = "Category Name";
        final var expectedDescription = "Category Description";
        final var expectedIsActive = true;

        final var command = CreateCategoryCommand.with(expectedName, expectedDescription, expectedIsActive);

        final var gateway = Mockito.mock(CategoryGateway.class);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(returnsFirstArg());
        final var useCase = new DefaultCreateCategoryUseCase(gateway);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);

        Mockito.verify(gateway, Mockito.times(1)).create(Mockito.argThat(aCategory -> {
            return Objects.equals(aCategory.getName(), expectedName)
                    && Objects.equals(aCategory.getDescription(), expectedDescription)
                    && Objects.equals(aCategory.isActive(), expectedIsActive)
                    && Objects.nonNull(aCategory.getId())
                    && Objects.nonNull(aCategory.getCreatedAt())
                    && Objects.nonNull(aCategory.getUpdatedAt());

        }));
    }
}
