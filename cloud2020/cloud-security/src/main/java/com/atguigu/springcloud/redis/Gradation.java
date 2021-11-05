package com.atguigu.springcloud.redis;

public enum Gradation {


    INCR("递增"),
    DECR("递减");

    private String name;

    public String getName() {
        return name;
    }

    Gradation(String name) {
        this.name = name;
    }
}
