package com.bankapp.exception;

import java.util.UUID;

/**
 * exception: incorrect account information
 *
 * @author Iurii Ivanov
 */

public class NotFoundException extends RuntimeException{

    public <T> NotFoundException(Class<T> entityType, UUID id) {
        super(String.format("Not found %s with id: %s.", entityType.getSimpleName(), id));
    }

    public <T> NotFoundException(Class<T> entityType, String number) {
        super(String.format("Not found %s with number: %s.", entityType.getSimpleName(), number));
    }

    public <T> NotFoundException(Class<T> entityType) {
        super(String.format("Not found %s matching your request", entityType.getSimpleName()));
    }
}