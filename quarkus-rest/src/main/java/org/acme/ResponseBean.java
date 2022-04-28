package org.acme;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ResponseBean {
    private String sessionName;
    private String hostName;
    private Long pid;
    private String userId;
    private String groupId;
    private String osVersion;
    private String osArchitecture;
    private String secretContent;

    public ResponseBean() {
        this("VARIABLE IS NOT DEFINED");
    }

    public ResponseBean(String sessionName) {
        this.sessionName = sessionName;
    }

    public void setSessionName(String sessionName) {
        if (sessionName != null)
            this.sessionName = sessionName;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public void setSecretContent(String secretContent) {
        this.secretContent = secretContent;
    }

    public String getSecretContent() {
        return this.secretContent;
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

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsArchitecture() {
        return osArchitecture;
    }

    public void setOsArchitecture(String osArchitecture) {
        this.osArchitecture = osArchitecture;
    }
}
