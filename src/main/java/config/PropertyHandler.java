package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class PropertyHandler {
    Properties properties;
    FileInputStream fileInputStream;
    public PropertyHandler(String fileName) throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/resources/";
         fileInputStream=new FileInputStream(path+fileName);
         properties=new Properties();
        properties.load(fileInputStream);


    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void tearDown() throws IOException {
        fileInputStream.close();
    }




}
