package javaAdvanced.enumTest;

import java.util.*;

public class EnumTest1 {

    // 建立自己 MyEnumObject
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        // Enum Values is a array
        MyEnumObject[] myEnumObj1 = MyEnumObject.values();
        System.out.println("MyEnumObject.values():"+ MyEnumObject.values());
        System.out.println(myEnumObj1);

        Map<String,String> myMap = new HashMap<>();
        myList.add("List1");
        myList.add("List2");
        myList.add("List3");
        myList.add("List4");

        int index = 0;

        //Build a Map
        System.out.println("-------Print myEnumObj1 --------------V1");
        for(MyEnumObject w : myEnumObj1){
            System.out.println("myEnumObj1:"+w.name());
            myMap.put(w.name(),myList.get(index));
            index++;
        }

        System.out.println("-------Print MAP --------------V1");

        //Print your map
        // .entrySet() to .Entry<?,?>
        for(Map.Entry<String,String> sss : myMap.entrySet()){
            System.out.println("Map myMap: "+sss);
            System.out.println("Map entrySet.key: "+sss.getKey());
            System.out.println("Map entrySet.value: "+sss.getValue());
        }

        System.out.println("-------Print MAP --------------V2");

        // Print your map 取得 Map 內容全部的key
        for(String str : myMap.keySet()){
            System.out.println("Map keySet : "+str.toString());
            // 用key取得value
            System.out.println("Map keySet : "+myMap.get(str).toString());
        }

        System.out.println("-------Print MAP-------JAVA 8 forEach()-----");

        //Print your map in Java8
        myMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

        //Print your map in Java8
        myMap.forEach((key, value) -> System.out.println(key + " | " + value));

    }
}
