package com.larscheng.www.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class KeyGenerator {

    private volatile static SecretKey key;

    private KeyGenerator() {
    }

    public static SecretKey getKey() {
        if (key == null) {
            synchronized (KeyGenerator.class) {
                if (key == null) {
                    key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
                }
            }
        }
        return key;
    }
}
