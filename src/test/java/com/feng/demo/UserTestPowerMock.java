//package com.feng.demo;
//
//
//import org.mockito.Mock;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.testng.PowerMockTestCase;
//import org.powermock.reflect.Whitebox;
//import org.testng.annotations.Test;
//
//import java.lang.reflect.Method;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.ArgumentMatchers.argThat;
//
//@PrepareForTest(User.class)
//public class UserTestPowerMock extends PowerMockTestCase {
//
//    @Mock
//    private User user;
//
//    @Test
//    public void testTestGetResult() {
//        PowerMockito.when(user.getResult(anyString())).thenReturn("powerMock");
//        String result = user.getResult("tom");
//        assertThat(result).isEqualTo("powerMock");
//    }
//
//    @Test
//    public void testGetFinalName() {
//        PowerMockito.when(user.getFinalName(argThat(s -> true))).thenReturn("powerMock");
//        String result = user.getFinalName("tom");
//        assertThat(result).isEqualTo("powerMock");
//    }
//
//    @Test
//    public void testGetStaticName() {
//        PowerMockito.mockStatic(User.class);
//        PowerMockito.when(User.getStaticName(argThat(s -> true))).thenReturn("powerMock");
//        String result = User.getStaticName("tom");
//        assertThat(result).isEqualTo("powerMock");
//    }
//
//    @Test
//    public void testGetPrivateName() throws Exception {
//        PowerMockito.when(user, "getPrivateName", anyString()).thenReturn("powerMock");
//        Method method = PowerMockito.method(User.class, "getPrivateName", String.class);
//        Object result = method.invoke(user, "12");
//        assertThat(result).isEqualTo("powerMock");
//
//        Object say = Whitebox.invokeMethod(user, "getPrivateName", "12");
//        assertThat(result).isEqualTo("powerMock");
//    }
//}