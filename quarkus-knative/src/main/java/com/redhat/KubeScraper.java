package com.redhat;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.fabric8.kubernetes.client.KubernetesClient;

@Path("/")
public class KubeScraper {

@Inject 
KubernetesClient kubernetesClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String scrape() {
        System.out.println(kubernetesClient.getNamespace());
        return kubernetesClient.pods().list().toString() + "   " + kubernetesClient.getNamespace();
    }
}
