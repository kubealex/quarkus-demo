package org.acme;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.component.telegram.model.IncomingMessage;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.quarkus.arc.Unremovable;

@ApplicationScoped
@Unremovable
public class TelegramBean {

    @Inject
    KubernetesClient kubernetesClient;

    public String translate(IncomingMessage message) throws UnknownHostException {
        switch (message.getText()) {
            case "namespace":
                return "Namespace is " + kubernetesClient.getNamespace();
            case "hostname":
                return "Hostname is " + InetAddress.getLocalHost().getHostName();
        }
        return "Please use one fo the allowed commands";
        // do process
    }
}
