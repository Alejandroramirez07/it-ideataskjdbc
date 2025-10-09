package com.itideatask.dao;

import com.itideatask.model.Client;

public interface ClientDAO {
    Client findById(String email);
    boolean insert(Client client);
    boolean updatePassword(String email, String newPassword);
    boolean delete(String email);

}