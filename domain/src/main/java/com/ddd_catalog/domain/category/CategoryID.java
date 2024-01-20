package com.ddd_catalog.domain.category;

import com.ddd_catalog.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {
    private final String value;

    public CategoryID(final String value) {
        Objects.requireNonNull(value, "value must not be null");
        this.value = value;
    }

    public static CategoryID unique() {
        return new CategoryID(java.util.UUID.randomUUID().toString().toLowerCase());
    }

    public static CategoryID from(final String id) {
        return new CategoryID(id);
    }

    public static  CategoryID from(final UUID id) {
        return new CategoryID(id.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CategoryID that = (CategoryID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
