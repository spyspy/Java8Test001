package javaAdvanced.enumTest;

import java.util.*;

public class EnumTest1 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        MyEnumObject[] myEnumObj1 = MyEnumObject.values();
        Map<String,String> myMap = new HashMap<>();


        myList.add("List1");
        myList.add("List2");
        myList.add("List3");
        myList.add("List4");


        System.out.println("MyEnumObject.values():"+ MyEnumObject.values());

        System.out.println(myEnumObj1);

        int countV = 0;

        //Build a Map
        for(MyEnumObject w : myEnumObj1){
            System.out.println("W:"+w.name());
            myMap.put(w.name(),myList.get(countV));
            countV++;
        }

        System.out.println("-------Print MAP --------------V1");


        //Print your map
        for(Map.Entry<String,String> sss : myMap.entrySet()){
            System.out.println("Map entrySet: "+sss.getKey());
            System.out.println("Map entrySet: "+sss.getValue());
        }

        System.out.println("-------Print MAP --------------V2");

        //Print your map
        for(String str : myMap.keySet()){
            System.out.println("Map keySet : "+str.toString());
            System.out.println("Map keySet : "+myMap.get(str).toString());
        }

        System.out.println("-------Print MAP-------JAVA 8-----");

        //Print your map in Java8
        myMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        //Print your map in Java8
        myMap.forEach((key, value) -> System.out.println(key + " | " + value));

    }
}
