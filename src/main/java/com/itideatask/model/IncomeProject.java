package com.itideatask.model;

public class IncomeProject {
    float totalIncomeUsd;
    String commentsIncome;
    int projectCode;
    int reportCode;

    public IncomeProject(float totalIncomeUsd, String commentsIncome, int projectCode, int reportCode){
        this.totalIncomeUsd=totalIncomeUsd;
        this.commentsIncome=commentsIncome;
        this.projectCode=projectCode;
        this.reportCode=reportCode;
    }

    public float getTotalIncomeUsd() {
        return totalIncomeUsd;
    }

    public void setTotalIncomeUsd(float totalIncomeUsd) {
        this.totalIncomeUsd = totalIncomeUsd;
    }

    public String getCommentsIncome() {
        return commentsIncome;
    }

    public void setCommentsIncome(String commentsIncome) {
        this.commentsIncome = commentsIncome;
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
