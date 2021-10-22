package com.blog.api.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String IMAGE_PATTERN =
            "([^\\s]+(\\.(?i)(jpg|png))$)";

    public ImageValidator(){
        pattern = Pattern.compile(IMAGE_PATTERN);
    }

    /**
     * Validate image with regular expression
     * @param image recibe imagen a validar
     * @return true si valida imagen, false no es una imagen
     */
    public boolean validate(final String image){

        matcher = pattern.matcher(image);
        return matcher.matches();

    }
}
