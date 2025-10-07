package com.itideatask.service;

import com.itideatask.model.JavaProjects;
import com.itideatask.model.TimeInvested;
import com.itideatask.util.SaxParserUtil;

import java.util.List;

public class SaxService {
    private final SaxParserUtil parserUtil = new SaxParserUtil();

    public List<JavaProjects> getJavaProjectsFromXml(String filePath) {
        return parserUtil.parseJavaProjects(filePath);
    }

    public List<TimeInvested> getTimeInvestedFromXml(String filePath) {
        return parserUtil.parseTimeInvested(filePath);
    }
}
