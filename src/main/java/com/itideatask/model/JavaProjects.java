package com.itideatask.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name="java_projects")
public class JavaProjects {

    private List<JavaProject> projects;

    @XmlElement(name= "java_project")
    public List<JavaProject> getProjects(){
        return projects;
    }

    public void setProjects(List<JavaProject> projects) {
        this.projects = projects;
    }
}
