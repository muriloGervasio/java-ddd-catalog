package com.ddd_catalog.domain.application.category.retrieve.list;

import com.ddd_catalog.domain.application.UseCase;
import com.ddd_catalog.domain.category.CategorySearchQuery;
import com.ddd_catalog.domain.pagination.Pagination;

public abstract class ListCategoryUseCase extends UseCase<CategorySearchQuery, Pagination<ListCategoryOutput>> {

}
