package org.example.bigwebbackend;

import org.example.bigwebbackend.repositories.event.EventRepository;
import org.example.bigwebbackend.repositories.event.MySqlEventRepository;
import org.example.bigwebbackend.services.EventService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {
    public HelloApplication() {
        // Ukljucujemo validaciju
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        // Definisemo implementacije u dependency container-u
        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                //todo: kad napravis inMemory ovde sredi ostatak
                this.bind(MySqlEventRepository.class).to(EventRepository.class).in(Singleton.class);

                this.bindAsContract(EventService.class);
            }
        };
        register(binder);

        // Ucitavamo resurse
        packages("org.example.resources");
    }
}