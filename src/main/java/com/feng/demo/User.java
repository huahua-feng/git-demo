package com.feng.demo;

public class User {

    private String name;

    private SendMailService sendMailService;

    public String getResult(String test){
        return test + "\tjunit";
    }

    private String getPrivateName(String test){
        return "123";
    }

    public final String getFinalName(String str) {
        return "1235" + str;
    }

    public static String getStaticName(String string) {
        return "12356" + string;
    }

    public String send(String str){
        return str + sendMailService.sendmail();
    }
}
