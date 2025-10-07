package com.itideatask.util;

import com.itideatask.model.JavaProjects;
import com.itideatask.model.TimeInvested;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SaxParserUtil {

    public List<JavaProjects> parseJavaProjects(String filePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            JavaProjectsHandler handler = new JavaProjectsHandler();
            parser.parse(new File(filePath), handler);
            return handler.getProjects();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<TimeInvested> parseTimeInvested(String filePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            TimeInvestedHandler handler = new TimeInvestedHandler();
            parser.parse(new File(filePath), handler);
            return handler.getTimes();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static class JavaProjectsHandler extends DefaultHandler {
        private final List<JavaProjects> projects = new ArrayList<>();
        private JavaProjects current;
        private StringBuilder content = new StringBuilder();

        public List<JavaProjects> getProjects() { return projects; }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            content.setLength(0);
            if ("project".equalsIgnoreCase(qName)) {
                current = new JavaProjects();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            String value = content.toString().trim();
            if (current != null) {
                switch (qName.toLowerCase()) {
                    case "project_code":
                        current.setProjectCode(Integer.parseInt(value));
                        break;
                    case "name":
                        current.setName(value);
                        break;
                    case "client_comments":
                        current.setClientComments(value);
                        break;
                    case "client_score_1_10":
                        current.setClientScore(Integer.parseInt(value));
                        break;
                    case "java_version":
                        current.setJavaVersion(Double.parseDouble(value));
                        break;
                    case "project":
                        projects.add(current);
                        current = null;
                        break;
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            content.append(ch, start, length);
        }
    }

    private static class TimeInvestedHandler extends DefaultHandler {
        private final List<TimeInvested> times = new ArrayList<>();
        private TimeInvested current;
        private StringBuilder content = new StringBuilder();

        public List<TimeInvested> getTimes() { return times; }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            content.setLength(0);
            if ("time".equalsIgnoreCase(qName)) {
                current = new TimeInvested();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            String value = content.toString().trim();
            if (current != null) {
                switch (qName.toLowerCase()) {
                    case "start_time":
                        current.setStartTime(value);
                        break;
                    case "finish_time":
                        current.setFinishTime(value);
                        break;
                    case "project_code":
                        current.setProjectCode(Integer.parseInt(value));
                        break;
                    case "time":
                        times.add(current);
                        current = null;
                        break;
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            content.append(ch, start, length);
        }
    }
}
