package com.itideatask.service;

import com.itideatask.model.Client;

public interface ClientService {

    Client getClient(String email);

    boolean insertClient(Client client);

    boolean updatePassword(String email, String newPassword);

    boolean deleteClient(String email);
}
