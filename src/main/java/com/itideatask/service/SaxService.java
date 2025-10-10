package com.itideatask.service;

import com.itideatask.model.JavaProject;
import com.itideatask.model.TimeInvested;
import  com.itideatask.service.JaxbExporter;

import java.util.List;

public interface SaxService {

    List<JavaProject> getJavaProjectsFromXml(String filePath);

    List<TimeInvested> getTimeInvestedFromXml(String filePath);



}
