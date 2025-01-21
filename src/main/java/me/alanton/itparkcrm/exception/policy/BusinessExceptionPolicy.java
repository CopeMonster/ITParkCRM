package me.alanton.itparkcrm.exception.policy;

import org.springframework.http.HttpStatus;

public interface BusinessExceptionPolicy extends ExceptionPolicy {
    HttpStatus getHttpStatus();
}
