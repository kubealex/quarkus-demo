package org.acme;

import java.io.IOException;
import java.net.InetAddress;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ResponseService {

    public ResponseBean setResponseBean(ResponseBean responseBean) throws InterruptedException, IOException 
    {
        responseBean.setHostName(InetAddress.getLocalHost().getHostName());
        responseBean.setPid(ProcessHandle.current().pid());
        responseBean.setUserId(Utils.getUid(System.getProperty("user.name")));
        responseBean.setGroupId(Utils.getGid(System.getProperty("user.name")));
        responseBean.setOsVersion(System.getProperty("os.version"));
        responseBean.setOsArchitecture(System.getProperty("os.arch"));
        responseBean.setSecretContent(Utils.getSecretContent());
        if (System.getenv("SESSION_NAME") != null ){
        responseBean.setSessionName(System.getenv("SESSION_NAME"));
    }
        return responseBean;
    }


}
