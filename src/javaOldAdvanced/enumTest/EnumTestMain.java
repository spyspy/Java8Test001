package javaOldAdvanced.enumTest;

import java.util.*;

public class EnumTestMain {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        MyObject[] myobj1 = MyObject.values();
        Map<String,String> myMap = new HashMap<>();


        myList.add("List1");
        myList.add("List2");
        myList.add("List3");


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
            System.out.println("Map entrySet: "+sss.getKey());
            System.out.println("Map entrySet: "+sss.getValue());
        }

        //Print your map
        for(String str : myMap.keySet()){
            System.out.println("Map keySet : "+str.toString());
            System.out.println("Map keySet : "+myMap.get(str).toString());
        }

        //Print your map in Java8
        myMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

    }
}
