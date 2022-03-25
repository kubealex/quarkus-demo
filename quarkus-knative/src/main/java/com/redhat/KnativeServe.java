package com.redhat;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class KnativeServe {

    @Inject
    BackendService backendService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/namespace")
    public String getNamespace() {
        return backendService.retrieveNamespace();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}
