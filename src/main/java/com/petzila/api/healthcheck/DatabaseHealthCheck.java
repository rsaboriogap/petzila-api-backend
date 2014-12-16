package com.petzila.api.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by rsaborio on 16/12/14.
 */
public class DatabaseHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
//        if (db is not healthy) {
//            return Result.unhealthy("Database is not working properly");
//        }
        return Result.healthy();
    }
}
