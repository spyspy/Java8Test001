package java8test;

import java.util.Arrays;
import java.util.List;

public class Java8Test007MethodRef {
    public static void main(String[] args) {
        //方法引用  Method Reference
        List<String> listString = Arrays.asList("Test1","Test2","Test3");

        //forEach
        listString.forEach((str)-> System.out.println(str));
        System.out.println("***********************************");
        //method reference
        listString.forEach(System.out::println);
        System.out.println("***********************************");


    }
}
