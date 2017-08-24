package com.bobbyratliff;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        this.register(CoffeeController.class);
        this.register(JacksonJaxbJsonProvider.class);
    }
}
