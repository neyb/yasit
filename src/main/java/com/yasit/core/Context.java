package com.yasit.core;

import com.yasit.core.exceptions.cannotCreateObject;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

public class Context {

    Set<Class<?>> definitions = new HashSet<>();

    public void addClass(Class<?> SubjectClass) {
        definitions.add(SubjectClass);
    }

    public <T> T get(Class<T> testClass) {
        try {
            return testClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new cannotCreateObject(e);
        }
    }
}
