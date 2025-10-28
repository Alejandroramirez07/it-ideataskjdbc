package com.itideatask.service;

import com.itideatask.service.Impl.ClientServiceImpl;
import com.itideatask.service.Impl.ClientServiceMyBatisImpl;

public class ServiceFactory {

    public static ClientService getClientService (String type) {

        if ("mybatis".equalsIgnoreCase(type)) {
            return new ClientServiceMyBatisImpl();
        }else {
            return new ClientServiceImpl();
        }
    }
}
