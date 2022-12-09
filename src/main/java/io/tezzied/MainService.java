package io.tezzied;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class MainService {
    @Produces
    public String sayHello() {
        return "Hello from UndertowJaxrs server!";
    }
}
