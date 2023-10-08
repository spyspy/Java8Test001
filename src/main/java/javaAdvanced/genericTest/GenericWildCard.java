package javaAdvanced.genericTest;

import java.util.ArrayList;
import java.util.List;

public class GenericWildCard {
    public static void main(String[] args) {

        //1 .Upper Bounded Wildcards
        List<Apple> listA = new ArrayList<>();
        listA.add(new Apple(1));
        listA.add(new Apple(2));
        listA.add(new Apple(3));
        upperWildcards(listA);

        List<Banana> listB = new ArrayList<>();
        listB.add(new Banana(1));
        listB.add(new Banana(2));
        listB.add(new Banana(3));
        upperWildcards(listB);

        List<Fruit> listF = new ArrayList<>();
        listF.add(new Fruit());
        listF.add(new Fruit());
        listF.add(new Fruit());
        upperWildcards(listF);

        //2. Lower Bounded Wildcards:
        lowerWildcards(listA);
        //lowerWildcards(listB);//It wont work!!!
        lowerWildcards(listF);

    }

    static void upperWildcards(List<? extends Fruit> list){
        System.out.println(list);
//        for(Fruit ff : list){
//            ff.goFruit();
//        }
        list.stream().forEach(ff ->((Fruit) ff).goFruit());
    }

    static void lowerWildcards(List<? super Apple> list){
        System.out.println(list);
    }
}


class Apple extends Fruit{
    int appleNo;
    Apple(int i){
        this.appleNo=i;
    }
    public void goApple(){

    }

    @Override
    public void goFruit(){
        System.out.println("Apple goFruit : "+appleNo);
    }
}


class Banana extends Fruit{
    int bananaNo;
    Banana(int i){
        this.bananaNo=i;
    }
    public void goBanana(){

    }

    @Override
    public void goFruit(){
        System.out.println("Banana goFruit : "+bananaNo);
    }
}

class Fruit{
    public void goFruit(){
        System.out.println("Parent goFruit");
    }
}


