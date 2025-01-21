package me.alanton.itparkcrm.exception.impl;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import me.alanton.itparkcrm.exception.policy.ApplicationExceptionPolicy;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class ApplicationException extends RuntimeException implements ApplicationExceptionPolicy {
    final String code;
    final String message;

    public ApplicationException(final ApplicationExceptionReason reason) {
        this(reason, (Object[]) null);
    }

    public ApplicationException(final ApplicationExceptionReason reason, Object... parameters) {
        this.code = reason.getCode();

        if (parameters != null) {
            this.message = String.format(reason.message, parameters);
        } else {
            this.message = reason.getMessage();
        }
    }

    @Override
    public String getLocalizedMessage() {
        return message;
    }
}
