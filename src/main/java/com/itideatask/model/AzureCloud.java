package com.itideatask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AzureCloud {
    @JsonProperty("project_code")
    private int projectCode;

    @JsonProperty("number_of_regions")
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
