package com.ddd_catalog.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    @Test
    public void testNewCategory() {
        Category category = new Category();
        category.name = "Category 1";
        Assertions.assertNotNull(category);
    }
}
