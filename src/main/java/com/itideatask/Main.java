package com.itideatask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        final Logger LOGGER = LogManager.getLogger(Main.class);
        ClientService clientService = new ClientService(),
        Client client = clientService.getClient(1);
        LOGGER.info(client);


    }
}