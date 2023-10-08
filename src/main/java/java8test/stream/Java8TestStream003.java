package java8test.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8TestStream003 {
    public static void main(String[] args) {
        //Video No.17
        //Note: "Stream" need to add "<String>" or it cannot specify return object type in ".collect"
        Stream<String> stream1 = Stream.of("Test01","Test02","Test03");
        List<String> list1 = stream1.collect(Collectors.toCollection(ArrayList::new));
        list1.forEach(System.out::println);

        System.out.println("----------");
        //Set to TreeSet
        Stream<String> stream2 = Stream.of("cTest01","aTest02","bTest03");
        Set<String> set1 = stream2.collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Class Name:"+set1.getClass().getName());
        set1.forEach(System.out::println);//TreeSet's order is defaulted by alphabet order
        System.out.println("---------- Collectors.joining()");

        //Collectors Method: joining()  : combine string by order
        Stream<String> stream3 = Stream.of("XXXXX","AAAAA","EEEEEE");
        String str = stream3.collect(Collectors.joining());
        System.out.println(str);

        System.out.println("---------- Collectors.joining(\"\")");
        Stream<String> stream33 = Stream.of("XXXXX","AAAAA","EEEEEE");
        String str2 = stream33.collect(Collectors.joining("//n"));//delimiter 分隔符號
        System.out.println(str2);

        System.out.println("---------- map to uppercase");

        // How to do toUppercase all string?
        List<String> list = Arrays.asList("taipei","new york","berlin");
        list.stream().map(aa -> aa.toUpperCase()).forEach(System.out::println); //Stream's forEach
        System.out.println("---------- map to uppercase");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);//List's forEach
        System.out.println("----------Map to Int");

        //Map int
        List<Integer> listInt = Arrays.asList(1,2,3);
        listInt.stream().mapToInt(aa->aa*aa).forEach(System.out::println);
        System.out.println("----------Map to Int");
        listInt.stream().map(aa->aa*aa).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- flatMap() many lists into one list.");

        //Stream Method: flatMap()   many lists into one list.
        Stream<List<Integer>> streamFlat = Stream.of(Arrays.asList(1,2,3),Arrays.asList(9,10),Arrays.asList(66,77));
        //Turn ALL list into single stream. Then print them out.
        streamFlat.flatMap(mylist->mylist.stream()).map(it->it*it).forEach(System.out::println);
        System.out.println("---------- ");

        //Stream Method: generate()
        Stream<String> stream5 = Stream.generate(UUID.randomUUID()::toString);
        System.out.println(stream5.findFirst().get()); // Watch the warning
        System.out.println("---------- ");
        Stream<String> stream6 = Stream.generate(UUID.randomUUID()::toString);
        //Stream<String> stream6 = Stream.empty();
        stream6.findFirst().ifPresent(System.out::println); //Correct way to do it in Optional
        System.out.println("---------- iterate()");

        //Stream Method: iterate()
        System.out.println("---------- infinite");
        //Stream.iterate(1,x->x+1).forEach(System.out::println);
        System.out.println("---------- limit");

        Stream.iterate(1,x->x+1).limit(5).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");


    }
}
