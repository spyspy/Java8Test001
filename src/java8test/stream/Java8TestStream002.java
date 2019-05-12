package java8test.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Java8TestStream002 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Test1","Test2","Test3","Test4");
        //Change Stream to Array
        //toArray method
        //IntFunction
        String[] strArray = stream.toArray(len->{
            System.out.println("len:"+len);
            return new String[len];
        });
        Arrays.asList(strArray).forEach(System.out::println);
    }
}
