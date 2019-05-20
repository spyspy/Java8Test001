package java8test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Java8TestStream005 {
    public static void main(String[] args) {
        //Video No.19
        //Video No.20
        //串行流 vs 併行流
        //UUID
        System.out.println("Start: Inputs");
        long startimea = System.currentTimeMillis();
        List<String> list = new ArrayList<>(500000);
        for (int i = 0;i<500000;++i){
            list.add(UUID.randomUUID().toString());
        }
        long endtimea = System.currentTimeMillis();
        System.out.println("Enda Time Pass(MS):"+(endtimea-startimea));
        System.out.println("---------------");
        System.out.println("Start: Sorted(Order By)");
        long startTime = System.nanoTime();

        //串行流 一個 thread
        //list.stream().sorted().count();  //Time(MS): 10739

        //併行流 parallelStream 多個 thread  依據CPU效能產生差異(多核)
        list.parallelStream().sorted().count(); //Time(MS): 5621

        long endTime = System.nanoTime();
        long sortedTime = TimeUnit.NANOSECONDS.toMillis(endTime-startTime);

        System.out.println("Sorted Time Pass(MS):"+(sortedTime));

        System.out.println("---------------");
        List<String> list2 = Arrays.asList("hello","kitty","hihiwowowo");
        list2.stream().filter(x->x.length()==5).forEach(System.out::println);

        System.out.println("---------------");

        List<String> list3 = Arrays.asList("helle","kittia","hihiwowowo");
        list3.stream().map(x->x.length()).filter(x->x==5).findFirst().ifPresent(System.out::println);

        System.out.println("---------------");
        list3.stream().mapToInt(x->x.length()).filter(x->x==5).findFirst().ifPresent(System.out::println);
        System.out.println("---------------");
        list3.stream().mapToInt(x->{
            System.out.println("TestBox");
            return x.length();}
        ).filter(x->x==6).findFirst().ifPresent(System.out::println);




    }
}
