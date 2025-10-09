package com.itideatask.service.Impl;

import com.itideatask.model.JavaProjects;
import com.itideatask.model.TimeInvested;
import com.itideatask.service.SaxService;
import com.itideatask.util.SaxParserUtil;

import java.util.List;

public class SaxServiceImpl implements SaxService {
    private final SaxParserUtil parserUtil = new SaxParserUtil();
    @Override
    public List<JavaProjects> getJavaProjectsFromXml(String filePath) {
        return parserUtil.parseJavaProjects(filePath);
    }
    @Override
    public List<TimeInvested> getTimeInvestedFromXml(String filePath) {
        return parserUtil.parseTimeInvested(filePath);
    }
}
