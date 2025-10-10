package com.itideatask.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XmlValidator {
    private static final Logger LOGGER = LogManager.getLogger(XmlValidator.class);
    public static boolean validateXmlAgainstXsd(String xmlPath, String xsdPath){
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdPath));
            Validator validator=schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            LOGGER.info("XML is valid");
            return true;
        } catch (Exception e) {
            LOGGER.error("XML invalid " + e.getMessage());
            return false;
        }
    }
}
