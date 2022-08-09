package com.compile.testcompilerspring.data;

public class TestClass {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        TestClass val;

        private Builder() {
            this.val = new TestClass();
        }

        public Builder id(Integer id){
            val.id = id;
            return this;
        }

        public TestClass build(){
            return val;
        }
    }

}


