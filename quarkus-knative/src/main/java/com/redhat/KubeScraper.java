package com.redhat;

import java.io.Console;

import javax.inject.Inject;

import io.fabric8.kubernetes.client.KubernetesClient;

public class KubeScraper {

    @Inject
    KubernetesClient kubernetesClient;
    public String scrape() {
        System.out.println(kubernetesClient.getNamespace());
        return kubernetesClient.getNamespace();
    }
}