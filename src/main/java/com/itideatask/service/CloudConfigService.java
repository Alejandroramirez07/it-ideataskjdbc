package com.itideatask.service;

import com.itideatask.util.JsonValidator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class CloudConfigService {

    private static final String AWS_SCHEMA = "src/main/resources/schemas/aws-cloud-schema.json";
    private static final String AZURE_SCHEMA = "src/main/resources/schemas/azure-cloud-schema.json";
    private static final String AWS_CONFIG_PATH = "src/main/resources/json/aws_cloud.json";
    private static final String AZURE_CONFIG_PATH = "src/main/resources/json/azure_cloud.json";

    private List<CloudProject> awsProjects = new ArrayList<>();
    private List<CloudProject> azureProjects = new ArrayList<>();

    public boolean validateCloudConfigurations() {
        System.out.println("=== Validating Cloud Project Configurations ===");

        boolean awsValid = validateAwsConfig();
        boolean azureValid = validateAzureConfig();

        if (awsValid && azureValid) {
            System.out.println("All cloud project configurations are valid!");
            loadProjectData();
            return true;
        } else {
            System.err.println("Cloud project configuration validation failed!");
            return false;
        }
    }

    public boolean validateAwsConfig() {
        System.out.println("Validating AWS projects configuration...");
        return JsonValidator.validate(AWS_CONFIG_PATH, AWS_SCHEMA);
    }

    public boolean validateAzureConfig() {
        System.out.println("Validating Azure projects configuration...");
        return JsonValidator.validate(AZURE_CONFIG_PATH, AZURE_SCHEMA);
    }

    private void loadProjectData() {
        try {
            JSONArray awsArray = new JSONArray(new JSONTokener(new FileInputStream(AWS_CONFIG_PATH)));
            for (int i = 0; i < awsArray.length(); i++) {
                JSONObject project = awsArray.getJSONObject(i);
                awsProjects.add(new CloudProject(
                        project.getInt("projectCode"),
                        project.getInt("numberOfRegions"),
                        "AWS"
                ));
            }

            JSONArray azureArray = new JSONArray(new JSONTokener(new FileInputStream(AZURE_CONFIG_PATH)));
            for (int i = 0; i < azureArray.length(); i++) {
                JSONObject project = azureArray.getJSONObject(i);
                azureProjects.add(new CloudProject(
                        project.getInt("projectCode"),
                        project.getInt("numberOfRegions"),
                        "Azure"
                ));
            }

            System.out.println("Loaded " + awsProjects.size() + " AWS projects and " +
                    azureProjects.size() + " Azure projects");

        } catch (Exception e) {
            System.err.println("Error loading project data: " + e.getMessage());
        }
    }

    public List<CloudProject> getAwsProjects() {
        return new ArrayList<>(awsProjects);
    }

    public List<CloudProject> getAzureProjects() {
        return new ArrayList<>(azureProjects);
    }

    public List<CloudProject> getAllProjects() {
        List<CloudProject> allProjects = new ArrayList<>();
        allProjects.addAll(awsProjects);
        allProjects.addAll(azureProjects);
        return allProjects;
    }

    public CloudProject findProjectByCode(int projectCode) {
        for (CloudProject project : getAllProjects()) {
            if (project.getProjectCode() == projectCode) {
                return project;
            }
        }
        return null;
    }

    public int getTotalRegions() {
        return awsProjects.stream().mapToInt(CloudProject::getNumberOfRegions).sum() +
                azureProjects.stream().mapToInt(CloudProject::getNumberOfRegions).sum();
    }

    public static class CloudProject {
        private int projectCode;
        private int numberOfRegions;
        private String cloudProvider;

        public CloudProject(int projectCode, int numberOfRegions, String cloudProvider) {
            this.projectCode = projectCode;
            this.numberOfRegions = numberOfRegions;
            this.cloudProvider = cloudProvider;
        }

        public int getProjectCode() { return projectCode; }
        public int getNumberOfRegions() { return numberOfRegions; }
        public String getCloudProvider() { return cloudProvider; }

        @Override
        public String toString() {
            return String.format("Project %d (%s) - %d regions",
                    projectCode, cloudProvider, numberOfRegions);
        }
    }
}
