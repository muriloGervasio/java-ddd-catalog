package com.ddd_catalog.domain;

import com.ddd_catalog.domain.validation.ValidationHandler;

public abstract  class AggregateRoot<ID extends  Identifier> extends Entity<ID>{
    public AggregateRoot(ID id) {
        super(id);
    }
}
