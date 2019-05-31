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
        System.out.println("----------------------");

        //按照長度排序(由長度小 到 長度大)
        List<String> list2 = Arrays.asList("coco","appple","EcoecoecoA2");
        Collections.sort(list2, (it2,it1)->it2.length()-it1.length());
        System.out.println(list2);
        System.out.println("----------------------");

        //按照長度排序(由長度大 到 長度小)
        List<String> list3 = Arrays.asList("coco","appple","EcoecoecoA");
        Collections.sort(list3, (ita2,ita1)->ita1.length()-ita2.length());
        System.out.println(list3);
        System.out.println("----------------------");

        //方法引用
        List<String> list4 = Arrays.asList("coco","appple","EcoecoecoA444");
        Collections.sort(list4, Comparator.comparingInt(String::length));
        System.out.println(list4);
        System.out.println("----------------------");

        List<String> list5 = Arrays.asList("coco","appple","EcoecoecoA555");
        Collections.sort(list5, Comparator.comparingInt(String::length).reversed());
        System.out.println(list5);
        System.out.println("----------------------");

        //lambda參數強轉   why??  移除 reversed()方法?
        List<String> list6 = Arrays.asList("coco","appple","EcoecoecoA666");
        Collections.sort(list6, Comparator.comparingInt((String item) -> item.length()));//可加.reversed()
                                                        // why need String here?
                                                        // parameter ToIntFunction<? super T> keyExtractor
                                                        // T以上的類都可，因此無法推論
        System.out.println(list6);
        System.out.println("----------------------");
        List<String> list7 = Arrays.asList("coco","appple","EcoecoecoA777");
        Collections.sort(list7, Comparator.comparingInt((item) -> item.length()));//不可加item.length() 會不能推論class
        System.out.println(list7);
        System.out.println("----------------------");
        List<String> list8 = Arrays.asList("coco","appple","EcoecoecoA888");
        Collections.sort(list8, Comparator.comparingInt((Object item) -> 1).reversed());
        System.out.println(list8);
        System.out.println("----------------------");

    }
}
