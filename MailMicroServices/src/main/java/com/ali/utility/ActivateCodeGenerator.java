package com.ali.utility;

import java.util.UUID;

public class ActivateCodeGenerator {

    public static String generateCode() {
        String code = UUID.randomUUID().toString();
        return code;
    }
}
