package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Properties_Reader {

    static Properties properties;
        //read data.properties
        public static String readKey(String propertyName) {
            properties = new Properties();

            try {
                String filename = System.getProperty("user.dir") + "/src/main/resources/data.properties";
                properties.load(new FileInputStream(filename));
            } catch (IOException e) {
                throw new RuntimeException("Not able to find file");
            }
            return properties.getProperty(propertyName);
        }
    }




