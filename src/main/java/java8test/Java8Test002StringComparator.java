package java8test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Test002StringComparator {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("cname","baby","apple","xman");

        //java8 ep6
        //OLD way to be ordered
        Collections.sort(names,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //return o2.compareTo(o1);// anti-order
                return o1.compareTo(o2);// order
            }
        });
        System.out.println(names);

        //Use Lambda
        Collections.sort(names,(String o1,String o2) -> {return o2.compareTo(o1);});
        System.out.println(names);

        //Type can to 省略
        Collections.sort(names,(o1,o2) -> {return o1.compareTo(o2);});
        Collections.sort(names,(o1,o2) -> o1.compareTo(o2));

        System.out.println(names);


    }
}
