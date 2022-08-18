package com.compile.testcompilerspring.procesing;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReaderCSV_CallTouchTest {

    @Test
    void testFill(){
//        ReaderCSV_CallTouch.readFile();
        try {
            ReaderCSV_CallTouch.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}