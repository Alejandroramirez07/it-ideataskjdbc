package com.itideatask.model;

public class JavaProjects {
    private int projectCode;
    private String name;
    private String clientComments;
    private int clientScore;
    private double javaVersion;

    public JavaProjects() {}


    public int getProjectCode() {
        return projectCode;

    }
    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientComments() {
        return clientComments;
    }

    public void setClientComments(String clientComments) {
        this.clientComments = clientComments;
    }

    public int getClientScore() {
        return clientScore;
    }

    public void setClientScore(int clientScore) {
        this.clientScore = clientScore;
    }

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
