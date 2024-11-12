package org.example;

import org.example.ThreadLocal.ThreadLocalExample;

public class Main {

    public static void main(String[] args) {
        // 不使用threadLocal
        ThreadLocalExample.noUseThreadLocal();
        // 使用threadLocal
        ThreadLocalExample.useThreadLocal();
    }
}