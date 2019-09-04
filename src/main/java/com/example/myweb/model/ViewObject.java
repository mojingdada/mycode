package com.example.myweb.model;

import java.util.HashMap;
import java.util.Map;

public class ViewObject {
    private Map<String, Object> objs = new HashMap<>();


    public void set(String key, Object value) {
        objs.put(key, value);
    }

    public Object get(Object key) {
        return objs.get(key);
    }


}
