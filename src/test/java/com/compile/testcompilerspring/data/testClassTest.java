package com.compile.testcompilerspring.data;

import org.junit.jupiter.api.Test;

class TestClassTest {

    @Test
    void checkClass(){
        TestClass tc = TestClass.builder().id(5).build();
        System.out.println(tc.getId());
    }

}