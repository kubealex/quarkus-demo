package org.acme;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ResponseBean
{
    private String sessionName;
    private String hostName;
    private Long pid;
    private String userId;
    private String groupId;
    private String secretContent;

    public ResponseBean() {
        this("VARIABLE IS NOT DEFINED", "FILE NOT FOUND");
    }
    public ResponseBean(String sessionName, String secretContent) {
        this.sessionName = sessionName;
        this.secretContent = secretContent;
    }
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
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }    
}