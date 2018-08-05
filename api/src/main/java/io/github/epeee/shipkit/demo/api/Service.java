package io.github.epeee.shipkit.demo.api;

public interface Service {

    default boolean doSomething() {
        return false;
    }
}
