package com.petzila.api.producer;

import org.dozer.DozerBeanMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class DozerMapperProducer {
    @Produces
    @ApplicationScoped
    public DozerBeanMapper get() {
        return new DozerBeanMapper();
    }
}
