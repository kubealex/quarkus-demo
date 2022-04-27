package org.acme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    public static String getUid(String username) throws InterruptedException, IOException {
        String command = "id -u " + username;
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        process.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String uid = buf.readLine();
        return uid;
    }

    public static String getGid(String username) throws InterruptedException, IOException {
        String command = "id -g " + username;
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        process.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String uid = buf.readLine();
        return uid;
    }    

    public static String getSecretContent() throws IOException {
        Path secretFile = Paths.get("/home/alerossi/configfile");
        if (Files.exists(secretFile)) {
            String content = new String(Files.readAllBytes(secretFile));
            System.out.println(content);
            return content;
        }
        return "CONFIGURATION FILE NOT FOUND";
    }
}