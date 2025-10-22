package com.itideatask.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class JsonUtil {

    private static final Logger LOGGER = LogManager.getLogger(JsonUtil.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> readListFromJson (String path, Class<T> clazz) {
        try {
            return objectMapper.readValue(new File(path), objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void writeListToJson(String path, List<T> data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), data);
            LOGGER.info("Json file exported succesfully " + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
