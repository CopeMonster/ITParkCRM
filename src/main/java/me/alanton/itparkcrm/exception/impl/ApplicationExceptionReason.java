package me.alanton.itparkcrm.exception.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationExceptionReason {
    BEAN_PROPERTY_NOT_EXISTS("Property '%s' for object '%s' doesn't exists");

    final String code = ApplicationExceptionReason.class.getSimpleName();
    final String message;
}
