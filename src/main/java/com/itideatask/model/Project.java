package com.itideatask.model;

public class Project {
    int project_code;
    String project_name;

    public Project(int project_code, String project_name){
        this.project_code=project_code;
        this.project_name=project_name;
    }

    public int getProject_code() {
        return project_code;
    }

    public void setProject_code(int project_code) {
        this.project_code = project_code;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    @Override
    public String toString(){
        return "The project name is " + project_name + ". The project code is " +  project_code;
    }
}
