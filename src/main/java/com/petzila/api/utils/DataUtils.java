package com.petzila.api.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vicente on 16/01/15.
 */
public class DataUtils {
    public static Map<String, String> supportedTypes ;

    static
    {
        supportedTypes = new HashMap<String, String>();
        supportedTypes.put("audio/mp4", ".mp4");
        supportedTypes.put("audio/mpeg", ".mpeg");
        supportedTypes.put("audio/vnd.wave", ".wav");
        supportedTypes.put("audio/webm", ".webm");
        supportedTypes.put("image/gif", ".gif");
        supportedTypes.put("image/jpeg", ".jpeg");
        supportedTypes.put("image/png", ".png");
        supportedTypes.put("video/avi", ".avi");
        supportedTypes.put("video/mpeg", ".mpeg");
        supportedTypes.put("video/mp4", ".mp4");
        supportedTypes.put("video/webm", ".webm");
        supportedTypes.put("video/x-flv", ".flv");
        supportedTypes.put("video/x-ms-wmv", ".wmv");
    }
}
