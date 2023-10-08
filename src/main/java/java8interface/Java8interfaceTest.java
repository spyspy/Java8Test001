package java8interface;

public class Java8interfaceTest {
    public static void main(String[] args) {

        /*
         * Reference:
         * https://beginnersbook.com/2017/10/java-8-interface-changes-default-method-and-static-method/
         *
         * */


        MyInterface t1 = new TestClass1();
        MyInterface t2 = new TestClass2();
        MyInterface t3 = new TestClass3();

        t1.interfaceAction1("");
        t1.interfaceAction2("");
        t1.interfaceAction3("");
        t1.defaultNewMethod();

        t2.interfaceAction1("");
        t2.interfaceAction2("");
        t2.interfaceAction3("");
        t2.defaultNewMethod();
//        t3.interfaceAction1("");
//        t3.interfaceAction2("");
//        t3.interfaceAction3("");

        MyInterface.staticNewMethod();

    }
}
