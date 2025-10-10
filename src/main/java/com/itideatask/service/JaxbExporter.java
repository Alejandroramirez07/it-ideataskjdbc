package com.itideatask.service;

import com.itideatask.model.JavaProjects;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.File;

public class JaxbExporter {

    public static void exportToXml(JavaProjects projects, String outputPath) {
        try {
            JAXBContext context = JAXBContext.newInstance(JavaProjects.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(projects, new File(outputPath));
            System.out.println(" XML file created at: " + outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

