package com.redhat;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    public String greet(String language) {
        switch (language) {
            case "it":
                return "Ciao RESTeasy!";
            case "en":
                return "Hello RESTeasy!";
        }
        return "Whatever your language is, I greet you with a warm HELLO!";
    }
}
