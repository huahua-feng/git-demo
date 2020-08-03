package com.feng.demo;

import java.util.LinkedList;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        list.stream().forEach((s)->{list.remove(s);});
        System.out.println(list);
    }
}
