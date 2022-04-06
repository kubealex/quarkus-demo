package com.redhat;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.fabric8.kubernetes.client.KubernetesClient;

@ApplicationScoped
public class BackendService {
    @Inject
    KubernetesClient kubernetesClient;

    public String retrieveNamespace() {
        return "The namespace is " + kubernetesClient.getNamespace();
    }
}