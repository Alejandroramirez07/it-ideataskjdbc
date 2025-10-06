package com.itideatask.service;

import com.itideatask.model.Client;
import com.itideatask.dao.ClientDAO;

public class ClientService {
    private final ClientDAO clientDAO = new ClientDAO();

    public Client getClient(String email) {
        return clientDAO.findById(email);
    }

    public boolean insertClient(Client client) {
        return clientDAO.insert(client);
    }

    public boolean updatePassword(String email, String newPassword) {
        return clientDAO.updatePassword(email, newPassword);
    }

    public boolean deleteClient(String email) {
        return clientDAO.delete(email);
    }
}

