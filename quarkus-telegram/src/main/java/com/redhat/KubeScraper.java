package com.redhat;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
    public String scrape() throws UnknownHostException {
        System.out.println(kubernetesClient.getNamespace());
        return "The application is served by "+ InetAddress.getLocalHost().getHostName() + " in namespace: " + kubernetesClient.getNamespace();
    }
}
