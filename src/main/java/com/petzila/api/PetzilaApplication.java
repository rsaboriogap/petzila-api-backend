package com.petzila.api;

import com.petzila.api.healthcheck.DatabaseHealthCheck;
import com.petzila.api.resource.IdentityLoginResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by rsaborio on 16/12/14.
 */
public class PetzilaApplication extends Application<PetzilaConfiguration> {
    public static void main(String[] args) throws Exception {
        new PetzilaApplication().run(args);
    }

    @Override
    public String getName() {
        return "petzila-api";
    }

    @Override
    public void initialize(Bootstrap<PetzilaConfiguration> bootstrap) {

    }

    @Override
    public void run(PetzilaConfiguration configuration, Environment environment) throws Exception {
        environment.healthChecks().register("database", new DatabaseHealthCheck());
        environment.jersey().register(new IdentityLoginResource());
    }
}
