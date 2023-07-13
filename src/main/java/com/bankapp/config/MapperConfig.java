package com.bankapp.config;

import com.bankapp.exception.MapperException;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapstruct configuration class.
 *
 * @author Shilov Maxim
 */

@org.mapstruct.MapperConfig(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unexpectedValueMappingException = MapperException.class)
public interface MapperConfig {}
