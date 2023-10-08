package java8test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8TestStream002 {
    public static void main(String[] args) {
        //Video No.16
        //Stream ==> String Array ==>List
        Stream<String> stream = Stream.of("Test1","Test2","Test3","Test4");
        //Change Stream to String Array
        //toArray method
        //IntFunction
        //Why???  the parameter is length??????
        String[] strArray = stream.toArray(lena->{
            System.out.println("len:"+lena);
            return new String[lena];
        });
        System.out.println("---------------");
        //Change String Array to List object
        //Use method reference
        Arrays.asList(strArray).forEach(System.out::println);
        System.out.println("================");

        //From stream to list
        //Use method reference
        Stream<String> stream2 = Stream.of("Test1","Test2","Test3","Test4");
        String[] strArray2 = stream2.toArray(String[]::new);
        Arrays.asList(strArray2).forEach(System.out::println);
        System.out.println("================");

        //From stream to list
        //Use method reference
        Stream<String> stream3 = Stream.of("aTest1","aTest2","aTest3","aTest4");
        String[] strArray3 = stream3.toArray(String[]::new);//method reference:constructor
        Arrays.asList(strArray3).forEach(System.out::println);
        System.out.println("================");

        //Use Collect
        Stream<String> stream4 = Stream.of("bTest1","bTest2","bTest3","bTest4");
        List<String> list4 = stream4.collect(Collectors.toList());
        list4.forEach(System.out::println);

        System.out.println("================");

        //Collect method: second way to use
        Stream<String> stream5 = Stream.of("cTest1","cTest2","cTest3","cTest4");
        List<String> list5 = stream5.collect(()->new ArrayList(),
                (theList,item) -> theList.add(item),
                (theList1,theList2)->theList1.addAll(theList2));//why add?  why addAll?

        list5.forEach(System.out::println);

        System.out.println("================");

        //Collect method: second way to use
        Stream<String> stream6 = Stream.of("cTest1","cTest2","cTest3","cTest4");
        List<String> list6 = stream6.collect(LinkedList::new,LinkedList::add,LinkedList::addAll);
        list6.forEach(System.out::println);
        System.out.println("================");


    }
}
