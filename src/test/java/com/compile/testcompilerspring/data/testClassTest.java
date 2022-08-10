package com.compile.testcompilerspring.data;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

class TestClassTest {

//    @Test
//    void checkClass (){
//        Optional<TestClass> testClass = Optional.of(TestClass.builder().id(5).build());
//
//        testClass.orElseThrow(() -> {
//            new NoSuchElementException(
//                    "Book is not found"
//            );
//            return null;
//        });
//
//        TestClass tc = TestClass.builder().id(5).build();
//        System.out.println(tc.getId());
//    }

    @Test
    void optionalTest(){
        Optional<String> optionalS = Optional.of("test");
        optionalS.orElse(orElse());
        System.out.println(optionalS.get());
    }

    String orElse(){
        System.out.println("no no no no");
        return "test1";
    }

}