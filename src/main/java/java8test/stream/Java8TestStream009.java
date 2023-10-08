package java8test.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Java8TestStream009 {
    public static void main(String[] args) {
        //Video No.27
        //Sort method
        List<String> list1 = Arrays.asList("appple","wowo","coco","EcoecoecoB1111");
        //list1.sort(Comparator.comparingInt(x->x.length())); //Same meaning
        list1.sort(Comparator.comparingInt(String::length)); //Same meaning

        System.out.println(list1);
        System.out.println("---------------");
        List<String> list2 = Arrays.asList("appple","wowo","coco","EcoecoecoB222");
        //list2.sort(Comparator.comparingInt(x->x.length()));
        Stream<String> aa = list2.stream().sorted(Comparator.comparingInt(x->x.length()));
        aa.forEach(System.out::println);

        System.out.println("---------------");

        List<String> list3 = Arrays.asList("appple","wowo","coco","EcoecoecoB3333");
        Collections.sort(list3,Comparator.comparingInt(String::length));
        System.out.println(list3);

        System.out.println("---------------");
        List<String> list4 = Arrays.asList("appple","wowo","coco","EcoecoecoB444");
        Collections.sort(list4,Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        System.out.println(list4);

    }
}
