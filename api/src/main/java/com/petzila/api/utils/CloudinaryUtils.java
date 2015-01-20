package com.petzila.api.utils;

import com.cloudinary.Cloudinary;

import javax.inject.Named;
import java.io.IOException;
import java.util.Map;

/**
 * Created by vicente on 16/01/15.
 */
@Named
public class CloudinaryUtils {

    private Cloudinary cloudinary = new Cloudinary(Cloudinary.asMap(
            "cloud_name", "123",//NOT UPLOAD VALID CREDENTIALS AS IS A PUBLIC GITHUB REPOSITORY
            "api_key", "123",
            "api_secret", "123"));


    public Map uploadImage(byte[] imageData) throws IOException {
        return cloudinary.uploader().upload(imageData, Cloudinary.emptyMap());
    }

    public Map uploadImage(String imageData) throws IOException {
        try {
            return cloudinary.uploader().upload(imageData, Cloudinary.emptyMap());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }
}
