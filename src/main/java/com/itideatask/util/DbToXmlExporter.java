package com.itideatask.util;

import com.itideatask.config.ConnectionPool;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbToXmlExporter {

    private static final String JAVA_PROJECTS_PATH = "src/main/java/com/itideatask/util/xml/java_projects.xml";
    private static final String TIME_INVESTED_PATH = "src/main/java/com/itideatask/util/xml/time_invested.xml";

    public void exportJavaProjects() {
        String sql = "SELECT project_code, name, client_comments, client_score_1_10, java_version FROM java_projects";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             FileOutputStream fos = new FileOutputStream(JAVA_PROJECTS_PATH)) {

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(fos, "UTF-8");

            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("java_projects");

            while (rs.next()) {
                writer.writeStartElement("project");

                writer.writeStartElement("project_code");
                writer.writeCharacters(String.valueOf(rs.getInt("project_code")));
                writer.writeEndElement();

                writer.writeStartElement("name");
                writer.writeCharacters(rs.getString("name"));
                writer.writeEndElement();

                writer.writeStartElement("client_comments");
                writer.writeCharacters(rs.getString("client_comments"));
                writer.writeEndElement();

                writer.writeStartElement("client_score_1_10");
                writer.writeCharacters(String.valueOf(rs.getInt("client_score_1_10")));
                writer.writeEndElement();

                writer.writeStartElement("java_version");
                writer.writeCharacters(String.valueOf(rs.getDouble("java_version")));
                writer.writeEndElement();

                writer.writeEndElement();
            }

            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();

            System.out.println("Exported java_projects → " + JAVA_PROJECTS_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportTimeInvested() {
        String sql = "SELECT start_time, finish_time, project_code FROM time_invested";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             FileOutputStream fos = new FileOutputStream(TIME_INVESTED_PATH)) {

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(fos, "UTF-8");

            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("time_invested_list");

            while (rs.next()) {
                writer.writeStartElement("time");

                writer.writeStartElement("start_time");
                writer.writeCharacters(rs.getString("start_time"));
                writer.writeEndElement();

                writer.writeStartElement("finish_time");
                writer.writeCharacters(rs.getString("finish_time"));
                writer.writeEndElement();

                writer.writeStartElement("project_code");
                writer.writeCharacters(String.valueOf(rs.getInt("project_code")));
                writer.writeEndElement();

                writer.writeEndElement();
            }

            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();

            System.out.println("Exported time_invested → " + TIME_INVESTED_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportAll() {
        exportJavaProjects();
        exportTimeInvested();
    }

}
