package com.feng.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IteratorTest2 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("111", "111");
        map.put("222", "222");
        map.put("333", "333");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ("222".equals(entry.getKey())) {
                map.remove("222");
            }
        }
        System.out.println(map);
    }
}
