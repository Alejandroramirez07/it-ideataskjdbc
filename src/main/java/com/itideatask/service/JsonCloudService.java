package com.itideatask.service;

import com.itideatask.model.AwsCloud;
import com.itideatask.model.AzureCloud;
import com.itideatask.util.JsonUtil;

import java.util.List;

public class JsonCloudService {
    public List<AwsCloud> getAwsClouds(String path) {
        return JsonUtil.readListFromJson(path,AwsCloud.class);
    }

    public List<AzureCloud> getAzureClouds(String path) {
        return JsonUtil.readListFromJson(path, AzureCloud.class);
    }

    public void exportAzureClouds(String jsonPath, List<AzureCloud> clouds) {
        JsonUtil.writeListToJson(jsonPath, clouds);
    }

    public void exportAwsClouds(String jsonPath, List<AwsCloud> clouds) {
        JsonUtil.writeListToJson(jsonPath, clouds);
    }
}
