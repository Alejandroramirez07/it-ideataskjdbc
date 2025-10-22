package com.itideatask.util;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;

public class JsonValidator {

    public static boolean validate(String jsonFile, String schemaFile) {

        try (FileInputStream jsonStream = new FileInputStream(jsonFile);
             FileInputStream schemaStream = new FileInputStream(schemaFile)) {

            JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaStream));
            Object jsonData = new JSONTokener(jsonStream).nextValue();

            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonData);
            System.out.println(" JSON is valid!");
            return true;

        } catch (Exception e) {
            System.err.println(" JSON invalid: " + e.getMessage());
            return false;
        }
    }
}
