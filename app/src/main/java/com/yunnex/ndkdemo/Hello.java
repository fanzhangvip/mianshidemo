package com.yunnex.ndkdemo;

/**
 * Created by zero on 2018/7/19.
 */

public class Hello {

    static {
        //三种加载so库的方式
        System.loadLibrary("hello-lib");
//        用这种方式加载so库和System.loadLibrary函数加载so库的效果是一样的
//        Runtime.getRuntime().loadLibrary("hello-lib");
//        用这种方式加载so库需要指定完整的so库路径
//        Runtime.getRuntime().load("libFilePath");
    }

    public static native String sayHello(String msg, int cout);

    public static native void callStaticVoidMethod();


    public static native void testJString(String str);
}
