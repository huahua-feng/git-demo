package com.feng.demo.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class compare {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setAge(11);
        User user2 = new User();
        user2.setAge(22);

        users.add(user1);
        users.add(user2);
//        Collections.sort(users);
        Collections.sort(users, new MyCompare());
        System.out.println(users);
    }

    private static class MyCompare implements Comparator<User> {

        @Override
        public int compare(User o1, User o2) {
            return o2.getAge() - o1.getAge();
        }
    }

}
