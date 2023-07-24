package com.javadb.spring_data_auto_mapping_objects.utils;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public interface ValidationUtil {

    <E> Set<ConstraintViolation<E>> violation(E entity);
}
