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
}
