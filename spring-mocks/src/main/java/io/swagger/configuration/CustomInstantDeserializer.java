package io.swagger.configuration;

import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Custom module for handling Java 8 date/time types.
 * This module is registered in {@link JacksonConfiguration}.
 */
public class CustomInstantDeserializer extends SimpleModule {

    private static final long serialVersionUID = 1L;

    public CustomInstantDeserializer() {
        super();
        // We don't need to register custom deserializers anymore
        // as we're using the JavaTimeModule in JacksonConfiguration
    }
}
