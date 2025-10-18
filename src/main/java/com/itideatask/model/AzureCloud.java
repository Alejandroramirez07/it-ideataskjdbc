package com.itideatask.model;

public class AzureCloud {
    private int projectCode;
    private int numberOfRegions;

    public AzureCloud() {}

    public AzureCloud (int projectCode, int numberOfRegions){
        this.projectCode=projectCode;
        this.numberOfRegions=numberOfRegions;
    }

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    public int getNumberOfRegions() {
        return numberOfRegions;
    }

    public void setNumberOfRegions(int numberORegion) {
        this.numberOfRegions = numberORegion;
    }

    @Override
    public String toString() {
        return "AzureCloud{" +
                "projectCode=" + projectCode +
                ", numberOfRegion=" + numberOfRegions +
                '}';
    }
}
