package com.mapping.demo.utils;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import java.util.Base64;

@Log4j2
public class HelperUtils {

    public static String detokenize(String token) {
        if (StringUtils.isNotBlank(token)) {
            byte[] decodedBytes = Base64.getDecoder().decode(token);
            return new String(decodedBytes);
        }
        return StringUtils.EMPTY;
    }
}

