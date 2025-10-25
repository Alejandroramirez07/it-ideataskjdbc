package com.itideatask.mybatis.impl;

import com.itideatask.dao.IProjectDAO;
import com.itideatask.model.Project;
import com.itideatask.mybatis.ProjectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class ProjectMyBatisImpl implements IProjectDAO {

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
    public Project findById(Integer projectCode) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProjectMapper mapper = session.getMapper(ProjectMapper.class);
            return mapper.findById(projectCode);
        }
    }

    @Override
    public boolean insert(Project project) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProjectMapper mapper = session.getMapper(ProjectMapper.class);
            mapper.insert(project);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Project project) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProjectMapper mapper = session.getMapper(ProjectMapper.class);
            mapper.update(project);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer projectCode) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProjectMapper mapper = session.getMapper(ProjectMapper.class);
            mapper.delete(projectCode);
            session.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Project> findAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProjectMapper mapper = session.getMapper(ProjectMapper.class);
            return mapper.findAll();
        }
    }

}