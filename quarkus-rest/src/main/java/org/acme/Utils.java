package org.acme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class Utils {

    @ConfigProperty(name = "secretfile.path", defaultValue = "/config/configfile")
    String secretFile;

    public String getUid(String username) throws InterruptedException, IOException {
        String command = "id -u " + username;
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        process.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String uid = buf.readLine();
        return uid;
    }

    public String getGid(String username) throws InterruptedException, IOException {
        String command = "id -g " + username;
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        process.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String uid = buf.readLine();
        return uid;
    }    

    public String getSecretContent() {
        System.out.println(secretFile);
        try {
            Path secretPath = Paths.get(secretFile);
            String content = new String(Files.readAllBytes(secretPath));
            System.out.println(content);
            return content;
        } catch (IOException e) {
            return "CONFIGURATION FILE NOT FOUND";
        }
    }
}