package io.github.epeee.shipkit.demo.impl;

import io.github.epeee.shipkit.demo.api.Service;

/**
 * Implementation of a {@link Service}.
 */
public class SampleService implements Service {

    @Override
    public boolean doSomething() {
        System.out.println("SampleService");
        return true;
    }
}
