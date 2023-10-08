package javaAdvanced.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestAnnotation extends AnnoParent{

    @MyAnnoTest1(name = "", date = "")
    public String name;

    public static void main(String[] args) {
        System.out.println(new TestAnnotation().getName());

        myFuntion1();

        for(Field a :new TestAnnotation().getClass().getFields()){
            System.out.println(a.getAnnotations());
            for(Annotation obj:a.getAnnotations()){
                System.out.println("test");
                System.out.println(obj);
            }
        }

    }

    public String getName(){
        return "No Name";
    }

    // Annotation 可以包含 element(以下的name, date)  可以有名稱  或是沒有名稱
    @MyAnnoTest1(name="1",date="2023/10/08")
    private static void myFuntion1(){
        System.out.println("myFuntion1");
    }

    @MyAnnoTest2("WOW") // 如果有 value() 就可以免去 element名稱  value="abc"
    private static void myFuntion2(){
        System.out.println("myFuntion1");
    }

}
