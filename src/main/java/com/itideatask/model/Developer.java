package com.itideatask.model;

public class Developer {
    String username;
    String email;
    String password;
    int projectCode;
    int employeeCode;
    int manager_employeeCode;

    public Developer(String username, String email, String password, int projectCode, int employeeCode, int manager_employeeCode){
        this.username=username;
        this.email=email;
        this.password=password;
        this.projectCode=projectCode;
        this.employeeCode=employeeCode;
        this.manager_employeeCode=manager_employeeCode;
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
        return projectCode;
    }

    public void setProject_code(int projectCode) {
        this.projectCode = projectCode;
    }

    public int getEmployee_code() {
        return employeeCode;
    }

    public void setEmployee_code(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public int getManager_employeeCode() {
        return manager_employeeCode;
    }

    public void setManager_employeeCode(int manager_employeeCode) {
        this.manager_employeeCode = manager_employeeCode;
    }

    @Override
    public String toString() {
        return " username:  " + this.username  + ", email : " + this.email + ", project code: " + this.projectCode + " password is secret ";
    }
}


