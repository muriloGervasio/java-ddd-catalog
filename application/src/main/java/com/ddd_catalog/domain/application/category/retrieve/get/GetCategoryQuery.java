package com.ddd_catalog.domain.application.category.retrieve.get;


public record GetCategoryQuery(
        String id
) {
    public static GetCategoryQuery with(final String id) {
        return new GetCategoryQuery(id);
    }
}
