package me.alanton.itparkcrm.exception.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum BusinessExceptionReason {
    ROLE_NOT_FOUND_EXCEPTION("Role not found", HttpStatus.NOT_FOUND);

    final String code = BusinessExceptionReason.class.getSimpleName();
    final String message;
    final HttpStatus httpStatus;
}
