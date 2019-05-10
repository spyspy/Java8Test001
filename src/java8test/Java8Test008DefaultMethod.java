package java8test;

public class Java8Test008DefaultMethod extends MyInterface1Impl implements MyInterface1,MyInterface2 {

    //Dealing with two identical default method form two Interfaces.
    @Override
    public void myDefaultMethod(){
        MyInterface1.super.myDefaultMethod();// Actual execution location
        MyInterface2.super.myDefaultMethod();// Actual execution location
    };

    public static void main(String[] args) {
        //What is default method?
        Java8Test008DefaultMethod myClass = new Java8Test008DefaultMethod();
        myClass.myDefaultMethod();

        //Instance class is more concrete. So priority is higher.


    }
}

interface MyInterface1{
    default void myDefaultMethod(){
        System.out.println("running myDefaultMethod1");
    }
}

interface MyInterface2{
    default void myDefaultMethod(){
        System.out.println("running myDefaultMethod2");
    }
}

//Impl
class MyInterface1Impl{
    public void myDefaultMethod(){
        System.out.println("running MyInterface1Impl");
    }
}