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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
@Path("")
public class ApplicationService {

    @Inject
    ResponseService responseService;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String svc() throws UnknownHostException, JsonProcessingException {
        ResponseBean responseBean = new ResponseBean();
        responseBean = responseService.setResponseBean(responseBean);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseBean);
    }
}
