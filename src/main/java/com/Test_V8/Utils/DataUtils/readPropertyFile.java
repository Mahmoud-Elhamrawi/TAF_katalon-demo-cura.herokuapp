package com.Test_V8.Utils.DataUtils;

import com.Test_V8.Utils.LogUtil.LogUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

public class readPropertyFile {


    public static String propertyPath = "src/main/resources/";

    //load property file
    public static Properties loadProperties() {
        try {
            Properties properties = new Properties();
            Collection<File> collectionFile;
            collectionFile = FileUtils.listFiles(new File(propertyPath), new String[]{"properties"}, true);

            collectionFile.forEach(properties1 ->
            {
                try {
                    properties.load(new FileInputStream(properties1));
                    properties.putAll(System.getProperties());
                    System.getProperties().putAll(properties);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            });


            return properties;
        } catch (Exception e) {
            LogUtils.error("fail to load properties files", e.getMessage());
            return null;
        }
    }


    // get property name
    public static String getPropertyName(String propertyName) {
        try {
            return System.getProperty(propertyName);
        } catch (Exception e) {
            LogUtils.error("failed to get property name", e.getMessage());
            return null;
        }

    }


}
