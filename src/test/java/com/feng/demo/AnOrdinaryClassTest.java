package com.feng.demo;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnOrdinaryClassTest {

    // AnOrdinaryClass的MockUp类，继承MockUp即可
    public static class AnOrdinaryClassMockUp extends MockUp<AnOrdinaryClass> {
        // Mock静态方法
        @Mock
        public static int staticMethod() {
            return 10;
        }

        // Mock普通方法
        @Mock
        public int ordinaryMethod() {
            return 20;
        }

        @Mock
        // Mock final方法
        public final int finalMethod() {
            return 30;
        }

        // Mock native方法
        @Mock
        public int navtiveMethod() {
            return 40;
        }

        // Mock private方法
        @Mock
        private int privateMethod() {
            return 50;
        }
    }

    @Test
    public void testClassMockingByMockUp() {
        new AnOrdinaryClassMockUp();
        AnOrdinaryClass instance = new AnOrdinaryClass();
        // 静态方法被mock了
        Assertions.assertTrue(AnOrdinaryClass.staticMethod() == 10);
        // 普通方法被mock了
        Assertions.assertTrue(instance.ordinaryMethod() == 20);
        // final方法被mock了
        Assertions.assertTrue(instance.finalMethod() == 30);
        // native方法被mock了
        Assertions.assertTrue(instance.navtiveMethod() == 40);
        // private方法被mock了
        Assertions.assertTrue(instance.callPrivateMethod() == 50);
    }

    @Test
    public void testClassMockingByExpectation() {
        AnOrdinaryClass instanceToRecord = new AnOrdinaryClass();
        new Expectations(instanceToRecord) {
            {
                // mock静态方法
                AnOrdinaryClass.staticMethod();
                result = 10;
                // mock普通方法
                instanceToRecord.navtiveMethod();
                result = 20;
                // mock final方法
                instanceToRecord.finalMethod();
                result = 30;
                // native, private方法无法用Expectations来Mock
            }
        };
        AnOrdinaryClass instance = new AnOrdinaryClass();
        Assertions.assertTrue(AnOrdinaryClass.staticMethod() == 10);
        Assertions.assertTrue(instance.navtiveMethod() == 4);
        Assertions.assertTrue(instance.finalMethod() == 30);
        //Assertions.assertTrue(instance.ordinaryMethod() == 20);
        // 用Expectations无法mock native方法
        // 用Expectations无法mock private方法
        //Assertions.assertTrue(instance.callPrivateMethod() == 5);
    }
}