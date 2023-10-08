package javaAdvanced.reflection;

import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws Exception{
        TestHome th = new TestHome();
        getJob(th,TestHome.class,"getT2",new Test2());

    }

    static <T,J> void getJob(TestHome th, Class<T> clazz,String methodName,J j) throws Exception {
        Method[] meds = clazz.getDeclaredMethods();
        for(Method mm:meds ){
            System.out.println(mm.getName());
        }

        System.out.println("----------------------");

        Method met = clazz.getDeclaredMethod(methodName);
        System.out.println(met.getName());

        J ob = (J) met.invoke(th);
        System.out.println(ob.getClass());


        System.out.println("----------------------");
        Method[] meds2 =  ob.getClass().getDeclaredMethods();
        for(Method mm:meds2 ){
            System.out.println(mm.getName());
        }

        System.out.println("----------------------");



    }

}

class TestHome{
    Test1 t1 = new Test1();
    Test2 t2 = new Test2();

    public Test1 getT1() {
        return t1;
    }

    public void setT1(Test1 t1) {
        this.t1 = t1;
    }

    public Test2 getT2() {
        return t2;
    }

    public void setT2(Test2 t2) {
        this.t2 = t2;
    }
}

class Test1{
    String test1p;

    public String getTest1p() {
        return test1p;
    }

    public void setTest1p(String test1p) {
        this.test1p = test1p;
    }
}

class Test2{
    String test2p;

    public String getTest2p() {
        return test2p;
    }

    public void setTest2p(String test2p) {
        this.test2p = test2p;
    }
}