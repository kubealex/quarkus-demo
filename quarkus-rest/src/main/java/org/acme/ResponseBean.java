package org.acme;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ResponseBean
{
    private String sessionName;
    private String secretContent;

    public String setSessionName(String sessionName)
    {
        return this.sessionName = sessionName;
    }

    public String getSessionName()
    {
        return this.sessionName;
    }

    public String setSecretContent(String secretContent)
    {
        return this.secretContent = secretContent;
    }

    public String getSecretContent()
    {
        return this.sessionName;
    }    
}