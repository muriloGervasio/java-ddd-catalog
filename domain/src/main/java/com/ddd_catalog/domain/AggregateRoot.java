package com.ddd_catalog.domain;

public class AggregateRoot<ID extends  Identifier> extends Entity<ID>{
    public AggregateRoot(ID id) {
        super(id);
    }
}
