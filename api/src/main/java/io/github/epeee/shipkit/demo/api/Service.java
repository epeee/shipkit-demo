package io.github.epeee.shipkit.demo.api;

/**
 * Defines how a {@link Service} looks like.
 */
public interface Service {

    default boolean doSomething() {
        return false;
    }
}
