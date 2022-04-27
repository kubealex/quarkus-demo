package org.acme;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ResponseService {

    public ResponseBean setResponseBean(ResponseBean responseBean) throws UnknownHostException 
    {
        responseBean.setHostName(InetAddress.getLocalHost().getHostName());
        responseBean.setPid(ProcessHandle.current().pid());
        return responseBean;
    }


}
