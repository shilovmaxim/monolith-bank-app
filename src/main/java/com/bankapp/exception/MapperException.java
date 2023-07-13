package com.bankapp.exception;

/**
 * MapStruct: exception for mapping actions.
 *
 * @author Shilov Maxim
 */

public class MapperException extends RuntimeException{

    /**
     * This constructor need for MapStruct.
     */
    public MapperException() {
        super("Mapping problem");
    }
}
