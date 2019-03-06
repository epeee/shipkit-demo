package io.github.epeee.shipkit.demo.api;

/**
 * Defines how a {@link Service} looks like.
 *
 * @since 0.0.1
 */
public interface Service {

    /**
     * Default implementation.
     */
    default boolean doSomething() {
        return false;
    }
}
