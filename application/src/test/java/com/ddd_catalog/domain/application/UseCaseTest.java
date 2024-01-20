package com.ddd_catalog.domain.application;

import com.ddd_catalog.domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UseCaseTest {

    @Test
    public void testUseCase() {
        UseCase useCase = new UseCase();
        Assertions.assertNotNull(useCase);
    }
}
