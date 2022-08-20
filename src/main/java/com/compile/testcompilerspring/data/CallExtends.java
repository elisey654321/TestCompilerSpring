package com.compile.testcompilerspring.data;

import java.lang.String;

public class CallExtends extends Call {

    private String id;

    public CallExtends() {
        this.id = "12";
        super.setId("1232");
    }
    @Override
    public String getId(){
        return this.id;
    }

}
