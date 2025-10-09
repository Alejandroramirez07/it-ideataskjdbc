package com.itideatask.dao;

import com.itideatask.model.Client;

public interface IClientDAO {
    Client findById(String email);
    boolean insert(Client client);
    boolean updatePassword(String email, String newPassword);
    boolean delete(String email);

}