package ar.com.fn.utils;

import java.util.UUID;

public class IdGenerator {

    public static final String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
