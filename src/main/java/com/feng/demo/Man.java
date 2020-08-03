package com.feng.demo;

public class Man {

    private static String name;
    private static Man man = new Man();
    private String addr;

    static {
        name = "man";
    }

    {
        name = "all";
        addr = "xxx";
    }

    public Man(){
        System.out.println("-----------------");
    }

    public Man(String addr) {
        this.addr = addr;
    }

    public static void main(String[] args) {
        Man man = new Man("HK");
        Man man1 = new Man("HK");
    }
}
