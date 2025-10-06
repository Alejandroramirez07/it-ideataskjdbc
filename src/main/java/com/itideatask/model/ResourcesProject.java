package com.itideatask.model;

public class ResourcesProject {
    float totalSpentUsd;
    String commentsSpending;
    int projectCode;
    int reportCode;

    public ResourcesProject(float totalSpentUsd, String commentsSpending, int projectCode, int reportCode){
        this.totalSpentUsd=totalSpentUsd;
        this.commentsSpending=commentsSpending;
        this.projectCode=projectCode;
        this.reportCode=reportCode;
    }

    public float getTotalSpentUsd() {
        return totalSpentUsd;
    }

    public void setTotalSpentUsd(float totalSpentUsd) {
        this.totalSpentUsd = totalSpentUsd;
    }

    public String getCommentsSpending() {
        return commentsSpending;
    }

    public void setCommentsSpending(String commentsSpending) {
        this.commentsSpending = commentsSpending;
    }

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    public int getReportCode() {
        return reportCode;
    }

    public void setReportCode(int reportCode) {
        this.reportCode = reportCode;
    }
}

