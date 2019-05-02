package java8test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Java8Test001 {
    public static void main(String[] args) {

        //Lambda Expression.
        List<Integer> myList = Arrays.asList(1,2,5,8,99);
        for(Integer a:myList) {
            System.out.println(a);
        }
        //Internal iterator vs External iterator.
        myList.forEach(a->System.out.println(a));

        List<String> myList2 = Arrays.asList("test one","hello two","koko three");

        //Normal Lambda for instance
        myList2.stream().map(item -> item.toUpperCase()).forEach(item->System.out.println(item));
        //Lambda by method reference for instance.
        //note: there are two ways to use method reference in this case.
        myList2.stream().map(String::toUpperCase).forEach(System.out::println);

        //Function Class
        Function<String,String> myfun = String::toUpperCase;// class(類) :: isntance method(實例方法)
        System.out.println(myfun.getClass().getInterfaces()[0]);

        //There are 4 ways to use method reference;


    }
}
