package com.itideatask;

import com.itideatask.model.Client;
import com.itideatask.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Logger LOGGER = LogManager.getLogger(Main.class);
        Scanner scanner = new Scanner(System.in);

        ClientService clientService = new ClientService();
        LOGGER.info("enter the email to find the client");
        String emailClientFinder = scanner.nextLine();
        Client client = clientService.getClient(String.valueOf(emailClientFinder));
        LOGGER.info(client);


    }
}