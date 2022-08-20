package com.compile.testcompilerspring;

import com.compile.testcompilerspring.data.CallExtends;
import com.compile.testcompilerspring.data.SomeType;
import org.junit.jupiter.api.Test;
import org.junit.runners.JUnit4;
import org.junit.runners.model.InitializationError;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class testProcessing {

    @Test
    void testOptimization() {
        int sum = 6;
        assertEquals(6, sum);
    }
}
