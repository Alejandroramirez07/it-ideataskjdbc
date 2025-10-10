package com.itideatask.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "java_project")
@XmlType(propOrder = {"projectCode", "name", "clientComments", "clientScore", "javaVersion"})
public class JavaProject {
    private int projectCode;
    private String name;
    private String clientComments;
    private int clientScore;
    private double javaVersion;

    @XmlElement(name= "project_code")
    public int getProjectCode() {
        return projectCode;
    }


    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "client_comments")
    public String getClientComments() {
        return clientComments;
    }

    public void setClientComments(String clientComments) {
        this.clientComments = clientComments;
    }

    @XmlElement(name= "client_score_1_10")
    public int getClientScore() {
        return clientScore;
    }

    public void setClientScore(int clientScore) {
        this.clientScore = clientScore;
    }

    @XmlElement(name="java_version")
    public double getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(double javaVersion) {
        this.javaVersion = javaVersion;
    }

    @Override
    public String toString() {
        return "JavaProject{" +
                "projectCode=" + projectCode +
                ", name='" + name +
                ", clientComments='" + clientComments +
                ", clientScore=" + clientScore +
                ", javaVersion=" + javaVersion +
                '}';
    }

}
