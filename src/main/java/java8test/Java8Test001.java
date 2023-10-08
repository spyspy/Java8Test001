package java8test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Test001 {
    public static void main(String[] args) {

        //Lambda Expression. A
        List<Integer> myList = Arrays.asList(1,2,5,8,99);
        for(Integer a:myList) {
            System.out.println(a);
        }
        System.out.println("===========================");
        //Internal iterator vs External iterator.
        myList.forEach(a->System.out.println(a));
        System.out.println("===========================");

        List<String> myList2 = Arrays.asList("test one","hello two","koko three");

        //Normal Lambda for instance
        myList2.stream().map(item -> item.toUpperCase()).forEach(item->System.out.println(item));
        //Lambda by method reference for instance.
        //note: there are two ways to use method reference in this case.
        myList2.stream().map(String::toUpperCase).forEach(System.out::println);

        //Function Class
        Function<String,String> myfun = String::toUpperCase;// class(憿�) :: isntance method(撖虫�瘜�)
        System.out.println(myfun.getClass().getInterfaces()[0]);

        //There are 4 ways to use method reference;


        // Body Test
        System.out.println("=Body Test==========================");

        Body b1 = new Body("h1","hs1","l1");
        Body b2 = new Body("h2","hs2","l2");
        Body b3 = new Body("h3","hs3","l3");
        List<Body> mylistBody = new ArrayList<>();
        mylistBody.add(b1);
        mylistBody.add(b2);
        mylistBody.add(b3);
        System.out.println(mylistBody);
        // 將 Body的List 當中的 getHands 內容取出，轉變成一個新的 String List 或是 String Set
        List<String> collect = mylistBody.stream().map(Body::getHands).collect(Collectors.toList());
        System.out.println(collect);
        collect.stream().map(String::toUpperCase).forEach(System.out::println);

        // keySet
        System.out.println("=keySet Test==========================");

        Map<String, Map<String,Body>> mapBody = new HashMap<>();
        Map<String,Body> map1 = new HashMap<>();
        map1.put("map1",b1);
        Map<String,Body> map2 = new HashMap<>();
        map2.put("map2",b2);
        Map<String,Body> map3 = new HashMap<>();
        map2.put("map3",b3);
        mapBody.put("aa1",map1);
        mapBody.put("aa2",map2);
        mapBody.put("aa3",map3);

        // 把所有 mapBody 的 Key印出來
        System.out.println("=把所有 mapBody 的 Key印出來==========================");

        mapBody.keySet().stream().forEach(System.out::println);

    }
}

class Body{
    String head;
    String hands;
    String legs;

    public Body(String head, String hands, String legs) {
        this.head = head;
        this.hands = hands;
        this.legs = legs;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHands() {
        return hands;
    }

    public void setHands(String hands) {
        this.hands = hands;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }
}
