package javaAdvanced.annotation;

// 自訂Annotation
// https://docs.oracle.com/javase/tutorial/java/annotations/basics.html

public @interface MyAnnoTest1 {
    String name();
    String date();
    // 使用 default 設定預設值
    int age() default 999;
}
