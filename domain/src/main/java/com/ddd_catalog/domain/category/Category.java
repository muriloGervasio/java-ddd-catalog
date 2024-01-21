package com.ddd_catalog.domain.category;

import com.ddd_catalog.domain.AggregateRoot;
import com.ddd_catalog.domain.validation.ValidationHandler;

import java.time.Instant;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> {
    private CategoryID id;
    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Category(final CategoryID id,
                    final String name,
                    final String description,
                    final boolean active,
                    final Instant createdAt,
                    final Instant updatedAt,
                    final Instant deletedAt) {
        super(id);
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static Category newCategory(final String name,
                                       final String description,
                                       final boolean active) {
        final var id = UUID.randomUUID().toString();
        final var now = Instant.now();
        final var deletedAt = active ? null : now;

        return new Category(CategoryID.unique(),
                name,
                description,
                active,
                now,
                now,
                deletedAt);
    }

    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }
}