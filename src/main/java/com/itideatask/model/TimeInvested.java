package com.itideatask.model;

public class TimeInvested {

    private String startTime;
    private String finishTime;
    private int projectCode;

    public TimeInvested() {}

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    @Override
    public String toString() {
        return "TimeInvested{" +
                "startTime='" + startTime +
                ", finishTime='" + finishTime +
                ", projectCode=" + projectCode +
                '}';
    }

}

