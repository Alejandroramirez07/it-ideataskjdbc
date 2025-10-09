package com.itideatask.service;

import com.itideatask.model.JavaProjects;
import com.itideatask.model.TimeInvested;

import java.util.List;

public interface SaxService {

    List<JavaProjects> getJavaProjectsFromXml(String filePath);

    List<TimeInvested> getTimeInvestedFromXml(String filePath);
}
