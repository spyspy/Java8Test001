package javaAdvanced.genericTest;

import java.util.*;

public class GenericTest {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("WOW","TEST");

        List<String> list2 = new ArrayList<>();

        List<? extends List<String>> list3 = new ArrayList<>();


        //2020/06/10 Test
        Box<String> stringBox = new Box<>();
        Box rawBox = stringBox;
        rawBox.set(8);  // warning: unchecked invocation to set(T)



        Box<Integer> bi;
        bi = createBox();
    }

    static Box createBox(){
        return new Box<Integer>();
    }
}

class GenericObject1<T,K>{
    private T obj1;
    private K obj2;

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public K getObj2() {
        return obj2;
    }

    public void setObj2(K obj2) {
        this.obj2 = obj2;
    }
}

class GenericTest2<T>{
    private T obj1;

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public void test01(List<? extends List> list){

    }

    public <E> void test02(List<? extends E> list){

    }

    public <E> void test03(List<E> list){

    }
    public void test04(Class<? extends Collection<?>> list){

    }
}

class Box<T> {
    public void set(T t) { /* ... */

        System.out.println("Box set();"+t.toString());
    }

}