package com.itideatask.util;

import com.itideatask.model.JavaProjects;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;


import java.io.File;

public class JaxbParserUtil {

    public static JavaProjects parseJavaProjects(String xmlPath){
        try {
            JAXBContext jaxbContext= JAXBContext.newInstance(JavaProjects.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (JavaProjects) unmarshaller.unmarshal(new File(xmlPath));
        }catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
