package com.feng.demo;

import mockit.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static mockit.internal.reflection.MethodReflection.invoke;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AopServiceTest {

    @Capturing
    AopService aopService;

    @Test
    void doAop() {
        new Expectations(){{
            aopService.doAop(anyString);
            result = "aopMock";
        }};
        assertThat(aopService.doAop("sss")).isEqualTo("aopMock");
    }

    @Test
    void doAop2() {
        User user = new User();
        new Expectations(User.class){{
            user.getResult("111");
            result = "333";
        }};
        assertThat(user.getResult("111")).isEqualTo("333");
    }

    public static class MockUser extends MockUp<User> {

        @Mock
        private String getPrivateName(String test){
            return "123";
        }
    }
    @Test
    void doPrivate(@Mocked User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //User user = new User();
        new MockUser();

        Method method = User.class.getDeclaredMethod("getPrivateName", String.class);
        method.setAccessible(true);
        assertThat(method.invoke(user, "111")).isEqualTo("333");
    }

    @Test
    void doAopMockUp() {
        User user = new User();
        new MockUp<User>(User.class){
            @Mock
            public String getResult(String test){
                return "mock";
            }
        };
        assertThat(user.getResult("111")).isEqualTo("mock");

        new Verifications(){
            {
                user.getResult("111");
                times = 1;
            }
        };
    }

    @Test
    void doAop3() {
        ArrayList<String> list = new ArrayList<>();
        new Expectations(list){{
            list.size();
            result = 333;
        }};
        assertThat(list.size()).isEqualTo(333);
    }
}