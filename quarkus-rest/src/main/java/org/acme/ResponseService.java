package org.acme;

import java.io.IOException;
import java.net.InetAddress;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class ResponseService {

    @Inject 
    Utils utils;

    public ResponseBean setResponseBean(ResponseBean responseBean) throws InterruptedException, IOException 
    {
        responseBean.setHostName(InetAddress.getLocalHost().getHostName());
        responseBean.setPid(ProcessHandle.current().pid());
        responseBean.setUserId(utils.getUid(System.getProperty("user.name")));
        responseBean.setGroupId(utils.getGid(System.getProperty("user.name")));
        responseBean.setOsVersion(System.getProperty("os.version"));
        responseBean.setOsArchitecture(System.getProperty("os.arch"));
        responseBean.setSecretContent(utils.getSecretContent());
        responseBean.setSessionName(System.getenv("SESSION_NAME"));
        return responseBean;
    }


}
