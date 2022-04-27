package org.acme;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("")
public class ApplicationService {

    @Inject
    ResponseBean responseBean;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello! If you invoke me specifying your language (/hello/{language}), I will do my best to greet you in your language";
    }

    @GET
    @Path("/myservice")
    @Produces(MediaType.APPLICATION_JSON)
    public String svc() throws UnknownHostException {
        responseBean.setSessionName(System.get)
        return "Diplomatico! Hostname: " + InetAddress.getLocalHost().getHostName();
    }
}
