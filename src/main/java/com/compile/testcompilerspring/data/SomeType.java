package com.compile.testcompilerspring.data;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Optional;

@Configuration
public class SomeType<T extends Call> {
    ArrayList<T> eeee = null;

    public SomeType() {
        eeee = Optional.ofNullable(eeee).orElse(new ArrayList<>());
        eeee.add((T) new CallExtends());

        for (T callExtends:eeee) {
            System.out.println(callExtends.getId());
        }

    }
}
