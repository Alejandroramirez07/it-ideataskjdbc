package com.itideatask.service.Impl;

import com.itideatask.dao.IClientDAO;
import com.itideatask.model.Client;
import com.itideatask.dao.impl.ClientDAOImpl;
import com.itideatask.service.ClientService;

public class ClientServiceImpl implements ClientService {

    private final IClientDAO clientDAO = new ClientDAOImpl();

    @Override
    public Client getClient(String email) {
        return clientDAO.findById(email);
    }

    @Override
    public boolean insertClient(Client client) {
        return clientDAO.insert(client);
    }

    @Override
    public boolean updatePassword(String email, String newPassword) {
        return clientDAO.updatePassword(email, newPassword);
    }

    @Override
    public boolean deleteClient(String email) {
        return clientDAO.delete(email);
    }
}

