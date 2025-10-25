package com.itideatask.mybatis.impl;

import com.itideatask.dao.IClientDAO;
import com.itideatask.mybatis.ClientMapper;
import com.itideatask.model.Client;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class ClientMyBatisImpl implements IClientDAO {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client findById(String email) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ClientMapper mapper = session.getMapper(ClientMapper.class);
            return mapper.findById(email);
        }
    }

    @Override
    public boolean insert(Client client) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ClientMapper mapper = session.getMapper(ClientMapper.class);
            mapper.insert(client);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePassword(String email, String newPassword) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ClientMapper mapper = session.getMapper(ClientMapper.class);
            mapper.updatePassword(email, newPassword);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String email) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ClientMapper mapper = session.getMapper(ClientMapper.class);
            mapper.delete(email);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}