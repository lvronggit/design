package com.lvrong.performance;

import org.junit.Test;

public class StringInternet {

    @Test
    public void eq() {
        //代码中使用第一种方式创建字符串对象时，
        // JVM 首先会检查该对象是否在字符串常量池中，
        // 如果在，就返回该对象引用，否则新的字符串将在常量池中被创建。
        // 这种方式可以减少同一个值的字符串对象的重复创建，节约内存
        String str1 = "abc";
        //String str = new String(“abc”) 这种方式，首先在编译类文件时，
        // "abc"常量字符串将会放入到常量结构中，在类加载时，“abc"将会在常量池中创建；
        // 其次，在调用 new 时，JVM 命令将会调用 String 的构造函数，
        // 同时引用常量池中的"abc” 字符串，在堆内存中创建一个 String 对象；最后，str 将引用 String 对象
        String str2 = new String("abc");
        String str3 = str2.intern();
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str1 == str3);

    }

}