package com.challenge.PizzaParlor.utils;

import org.springframework.web.multipart.MultipartFile;

public class UtilsClass {

    public static final String TYPE = "text/csv";
    public static final String EMPTY = "";

    public static boolean hasCSVFormat(MultipartFile file) {
        return (TYPE.equals(file.getContentType()));
    }

}
