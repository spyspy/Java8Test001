package java8test.stream;

import java.util.*;

public class Java8TestStream008{
    public static void main(String[] args) {
        //Video 26
        //Comparator
        //myComparator.thenComparing().thenComparing(); ... etc
        List<String> list = Arrays.asList("coco","appple","EcoecoecoB");
        //按照字母排序
        Collections.sort(list);
        System.out.println(list);
        //按照長度排序(由長度小 到 長度大)
        List<String> list2 = Arrays.asList("coco","appple","EcoecoecoA2");
        Collections.sort(list2, (it2,it1)->it2.length()-it1.length());
        System.out.println(list2);
        //按照長度排序(由長度大 到 長度小)
        List<String> list3 = Arrays.asList("coco","appple","EcoecoecoA");
        Collections.sort(list3, (ita2,ita1)->ita1.length()-ita2.length());
        System.out.println(list3);

        //方法引用
        List<String> list4 = Arrays.asList("coco","appple","EcoecoecoA8");
        Collections.sort(list4, Comparator.comparingInt(String::length));
        System.out.println(list4);

        List<String> list5 = Arrays.asList("coco","appple","EcoecoecoA8e");
        Collections.sort(list5, Comparator.comparingInt(String::length).reversed());
        System.out.println(list5);

        //lambda參數強轉   why??  移除 reversed()方法?
        List<String> list6 = Arrays.asList("coco","appple","EcoecoecoA8eCoco");
        Collections.sort(list6, Comparator.comparingInt((String item) -> item.length()));
        System.out.println(list6);



    }
}
