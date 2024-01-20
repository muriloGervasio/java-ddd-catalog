package com.ddd_catalog.domain;

import java.util.Objects;

public abstract  class Entity<ID extends Identifier> {
    public Entity(final ID id) {
        Objects.requireNonNull(id, "id must not be null");
        this.id = id;
    }

    protected final ID id;

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Entity<?> entity = (Entity<?>) o;
        return Objects.equals(getId(), entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
