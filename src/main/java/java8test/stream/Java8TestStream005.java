package java8test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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


        //The Short circuit of Stream
        System.out.println("--------------- print length = 5");
        List<String> list2 = Arrays.asList("hello","kitty","hihiwowowo");
        list2.stream().filter(x->x.length()==5).forEach(System.out::println);

        System.out.println("--------------- map print the length");

        List<String> list3 = Arrays.asList("helle","kittia","hihiwowowo");
        list3.stream().map(x->x.length()).filter(x->x==5).findFirst().ifPresent(System.out::println);

        System.out.println("--------------- mapToInt : to avoid auto boxing and unboxing. ");
        list3.stream().mapToInt(x->x.length()).filter(x->x==5).findFirst().ifPresent(System.out::println);

        System.out.println("--------------- Short circuit of stream: how many time print in lambda?");

        //短路實例
        list3.stream().mapToInt(x->{
            System.out.println("Inside Lambda...."+x);
            return x.length();}
        ).filter(x->x==6).findFirst().ifPresent(System.out::println);//print number

        //短路實例
        System.out.println("--------------- How many [Inside Lambda] will be printed?");
        list3.stream().mapToInt(x->{
            System.out.println("Inside Lambda...."+x);
            return x.length();}
        ).filter(x->x==5).findFirst().ifPresent(System.out::println);//print number

        //說明: stream()的運作，是每一個都先從頭走到尾。 findFirst滿足之後，就會短路，後面的都不會再執行了。如同 if中的 ||

        System.out.println("--------------- Wrong");
        List<String> distincList = Arrays.asList("Test1 Test2 Test3","Test2 Test3","Test1 Test3","Test4 Test1");
        distincList.stream().map(x->x.split(" ")).distinct().collect(Collectors.toList()).forEach(System.out::println); //Wrong
        System.out.println("--------------- Wrong");
        distincList.stream().map(x->x.split(" ")).collect(Collectors.toList()).forEach(x->Arrays.asList(x).forEach(System.out::println)); //GOOD
        System.out.println("--------------- Using flatMap");
        //Stream<String[]>  ==> Stream<String>
        distincList.stream().map(x->x.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("--------------- ");





    }
}
