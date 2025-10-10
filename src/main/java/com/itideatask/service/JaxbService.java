package com.itideatask.service;

import com.itideatask.model.JavaProjects;
import com.itideatask.util.JaxbParserUtil;
import com.itideatask.util.XmlValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class JaxbService {
    private static final Logger LOGGER = LogManager.getLogger(JavaProjects.class);

    public JavaProjects getJavaProjectsFromXml(String xmlPath, String xsdPath){
        boolean valid = XmlValidator.validateXmlAgainstXsd(xmlPath, xsdPath);
        if (!valid) {
            LOGGER.info("XML is invalid. Parsing aborted");
            return null;
        }
        return JaxbParserUtil.parseJavaProjects(xmlPath);
    }

    public void exportJavaProjectsToXml(JavaProjects projects) {
        JaxbExporter.exportToXml(projects, "src/main/resources/xml/exported_projects.xml");
    }

}
