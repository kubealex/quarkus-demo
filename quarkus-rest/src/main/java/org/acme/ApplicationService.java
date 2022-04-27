package org.acme;

import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
@Path("")
public class ApplicationService {

    @Inject
    ResponseService responseService;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String svc() throws InterruptedException, IOException {
        ResponseBean responseBean = new ResponseBean();
        responseBean = responseService.setResponseBean(responseBean);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseBean);
    }

    @GET
    @Path("/stress")
    public void stress() {
        int numCore = 1;
        int numThreadsPerCore = 2;
        double load = 0.8;
        final long duration = 50000;
        for (int thread = 0; thread < numCore * numThreadsPerCore; thread++) {
            System.out.println("STRESSS");
            new BusyThread("Thread" + thread, load, duration).start();
        }
    }

}
