package ar.com.fn.domain.utils;

import java.util.UUID;

public class IdGenerator {

    public static final String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
