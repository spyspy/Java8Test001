package java8test.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Java8TestStream002 {
    public static void main(String[] args) {
        //Stream ==> String Array ==>List
        Stream<String> stream = Stream.of("Test1","Test2","Test3","Test4");
        //Change Stream to String Array
        //toArray method
        //IntFunction
        String[] strArray = stream.toArray(lena->{
            System.out.println("len:"+lena);
            return new String[lena];
        });
        System.out.println("---------------");
        //Change String Array to List object
        Arrays.asList(strArray).forEach(System.out::println);
        System.out.println("================");
        Stream<String> stream2 = Stream.of("Test1","Test2","Test3","Test4");
        String[] strArray2 = stream2.toArray(String[]::new);
        Arrays.asList(strArray2).forEach(System.out::println);
        System.out.println("================");

        //From stream to list
        Stream<String> stream3 = Stream.of("aTest1","aTest2","aTest3","aTest4");
        String[] strArray3 = stream3.toArray(String[]::new);
        Arrays.asList(strArray3).forEach(System.out::println);
        System.out.println("================");


    }
}
