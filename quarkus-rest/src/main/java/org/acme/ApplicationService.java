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
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
@Path("")
public class ApplicationService {

    @Inject
    ResponseService responseService;

    @ConfigProperty(name = "cpu.cores", defaultValue = "8")
    Integer numCore;
    @ConfigProperty(name = "cpu.threads", defaultValue = "2")
    Integer numThreadsPerCore;
    @ConfigProperty(name = "cpu.load", defaultValue = "0.8")
    Double load;
    @ConfigProperty(name = "cpu.testDuration", defaultValue = "60000")
    Long duration;

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
    public String stress() {
        for (int thread = 0; thread < numCore * numThreadsPerCore; thread++) {
            System.out.println("launching locking thread....");
            new BusyThread("Thread" + thread, load, duration).start();
        }
        return "Stress test in place, look at autoscaling";
    }

}
