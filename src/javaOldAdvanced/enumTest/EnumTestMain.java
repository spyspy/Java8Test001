package javaOldAdvanced.enumTest;

import java.util.*;

public class EnumTestMain {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        MyObject[] myobj1 = MyObject.values();
        Map<String,String> myMap = new HashMap<>();


        myList.add("GOGO1");
        myList.add("GOGO2");
        myList.add("GOGO3");


        System.out.println(MyObject.values());

        System.out.println(myobj1);

        int countV = 0;

        //Build a Map
        for(MyObject w:myobj1){

            System.out.println("W:"+w.name());
            myMap.put(w.name(),myList.get(countV));
            countV++;
        }

        //Print your map
        for(Map.Entry<String,String> sss : myMap.entrySet()){
            System.out.println("Map:"+sss.getKey());
            System.out.println("Map:"+sss.getValue());
        }


    }
}
