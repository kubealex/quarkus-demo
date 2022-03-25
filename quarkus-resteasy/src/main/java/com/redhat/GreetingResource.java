package com.redhat;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@ApplicationScoped
@Path("/hello/")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @Path("es")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloEs() {
        return "Hola RESTeasy!";
    }

    @Path("{language}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloLanguage(@PathParam String language) {
        return greetingService.greet(language);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam String language) {
        return "Hello! If you invoke me specifying your language (/hello/{language}), I will do my best to greet you in your language";
    }
}
