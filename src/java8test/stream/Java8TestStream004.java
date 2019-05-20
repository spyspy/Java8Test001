package java8test.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8TestStream004 {
    public static void main(String[] args) {


        //Video: No.18
        //Problem: In stream object, finding elements > 2, and the elements multiplied by two
        //And discard first two elements, then pick up first two elements, finally, make the sum of last two elements.

        System.out.println("--------------- iterate()");
        Stream.iterate(1, x->x+2).limit(6).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("--------------- filter()");
        Stream<Integer> stream = Stream.iterate(1,x->x+2).limit(6);
        stream.filter(x->x>2).forEach(System.out::println);
        System.out.println("--------------- map()");
        Stream<Integer> stream2 = Stream.iterate(1,x->x+2).limit(6);
        stream2.filter(x->x>2).map(x->x*2).forEach(System.out::println);
        System.out.println("---------------mapToInt() for avoiding auto boxing/unboxing 自動裝箱與拆箱的避免");
        // mapToInt()   for avoiding auto boxing 自動裝箱與拆箱的避免   可以提高效率
        Stream<Integer> stream3 = Stream.iterate(1,x->x+2).limit(6);
        stream3.filter(x->x>2).mapToInt(x->x*2).forEach(System.out::println);

        System.out.println("--------------- skip(2) ignore first 2 elements");
        Stream<Integer> stream4 = Stream.iterate(1,x->x+2).limit(6);
        stream4.filter(x->x>2).mapToInt(x->x*2).skip(2).forEach(System.out::println);
        System.out.println("--------------- limit(2) pick up first two elements");
        Stream<Integer> stream5 = Stream.iterate(1,x->x+2).limit(6);
        stream5.filter(x->x>2).mapToInt(x->x*2).skip(2).limit(2).forEach(System.out::println);
        System.out.println("--------------- sum() sum up all elements");
        Stream<Integer> stream6 = Stream.iterate(1,x->x+2).limit(6);
        System.out.println(stream6.filter(x->x>2).mapToInt(x->x*2).skip(2).limit(2).sum());
        System.out.println("--------------- min() return Optional object");
        Stream<Integer> stream7 = Stream.iterate(1,x->x+2).limit(6);
        System.out.println(stream7.filter(x->x>2).mapToInt(x->x*2).skip(2).limit(1).min());
        //System.out.println(stream7.filter(x->x>2).mapToInt(x->x*2).skip(2).limit(0).min());
        //System.out.println(stream7.filter(x->x>2).mapToInt(x->x*2).skip(2).limit(2).max());

        //Exception
        //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        //Question: why max(), min() return Optional object? and sum() return int?
        //Because max(),min() could return empty result. and sum() can just return 0;

        System.out.println("--------------- min() return Optional object:CORRECT way to do Optional object");
        Stream<Integer> stream8 = Stream.iterate(1,x->x+2).limit(6);
        stream8.filter(x->x>2).mapToInt(x->x*2).skip(2).limit(2).min().ifPresent(System.out::println);
        System.out.println("--------------- IntSummaryStatistics ");
        //if we needd to have max,min, and sum? Use IntSummaryStatistics object
        Stream<Integer> stream9 = Stream.iterate(1,x->x+2).limit(6);

        IntSummaryStatistics iss = stream9.filter(x-> x>2).mapToInt(x->x*2).skip(2).limit(2).summaryStatistics();
        System.out.println("getAverage:"+iss.getAverage());
        System.out.println("getMax:"+iss.getMax());
        System.out.println("getMin:"+iss.getMin());
        System.out.println("getSum:"+iss.getSum());
        System.out.println("--------------- Exception of Stream 1");


        //Exception of Stream
        Stream<Integer> stream10 = Stream.iterate(1,x->x+2).limit(6);
        System.out.println(stream10);
        System.out.println(stream10.filter(x->x>3));
        //System.out.println(stream10.distinct());// Stream already be operated. Cannot operate it AGAIN!!!!
        //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed


        System.out.println("--------------- Exception of Stream 2");
        //This way could help us to see name of stream object
        Stream<Integer> stream11 = Stream.iterate(1,x->x+2).limit(6);
        System.out.println(stream11);
        Stream<Integer> stream12 = stream11.filter(x->x>3);
        System.out.println(stream12);
        Stream<Integer> stream13 = stream12.distinct();
        System.out.println(stream13);
        System.out.println("--------------- Exception of Stream End");


        System.out.println("--------------- First Capitalized word");
        List<String> liststr = Arrays.asList("apple","banana","coco","daemon");
        liststr.stream().map(x->x.substring(0,1).toUpperCase()+x.substring(1)).forEach(System.out::println);
        System.out.println("--------------- First Capitalized word 2");
        List<String> liststr2 = Arrays.asList("apple","banana","coco","daemon");
        liststr2.stream().map(x->{
            System.out.println("InnerTest !!!");
            return x.substring(0,1).toUpperCase()+x.substring(1);
        });
        //Result: no print. why? Becasue there is no terminal operation here.
        //        Intermediate operation will not really operate.
        System.out.println("--------------- ");
        //Following example: Got a terminal operation. So, "InnerTest" will show up.
        liststr2.stream().map(x->{
            System.out.println("InnerTest !!!");
            return x.substring(0,1).toUpperCase()+x.substring(1);
        }).forEach(System.out::println);
        System.out.println("---------------  Infinite stream: non stop");
        //IntStream.iterate(0,x->(x+1)%2).distinct().limit(5).forEach(System.out::println);
        System.out.println("---------------  Infinite stream: Solved!!!");
        IntStream.iterate(0,x->(x+1)%2).limit(5).distinct().forEach(System.out::println);
        System.out.println("---------------  ");
        System.out.println("--------------- 45465456465 AAASSSS");




    }
}
