package io.github.epeee.shipkit.demo.impl;

import io.github.epeee.shipkit.demo.api.Service;

/**
 * Implementation of a {@link Service}.
 *
 * @since 0.0.1
 */
public class SampleService implements Service {

    @Override
    public boolean doSomething() {
        return true;
    }
}
