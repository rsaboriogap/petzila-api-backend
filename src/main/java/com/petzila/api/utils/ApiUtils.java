package com.petzila.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by vicente on 16/01/15.
 */
public class ApiUtils {
    public static String getError(String code) {
        try {
            InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("errors.properties");
            Properties properties = new Properties();
            properties.load(stream);
            return properties.getProperty(code);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
