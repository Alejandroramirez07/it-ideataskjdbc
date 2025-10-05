package com.itideadtask.service;

public class ClientService {
    private final ClientDAO clientDAO = new ClientDAO();
    public CLient getClient(int id){
        return ClientDAO.findById(id);
    }
}
