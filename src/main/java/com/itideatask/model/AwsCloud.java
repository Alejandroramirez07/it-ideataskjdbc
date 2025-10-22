package com.itideatask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AwsCloud {

    @JsonProperty("project_code")
    private int projectCode;

    @JsonProperty("number_of_regions")
    private int numberOfRegions;

    public AwsCloud() {}

    public AwsCloud(int projectCode, int numberOfRegions){
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

    public void setNumberOfRegions(int numberOfRegions) {
        this.numberOfRegions = numberOfRegions;
    }

    @Override
    public String toString() {
        return "AwsCloud{" +
                "projectCode=" + projectCode +
                ", numberOfRegions=" + numberOfRegions +
                '}';
    }
}
