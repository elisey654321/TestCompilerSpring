package com.compile.testcompilerspring;

import org.junit.jupiter.api.Test;

public class testProcessing {

    @Test
    void testOptimization(){
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Integer[] integers = new Integer[1024*1024];
        }
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(Integer.MAX_VALUE);
    }
}
