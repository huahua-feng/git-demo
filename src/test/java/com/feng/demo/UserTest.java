package com.feng.demo;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Tested
    private User user1;

    @Test
    void send(@Injectable SendMailService sendMailService) {
        new Expectations(){
            {
                sendMailService.sendmail();
                result = "ooo";
            }
        };
        assertThat(user1.send("user")).isEqualTo("userooo");
    }

    @Test
    void mocked(@Injectable User user){
        assertThat(user.getFinalName("sss")).isNull();
        assertThat(user.getResult("sss")).isNull();
        assertThat(User.getStaticName("sss")).isNotNull();
        assertThat(new User().getFinalName("sss")).isNotNull();
    }

    @Test
    void getResult() {
        new Expectations(){
            {
                user1.getFinalName(anyString);
                result = "mock";

                user1.getResult(anyString);
                result = "mock0";

                User.getStaticName(anyString);
                result = "mock1";

                new User().getFinalName(anyString);
                result = "mock2";
            }
        };
        assertThat(user1.getFinalName("sss")).isEqualTo("mock");
        assertThat(user1.getResult("sss")).isEqualTo("mock0");
        assertThat(User.getStaticName("sss")).isNotEqualTo("mock1");
        assertThat(new User().getFinalName("sss")).isNotEqualTo("mock2");
    }

    @Test
    void getFinalName() {
    }

    @Test
    void getStaticName() {
    }

}