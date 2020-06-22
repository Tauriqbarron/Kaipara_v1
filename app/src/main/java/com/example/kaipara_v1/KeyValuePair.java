package com.example.kaipara_v1;

import java.io.Serializable;

public class KeyValuePair implements Serializable {
    private String key;
    private String value;
    public KeyValuePair(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
