package com.itideatask.model;

public class Monitoring {
    int project_code;
    String monitor_comments;
    int number_incidents;

    public Monitoring(int project_code, String monitor_comments, int number_incidents){
        this.project_code=project_code;
        this.monitor_comments=monitor_comments;
        this.number_incidents=number_incidents;
    }

    public int getProject_code(){
        return project_code;
    }

    public void setProject_code(int project_code) {
        this.project_code = project_code;
    }

    public String getMonitor_comments(){
        return monitor_comments;
    }

    public void setMonitor_comments(String monitor_comments) {
        this.monitor_comments = monitor_comments;
    }

    public int getNumber_incidents() {
        return number_incidents;
    }

    public void setNumber_incidents(int number_incidents) {
        this.number_incidents = number_incidents;
    }
}

