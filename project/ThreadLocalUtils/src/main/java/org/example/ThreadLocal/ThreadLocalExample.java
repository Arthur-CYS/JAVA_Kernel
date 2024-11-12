package org.example.ThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalExample {

    /**
     * 类变量（静态变量）
     * 全局可见，仅存储一份在方法区（栈）中，所以为共享变量
     */
    private static Map<String, String> commonVariable = new HashMap<>();

    // threadLocal —— 类变量
    private static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();

    static {
        System.out.println(commonVariable);
    }

    public static void noUseThreadLocal() {

        // 线程修改共享变量
        new Thread(() -> {
            commonVariable.put("a", "c");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + commonVariable.get("a"));
            System.out.println(Thread.currentThread().getName() + commonVariable.get("b"));
        }).start();

        new Thread(() -> {
            commonVariable.put("b", "d");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + commonVariable.get("a"));
            System.out.println(Thread.currentThread().getName() + commonVariable.get("b"));
        }).start();
    }

    public static void useThreadLocal() {
        // threadLocal
        new Thread(() -> {
            Map<String, String> map1 = new HashMap<>();
            map1.put("a", "e");
            threadLocal.set(map1);
            System.out.println(Thread.currentThread().getName() + threadLocal.get());
            Map<String, String> map2 = new HashMap<>();
            map2.put("f", "g");
            threadLocal.set(map2);
            System.out.println(Thread.currentThread().getName() + threadLocal.get());
        }).start();

        new Thread(() -> {
            Map<String, String> map1 = new HashMap<>();
            map1.put("g", "h");
            threadLocal.set(map1);
            System.out.println(Thread.currentThread().getName() + threadLocal.get());
            Map<String, String> map2 = new HashMap<>();
            map2.put("m", "n");
            threadLocal.set(map2);
            System.out.println(Thread.currentThread().getName() + threadLocal.get());
        }).start();
    }

}
