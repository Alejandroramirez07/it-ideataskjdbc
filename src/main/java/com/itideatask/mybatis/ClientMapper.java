package com.itideatask.mybatis;

import com.itideatask.model.Client;
import org.apache.ibatis.annotations.Param;

public interface ClientMapper {
    Client findById(@Param("email") String email);
    void insert(Client client);
    void updatePassword(@Param("email") String email, @Param("password") String password);
    void delete(@Param("email") String email);
}
