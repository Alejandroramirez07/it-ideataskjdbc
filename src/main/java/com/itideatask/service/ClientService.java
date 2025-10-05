package com.itideatask.service;

import com.itideatask.model.Client;
import com.itideatask.dao.ClientDAO;

public class ClientService {
    private final ClientDAO clientDAO = new ClientDAO();
    public Client getClient(String email){
        return clientDAO.findById(email);
    }
}
