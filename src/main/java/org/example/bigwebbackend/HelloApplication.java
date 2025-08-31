package org.example.bigwebbackend;

import org.example.bigwebbackend.repositories.category.CategoryRepository;
import org.example.bigwebbackend.repositories.category.MySqlCategoryRepository;
import org.example.bigwebbackend.repositories.comment.CommentRepository;
import org.example.bigwebbackend.repositories.comment.MySqlCommentRepository;
import org.example.bigwebbackend.repositories.event.EventRepository;
import org.example.bigwebbackend.repositories.event.MySqlEventRepository;
import org.example.bigwebbackend.repositories.tag.MySqlTagRepository;
import org.example.bigwebbackend.repositories.tag.TagRepository;
import org.example.bigwebbackend.repositories.user.MySqlUserRepository;
import org.example.bigwebbackend.repositories.user.UserRepository;
import org.example.bigwebbackend.services.*;
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
                this.bind(MySqlCategoryRepository.class).to(CategoryRepository.class).in(Singleton.class);
                this.bind(MySqlCommentRepository.class).to(CommentRepository.class).in(Singleton.class);
                this.bind(MySqlEventRepository.class).to(EventRepository.class).in(Singleton.class);
                this.bind(MySqlTagRepository.class).to(TagRepository.class).in(Singleton.class);
                this.bind(MySqlUserRepository.class).to(UserRepository.class).in(Singleton.class);

                this.bindAsContract(CategoryService.class);
                this.bindAsContract(CommentService.class);
                this.bindAsContract(EventService.class);
                this.bindAsContract(TagService.class);
                this.bindAsContract(UserService.class);
            }
        };
        register(binder);

        // Ucitavamo resurse
        packages("org.example.bigwebbackend.resources");
    }
}