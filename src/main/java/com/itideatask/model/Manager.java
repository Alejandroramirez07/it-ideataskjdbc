package com.itideatask.model;

public class Manager {
    String username;
    String email;
    String password;
    int project_code;
    int employee_code;

    public Manager(String username, String email, String password, int project_code, int employee_code){
        this.username=username;
        this.email=email;
        this.password=password;
        this.project_code=project_code;
        this.employee_code=employee_code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProject_code() {
        return project_code;
    }

    public void setProject_code(int project_code) {
        this.project_code = project_code;
    }

    public int getEmployee_code() {
        return employee_code;
    }

    public void setEmployee_code(int employee_code) {
        this.employee_code = employee_code;
    }
}
