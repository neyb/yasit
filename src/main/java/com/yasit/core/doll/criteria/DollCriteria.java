package com.yasit.core.doll.criteria;

import com.yasit.core.doll.definition.DollDefinition;

/**
 * @param <T> DollDefinition that matches is a subtype of T. the as method does the cast for you
 */
public interface DollCriteria<T> {
    static <T> DollCriteria<T> ofClass(Class<T> dollClass) {
        return new AssignableCriteria<>(dollClass);
    }

    boolean matches(DollDefinition<?> definition);

    /**
     * this method should not be used on definition that does not match with the criteria (because it's the matching that ensure this cast)
     */
    @SuppressWarnings("unchecked")
    default DollDefinition<? extends T> as(DollDefinition<?> definition) {
        return (DollDefinition<? extends T>) definition;
    }
}
