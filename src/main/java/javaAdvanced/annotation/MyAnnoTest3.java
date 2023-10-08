package javaAdvanced.annotation;

// 自訂Annotation
// https://docs.oracle.com/javase/tutorial/java/annotations/basics.html
// 針對 Annotation 的 Annotation
// https://medium.com/@maskwork77.dev/java-%E8%A8%BB%E8%A7%A3-annotation-8da4850cc3ef
// @Retention  (決定生命週期，是否編譯，是否只要有JVM再跑就存在...)
// @Documented
// @Target
// @Inherited
//
public @interface MyAnnoTest3 {
    String value();
//    String gogo();
}
