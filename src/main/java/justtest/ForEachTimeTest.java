package justtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForEachTimeTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> mylist = new ArrayList<>();
        for(int i= 1;i<=1000000;i++){
            mylist.add(""+i);
        }
        System.out.println("ForEachTimeTest.main");
        long start = System.nanoTime();
        System.out.println("Start Time:: "+start);

//        Thread.sleep(1000);
        for(String ss : mylist){
            System.out.println("ss "+ss);
        }

        long elapsedTime = System.nanoTime() - start;
        // Get elapsed time in seconds

        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
        System.out.println("End Time(second):: "+elapsedTimeInSecond);
        // TimeUnit
        long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("End Time(second):: "+convert);

        System.out.println("mylist.size(): "+mylist.size());



    }
}
