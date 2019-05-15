package java8test.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8TestStream001 {
    public static void main(String[] args) {
        //Stream
        //three parts:
        //1. origin
        //2. intermediate operation
        //3. terminal operation

        //classification of Stream operation
        //1. lazy value  eg: operate on number,string...etc
        //2. early value
        //   eg: stream().aaa().bbb().ccc().count();
        //                ^^^^^^intermediate  ^^^^^^^ terminal operation
        //Once you do terminal operation, the intermediate operation will be done.

        //1
        Stream stream1 = Stream.of("Test1","Test2","Test3","Test4");
        //2
        String [] myArr = new String[]{"t1","t2","t3","t4"};
        Stream stream2 = Stream.of(myArr);
        Stream stream3 = Arrays.stream(myArr);

        //Most way to make stream
        List<String> list  = Arrays.asList(myArr);
        Stream stream4 = list.stream();

        //===================================================
        //IntStream is a specialization of stream for integer;
        IntStream.of(new int[]{5,6,7,8}).forEach(System.out::println);
        System.out.println("-------------range(3,6)");
        IntStream.range(3,6).forEach(System.out::println);
        System.out.println("-------------rangeClosed(3,6)");
        IntStream.rangeClosed(3,6).forEach(System.out::println);
        System.out.println("-------------Traditional way");

        //List<Integer>   all multiply 2, and finally add to sum.
        //Traditional way
        List<Integer> listInt = Arrays.asList(1,2,3,4);
        int sum = 0;
        for(Integer i : listInt){
            sum += 2*i;
        }
        System.out.println("sum:"+sum);//20
        //Stream way
        System.out.println("-------------Stream()");
        List<Integer> listIn = Arrays.asList(1,2,3,4,5,6);
        System.out.println("sum:"+listIn.stream().map(i->i*2).reduce(0,Integer::sum));

        System.out.println("-------------Filter");
        System.out.println("test:"+listIn.stream().filter(myin -> myin>4).reduce(0,Integer::sum));
        System.out.println("-------------New Collections... List");
        System.out.println("test:"+listIn.stream().filter(myin -> myin>4).collect(Collectors.toList()));

    }
}
